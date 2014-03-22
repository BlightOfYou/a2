/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu.a2.dto;

/**
 *
 */
public class Session {

    private long Id;
    private String serverHost;
    private int UserId;  
    private String Username;
    private long LoginTime;

    /**
     * @return the Id
     */
    public long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(long Id) {
        this.Id = Id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the LoginTime
     */
    public long getLoginTime() {
        return LoginTime;
    }

    /**
     * @param LoginTime the LoginTime to set
     */
    public void setLoginTime(long LoginTime) {
        this.LoginTime = LoginTime;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }    
}
