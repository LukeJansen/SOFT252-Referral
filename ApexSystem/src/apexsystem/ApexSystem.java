/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Forms.*;
import Notifications.*;

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
        
        apexSystem.Setup();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                apexSystem.Close();
            }
        }, "Shutdown-thread"));
    }
    
    private void Setup(){
        
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
