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
    
    public ArrayList<User> userList = new ArrayList<>();
    
    public LoginHandler(){
        Load();
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
    
    private void Load(){
        
        
        File folder = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/users/");
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
                 return;
            } 
            catch (ClassNotFoundException c) {
                 System.out.println("Employee class not found");
                return;
            }
        }
        
        if (userList.isEmpty()) CreateDefaultLogins();
        
        System.out.println("Loaded " + userList.size() + " logins!");        
    }
    
    public void Save(){
     
        for (User user : userList){
        
            try {
                File file = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/users/" + user.getUserID() + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(user);
                out.close();
                fileOut.close();
                System.out.printf("\nSerialized data for user " + user.getUserID());
            } catch (IOException e) {
            }
        }   
    } 
    
    public void CreateDefaultLogins(){
        userList.add(new Administrator("0000", "pass", "Administrator"));
        userList.add(new Client("1001", "pass", "User 1"));
        userList.add(new Client("1002", "pass", "User 2"));
        userList.add(new Client("1003", "pass", "User 3"));
        userList.add(new Client("1004", "pass", "User 4"));
        userList.add(new Client("1005", "pass", "User 5"));
    }
}
