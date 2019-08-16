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
    private String userID;
    private String title;
    private String text;
    private NotificationType type;
    
    public Notification (int id, String userID, String title, String text, NotificationType type){
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}