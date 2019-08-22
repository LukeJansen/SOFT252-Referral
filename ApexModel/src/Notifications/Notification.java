/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notifications;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author lpjan
 */
public class Notification implements Serializable{
    
    private int id;
    private final String userID;
    private final String title;
    private final String text;
    private final NotificationType type;
    
    /**
     * The default constructor for the Notification class.
     * @param id Notification ID
     * @param userID User ID
     * @param title Title for Notification Box
     * @param text Text for Notification Box
     * @param type Type of Notification.
     */
    public Notification (int id, String userID, String title, String text, NotificationType type){
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.text = text;
        this.type = type;
    }
    
    /**
     * Shows this notification to the user.
     */
    public void Show(){
        if (type == NotificationType.INFO){
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
        }
        else if (type == NotificationType.WARNING){
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.WARNING_MESSAGE);
        }        
    }

    /**
     * Returns the ID of the user this notification
     * is attached to.
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Returns the ID of this notification.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of this notification.
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }
}