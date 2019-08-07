/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Forms.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lpjan
 */
public class ApexSystem {
    
    private LoginHandler loginHandler;
    private LoadingForm loadingForm;
    private LoginForm loginForm;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        new ApexSystem().Setup();
    }
    
    private void Setup() throws InterruptedException{
        loadingForm = new LoadingForm();
        
        loadingForm.setLoading("Loading Logins", 1);
        
        loadingForm.setLocationRelativeTo(null);
        loadingForm.setVisible(true);
        
        loginHandler = new LoginHandler();
        
        loadingForm.setLoading("Loading Resources", 2);
        
        loadingForm.setLoading("Loading Login Form", 3);
        
        loginForm = new LoginForm(loginHandler);
        
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
        
        loadingForm.dispose();
    }
    
    
    
}
