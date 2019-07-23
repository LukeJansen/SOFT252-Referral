/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Accounts.*;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class LoginHandler {
    
    ArrayList<User> userList = new ArrayList<User>();
    
    public LoginHandler(){
        LoadLogins();
    }
    
    public User Login(String username, String password){

        for (int i = 0; i < userList.size(); i++){
            User user = userList.get(i);
            
            if (username.equals(user.getUserID()) && password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
    
    private void LoadLogins(){
        Administrator admin = new Administrator("0000","123");
        userList.add(admin);
        
        System.out.println("Loaded " + userList.size() + " logins!");
    }
    
}
