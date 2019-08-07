/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Accounts.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class LoginHandler {
    
    ArrayList<User> userList = new ArrayList<User>();
    
    public LoginHandler(){
        LoadLogins();
        //SaveLogins();
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
        
//        userList.add(new Administrator("0000", "pass", "Administrator"));
//        userList.add(new Client("1001", "pass", "User 1"));
//        userList.add(new Client("1002", "pass", "User 2"));
//        userList.add(new Client("1003", "pass", "User 3"));
//        userList.add(new Client("1004", "pass", "User 4"));
//        userList.add(new Client("1005", "pass", "User 5"));
        
        File folder = new File("users/");
        File[] userFiles = folder.listFiles();
        
        for (File file : userFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 userList.add((User)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (IOException i) {
                 i.printStackTrace();
                 return;
            } 
            catch (ClassNotFoundException c) {
                 System.out.println("Employee class not found");
                 c.printStackTrace();
                return;
            }
        }
        
        System.out.println("Loaded " + userList.size() + " logins!");        
    }
    
    public void SaveLogins(){
     
        for (User user : userList){
        
            try {
                File file = new File("users/" + user.getUserID() + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(user);
                out.close();
                fileOut.close();
                System.out.printf("\nSerialized data for user " + user.getUserID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    } 
}
