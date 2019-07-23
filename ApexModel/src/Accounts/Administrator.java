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
public class Administrator extends User{
    
    public Administrator(){
        super();
    }
    
    public Administrator(String UID){
        super(UID);
    }
    
    public Administrator(String UID, String pass){
        super(UID, pass);
    }
    
    public void printMessage(){
        System.out.println("Test");
    }
    
}
