/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

import Resources.Resource;
import Resources.ResourceStatus;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class User implements java.io.Serializable {
    
    private String userID;
    private String password;
    
    private String name;
    private boolean locked;
    
    public User(){
        userID = null;
        password = null;
        name = null;
        locked = false;
    }
    
    public User(String UID){
        userID = UID;
        password = null;
        name = null;
        locked = false;
    }
    
    public User(String UID, String pass){
        userID = UID;
        password = pass;
        name = null;
        locked = false;
    }
    
    public User(String UID, String pass, String cname){
        userID = UID;
        password = pass;
        name = cname;
        locked = false;
    }
    
    public void Lock(ArrayList<Resource> list){
        locked = false;
        
        for (Resource resource : list){
            if (resource.getStatus() != ResourceStatus.AVAILABLE && (resource.getDueDate() - System.currentTimeMillis() < (-86400000 * 20))){
                locked = true;
            }
        }
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

    public boolean isLocked() {
        return locked;
    }
}
