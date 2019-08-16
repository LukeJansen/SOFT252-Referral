/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Notifications.*;
import Resources.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lpjan
 */
public class ResourceHandler {
    
    public ArrayList<Resource> resourceList = new ArrayList<Resource>();
    private ApexSystem system;
    
    public ResourceHandler(ApexSystem system){
        this.system = system;
        
        Load();
    }
    
    private void Load(){
        
        File folder = new File("data/resources/");
        File[] resourceFiles = folder.listFiles();
        
        for (File file : resourceFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 resourceList.add((Resource)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (InvalidClassException c) {
                System.out.println("Resource class changed and file is no longer valid!");
                System.out.println("File deleted: " + file.delete());
                return;
            }
            catch (IOException i) {
                i.printStackTrace();
                 return;
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } 
        }
        
        System.out.println("Loaded " + resourceList.size() + " Resources!");        
    }
    
    public void Save(){
     
        for (Resource resource : resourceList){
        
            try {
                File file = new File("data/resources/" + resource.getID() + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(resource);
                out.close();
                fileOut.close();
                System.out.printf("\nSerialized data for resource " + resource.getID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    } 
    
    public void AddNotifications(String userID){
        NotificationHandler notificationHandler = system.getNotificationHandler();
        
        for (Resource resource : resourceList){
            if (resource.getLoanNoticeID() != 0){
                if ((resource.getDueDate() - System.currentTimeMillis() < (-86400000 * 20))){
                    notificationHandler.Add(userID, "Overdue Ban", "The resource " + resource.getName() + " has been overdue for over 20 days. Therefore your account has been locked until this book is returned.", NotificationType.WARNING);
                }
                else if (System.currentTimeMillis() > resource.getDueDate()){    
                    notificationHandler.Add(userID, "Overdue Notification", "The resource " + resource.getName() + " is now overdue.", NotificationType.INFO);
                }
            }
            else if ((resource.getDueDate() - System.currentTimeMillis()) < (86400000 * 7)){
                notificationHandler.Add(userID, "Due Date Warning", "The resource " + resource.getName() + " will be overdue in less than one week.", NotificationType.INFO);
            }
        }
    } 
}
