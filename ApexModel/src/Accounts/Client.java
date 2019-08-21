/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accounts;

/**
 * The Client class holds all information
 * about Client accounts.
 * @author lpjan
 */
public class Client extends User{
    
    /**
     * Passes this constructor up to the User class.
     */
    public Client(){
        super();
    }
    
    /**
     * Passes this constructor up to the User class.
     * @param UID User ID
     * @param pass Password
     * @param cname User's Name
     */
    public Client(String UID, String pass, String cname){
        super(UID, pass, cname);
    }
    
}
