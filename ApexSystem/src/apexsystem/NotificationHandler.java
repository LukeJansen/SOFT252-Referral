/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Notifications.*;
import Resources.*;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class NotificationHandler {
    
    public ArrayList<Notification> notificationList = new ArrayList<Notification>();
    private ResourceHandler resourceHandler;
    
    public NotificationHandler(ResourceHandler resourceHandler){
        this.resourceHandler = resourceHandler;
    }
    
    public void GenerateNotifications(){
        notificationList.clear();
        
        for (Resource resource : resourceHandler.resourceList){
            if (resource.getStatus() != ResourceStatus.AVAILABLE){
                if ((resource.getDueDate() - System.currentTimeMillis() < (-86400000 * 20))){
                    notificationList.add(new Notification(resource.getLoanedUser(), "Overdue Book Block", "The resource " + resource.getName() + " has been overdue for more than 20 days. You are now blocked from borrowing more resources until this item has been returned", NotificationType.WARNING));
                }
                else if (System.currentTimeMillis() > resource.getDueDate()){    
                    notificationList.add(new Notification(resource.getLoanedUser(), "Overdue Book", "The resource " + resource.getName() + " is now overdue. You will be charged 10p per day and after 20 days you will be blocked from borrowing more resources.", NotificationType.WARNING));
                }
                else if ((resource.getDueDate() - System.currentTimeMillis()) < (86400000 * 7)){
                    notificationList.add(new Notification(resource.getLoanedUser(), "One Week Warning", "The resource " + resource.getName() + " will be overdue in less than one week.", NotificationType.INFO));
                }
            }
            
            if (resource.isReturnRequested()) notificationList.add(new Notification(resource.getLoanedUser(), "Return Request", "An Admin has requested you return the resource titled " + resource.getName() + ".", NotificationType.INFO));
        }   
        
        System.out.println("Loaded " + notificationList.size() + " notifications!");
    }
    
    public int GetNotificationCount(String UserID){
        int count = 0;
        System.out.println(notificationList.size());
        
        for (Notification notification : notificationList){
            System.out.println("loop");
            if (notification.getUserID().equals(UserID)) {
                System.out.println("Add");
                count += 1;
            }
        }
        
        return count;
    }
}
