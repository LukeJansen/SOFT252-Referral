/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 *
 * @author lpjan
 */
public class User implements java.io.Serializable {
    
    private String userID;
    private String password;
    
    public User(){
        userID = null;
        password = null;
    }
    
    public User(String UID){
        userID = UID;
        password = null;
    }
    
    public User(String UID, String pass){
        userID = UID;
        password = pass;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }
    
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
