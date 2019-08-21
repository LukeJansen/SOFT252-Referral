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
 * The User class is the base template for
 * all user and is then extended by the
 * specific user types.
 * @author lpjan
 */
public class User implements java.io.Serializable {
    
    private String userID;
    private String password;
    
    private String name;
    private boolean locked;
    
    /**
     * Default constructor for no inputted information.
     * Should not be used.
     */
    public User(){
        userID = null;
        password = null;
        name = null;
        locked = false;
    }
    
    /**
     * Default constructor for all user accounts.
     * @param UID User ID
     * @param pass Password
     * @param cname User's Name
     */
    public User(String UID, String pass, String cname){
        userID = UID;
        password = pass;
        name = cname;
        locked = false;
    }
    
    /**
     * Checks whether this user's account should be locked
     * due to overdue books over the 20 day limit.
     * @param list Resource List
     */
    public void Lock(ArrayList<Resource> list){
        locked = false;
        
        for (Resource resource : list){
            if (resource.getStatus() != ResourceStatus.AVAILABLE && (resource.getDueDate() - System.currentTimeMillis() < (-86400000 * 20))){
                locked = true;
            }
        }
    }

    /**
     * Returns the User's ID.
     * @return User ID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Returns the user's Password.
     * @return Password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the User's ID.
     * @param userID User ID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Sets the User's Password.
     * @param password Password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Returns the User's name.
     * @return Name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the User's name.
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a boolean value depending on
     * whether the user's account is locked.
     * @return isLocked
     */
    public boolean isLocked() {
        return locked;
    }
}
