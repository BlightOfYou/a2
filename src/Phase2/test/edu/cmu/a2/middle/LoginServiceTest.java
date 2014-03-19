/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cmu.a2.middle;

import edu.cmu.a2.dto.Session;
import java.net.MalformedURLException;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Micah
 */
public class LoginServiceTest {
    
    /**
     * Test of Login method, of class LoginService.
     */
    @Test
    public void testLogin() throws MalformedURLException, LoginService.AuditLogException {
        String Username = "micah";
        String Password = "password";
        LoginService instance = new LoginService("localhost", 3306);
        Session result = null;
        try {
            result = instance.Login(Username, Password);
        } catch (LoginService.InvalidLoginException ex) {
            Assert.fail("Failed to login");
        }
        
        Assert.assertNotNull(result);
        Assert.assertEquals(Username, result.getUsername());
    }
    
    @Test
    public void testInvalidLogin() throws MalformedURLException, LoginService.AuditLogException {
        String Username = "micah";
        String Password = "bleh";
        LoginService instance = new LoginService("localhost", 3306);
        Session result = null;
        
        boolean invalidExceptionCaught = false;
        try {
            result = instance.Login(Username, Password);
        } catch (LoginService.InvalidLoginException ex) {
            invalidExceptionCaught = true;
        }
        
        Assert.assertTrue(invalidExceptionCaught);
        Assert.assertNull(result);

    }

    /**
     * Test of Logout method, of class LoginService.
     */
    @Test
    public void testLogout() throws LoginService.AuditLogException {
        String Username = "micah";
        String Password = "password";
        LoginService instance = new LoginService("localhost", 3306);
        Session result = null;
        try {
            result = instance.Login(Username, Password);
        } catch (LoginService.InvalidLoginException ex) {
            Assert.fail("Failed to login");
        }
        
        Assert.assertNotNull(result);
        
        instance.Logout(result);
    }
    
}
