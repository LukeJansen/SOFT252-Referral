/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notifications;

import javax.swing.JOptionPane;

/**
 *
 * @author lpjan
 */
public class Notification {
    
    private String userID;
    private String title;
    private String text;
    private NotificationType type;
    
    public Notification (String userID, String title, String text, NotificationType type){
        this.userID = userID;
        this.title = title;
        this.text = text;
        this.type = type;
    }
    
    public void Show(){
        if (type == NotificationType.INFO){
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
        }
        else if (type == NotificationType.WARNING){
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.WARNING_MESSAGE);
        }        
    }

    public String getUserID() {
        return userID;
    }
}