/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Notifications.*;
import java.io.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 *
 * @author lpjan
 */
public class NotificationHandler {
    
    public ArrayList<Notification> notificationList = new ArrayList<Notification>();
    private ResourceHandler resourceHandler;
    
    public NotificationHandler(ResourceHandler resourceHandler){
        this.resourceHandler = resourceHandler;
        
        Load();
    }
    
    private void Load(){
        
        File folder = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/notifications/");
        File[] resourceFiles = folder.listFiles();
        
        for (File file : resourceFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 notificationList.add((Notification)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (IOException i) {
                 i.printStackTrace();
                 return;
            } 
            catch (ClassNotFoundException c) {
                 System.out.println("Notification class not found");
                 c.printStackTrace();
                return;
            }
        }
        
        System.out.println("Loaded " + notificationList.size() + " Notifications!");        
    }
    
    public void Save(){
        
        File folder = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/notifications/");
        
        for(File f: folder.listFiles()) f.delete();
     
        for (Notification notification : notificationList){
        
            try {
                File file = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/notifications/" + notification.getId() + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(notification);
                out.close();
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    } 
    
    public int GetNotificationCount(String UserID){
        int count = 0;
        
        for (Notification notification : notificationList){
            if (notification.getUserID().equals(UserID)) {
                count += 1;
            }
        }
        
        return count;
    }
    
    public void Add(String userID, String title, String text, NotificationType type){
        
        int max = 1;
        
        for (Notification notification : notificationList){
            if (notification.getId() > max) max = notification.getId();            
        }
        
        int id = max;
        
        notificationList.add(new Notification(id, userID, title, text, type));
    }
    
    public void ShowForUser(String userID){
        try {
            for (Notification notification : notificationList){
                if (notification.getUserID().equals(userID)){
                    notification.Show();
                }
            }

            for (Notification notification : notificationList){
                if (notification.getUserID().equals(userID)) notificationList.remove(notification);
            }
        }
        catch (ConcurrentModificationException e){
            System.out.println("Concurrent Modification Caught!");
        }
    }
}
