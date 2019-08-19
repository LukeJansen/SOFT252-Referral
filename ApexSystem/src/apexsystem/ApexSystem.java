/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Forms.*;
import Notifications.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lpjan
 */
public class ApexSystem {
    
    private LoginHandler loginHandler;
    private ResourceHandler resourceHandler;
    private NotificationHandler notificationHandler;
    private RequestHandler requestHandler;
    
    private LoginForm loginForm;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        ApexSystem apexSystem = new ApexSystem();
        
        if (!Files.exists(Paths.get(System.getenv("LOCALAPPDATA") + "/Apex Library System/"))) apexSystem.FirstSetup();

        apexSystem.Setup();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                apexSystem.Close();
            }
        }, "Shutdown-thread"));
    }
    
    private void FirstSetup(){
          
        boolean main = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/").mkdir();
        boolean logs = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/logs/").mkdir();
        boolean data = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/").mkdir();
        boolean resources = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/resources").mkdir();
        boolean users = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/users").mkdir();
        boolean notifications = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/notifications").mkdir();
        boolean requests = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/requests").mkdir();

        if (main && data && logs && resources && users && notifications && requests){
            System.out.println("All Folders Created!");
        }
        else {
            System.out.println("Folder Creation Failed!");
            System.out.println("Folder Creation Main: " + main);
            System.out.println("Folder Creation Logs: " + logs);
            System.out.println("Folder Creation Data: " + data);
            System.out.println("Folder Creation Users: " + users);
            System.out.println("Folder Creation Resources: " + resources);
            System.out.println("Folder Creation Notifications: " + notifications);
            System.out.println("Folder Creation Requests: " + requests);
        }
    }
    
    private void Setup(){
        
        try {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            
            File file = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/logs/" + dateFormat.format(date)+ ".txt");
            
            PrintStream fileOut = new PrintStream(file);
            
            System.setOut(fileOut);
        } catch (FileNotFoundException ex) {
            System.out.println("Logs folder not found!");
            ex.printStackTrace();
        }
        
        
        
        loginHandler = new LoginHandler();
        resourceHandler = new ResourceHandler(this);
        notificationHandler = new NotificationHandler(resourceHandler);
        requestHandler = new RequestHandler();
        
        loginForm = new LoginForm(this);
        
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
    }
    
    public void Logout(){
        loginForm.Reset();
        loginForm.setVisible(true);
    }
    
    public void Close(){
        loginHandler.Save();
        resourceHandler.Save();
        requestHandler.Save();
        notificationHandler.Save();
    }

    public LoginHandler getLoginHandler() {
        return loginHandler;
    }

    public ResourceHandler getResourceHandler() {
        return resourceHandler;
    }

    public NotificationHandler getNotificationHandler() {
        return notificationHandler;
    }
    
    public RequestHandler getRequestHandler(){
        return requestHandler;
    }
}
