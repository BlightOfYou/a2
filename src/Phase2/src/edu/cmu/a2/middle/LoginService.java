/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.middle;

import edu.cmu.a2.common.Base64;
import edu.cmu.a2.dto.Session;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class LoginService {

    private static final String HASH_METHOD = "SHA-256";
    private static final String CHARSET = "UTF-8";
    private static final int DEFAULT_BYTECOUNT = 32;

    public static class InvalidLoginException extends Exception {
    }

    public static class AuditLogException extends Exception {
    }

    private String databaseUrl;
    private String host;
    
    public LoginService(String host, int port) {
        databaseUrl =  String.format("jdbc:mysql://%s:%d/loginservice", host, port);
        this.host = host;
    }

    public Session Login(String Username, String Password)
            throws InvalidLoginException, AuditLogException {

        int UserId = -1;
        if ((UserId = IsValidLogin(Username, Password)) < 0) {
            throw new InvalidLoginException();
        }

        Session session = CreateSession(Username, UserId);
        session.setServerHost(host);
        
        WriteLoginAuditLog(session);
        return session;
    }

    public void Logout(Session session) throws AuditLogException {
        WriteLogoutAuditLog(session);
    }

    private int IsValidLogin(String Username, String Password) {
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

            Statement s = DBConn.createStatement();
            String SQLStatement = "SELECT * FROM users WHERE LOWER(username) = LOWER('" + Username + "')";
            ResultSet res = s.executeQuery(SQLStatement);

            // Make sure we got back at least one row
            if (!res.first()) {
                return -1;
            }

            String salt = res.getString("salt");
            String storedHash = res.getString("password");

            String hashedPassword = GenerateHash(salt, Password);

            if (storedHash.equals(hashedPassword)) {
                return res.getInt("user_id");
            }

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | SQLException ex) {
            return -1;
        } finally {
            try {
                if (DBConn != null) {
                    DBConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return -1;
    }

    private Session CreateSession(String Username, int UserId) {
        SecureRandom random = new SecureRandom();

        Session session = new Session();
        
        // Generate a random positive session id
        long sessionId = random.nextLong();
        if(sessionId < 0) { 
            sessionId = sessionId * -1;
        };
        
        session.setId(sessionId);
        session.setUserId(UserId);
        session.setUsername(Username);
        session.setLoginTime(System.currentTimeMillis());

        return session;
    }

    private void WriteLoginAuditLog(Session session) throws AuditLogException {
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

            Statement s = DBConn.createStatement();
            String SQLStatement = "INSERT INTO login_log ( user_id, session_id, "
                    + "login) VALUES (" + Integer.toString(session.getUserId()) + ", "
                    + Long.toString(session.getId()) + ", "
                    + Long.toString(session.getLoginTime()) + ")";

            int res = s.executeUpdate(SQLStatement);

            if (res < 1) {
                throw new AuditLogException();
            }

        } catch (SQLException ex) {
            throw new AuditLogException();
        } finally {
            try {
                if (DBConn != null) {
                    DBConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void WriteLogoutAuditLog(Session session) throws AuditLogException {
        Connection DBConn = null;
        try {
            DBConn = DriverManager.getConnection(databaseUrl, "remote", "remote_pass");

            long logoutTime = System.currentTimeMillis();

            Statement s = DBConn.createStatement();
            String SQLStatement = "INSERT INTO login_log ( user_id, session_id, "
                    + "logout) VALUES (" + Integer.toString(session.getUserId()) + ", "
                    + Long.toString(session.getId()) + ", "
                    + Long.toString(logoutTime) + ")";

            int res = s.executeUpdate(SQLStatement);

            if (res < 1) {
                throw new AuditLogException();
            }

        } catch (SQLException ex) {
            throw new AuditLogException();
        } finally {
            try {
                if (DBConn != null) {
                    DBConn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * *
     * Generates a salted one way hash of the given input string and returns the
     * hashed string.
     *
     * @param input
     * @return
     * @throws NoSuchAlgorithmException
     */
    private String GenerateHash(String salt, String input)
            throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        MessageDigest digest = MessageDigest.getInstance(LoginService.HASH_METHOD);

        // Convert input strings to UTF-8 encoded byte arrays
        byte[] inputBytes = input.getBytes(LoginService.CHARSET);
        byte[] saltBytes = salt.getBytes(LoginService.CHARSET);

        // Salt the hash
        digest.reset();
        digest.update(saltBytes);

        // Hash the input string
        byte[] outputBytes = digest.digest(inputBytes);

        // Convert the salted bytes back to a string
        String outputString = Base64.encodeBytes(outputBytes);

        return outputString;
    }

    /**
     * Generates a random salt string
     *
     * @return
     */
    private String GenerateSalt()
            throws UnsupportedEncodingException {
        return GenerateSalt(LoginService.DEFAULT_BYTECOUNT);
    }

    private String GenerateSalt(int byteCount)
            throws UnsupportedEncodingException {
        SecureRandom random = new SecureRandom();

        // Generate random bytes for salt
        byte[] saltBytes = new byte[byteCount];
        random.nextBytes(saltBytes);

        // Convert salt bytes to string
        String saltString = Base64.encodeBytes(saltBytes);

        return saltString;
    }

    /**
     * When run, this class will generate a password salt and hash for input to
     * a database creation script.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
            throws Exception {
        LoginService login = new LoginService("localhost", 3306);

        String salt = login.GenerateSalt();
        System.out.println("Salt: " + salt);

        String password = "password";
        if (args.length > 1) {
            password = args[1];
        }

        String hashedPassword = login.GenerateHash(salt, password);
        System.out.println("Hash: " + hashedPassword);
    }

}
