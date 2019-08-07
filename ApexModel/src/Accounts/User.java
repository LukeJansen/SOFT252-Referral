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
    
    private String name;
    
    public User(){
        userID = null;
        password = null;
        name = null;
    }
    
    public User(String UID){
        userID = UID;
        password = null;
        name = null;
    }
    
    public User(String UID, String pass){
        userID = UID;
        password = pass;
        name = null;
    }
    
    public User(String UID, String pass, String cname){
        userID = UID;
        password = pass;
        name = cname;
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
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
