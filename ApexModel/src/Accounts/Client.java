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
public class Client extends User{
    
    public Client(){
        super();
    }
    
    public Client(String UID){
        super(UID);
    }
    
    public Client(String UID, String pass){
        super(UID, pass);
    }
    
    public Client(String UID, String pass, String cname){
        super(UID, pass, cname);
    }
    
}
