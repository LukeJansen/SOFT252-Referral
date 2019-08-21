/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 * The Administrator class holds all information
 * about Administrator accounts.
 * @author lpjan
 */
public class Administrator extends User{
    
    /**
     * Passes this constructor up to the User class.
     */
    public Administrator(){
        super();
    }
    
    /**
     * Passes this constructor up to the User class.
     * @param UID User ID
     * @param pass Password
     * @param cname User's Name
     */
    public Administrator(String UID, String pass, String cname){
        super(UID, pass, cname);
    }
    
}
