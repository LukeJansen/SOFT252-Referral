package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Accounts.*;

/**
 *
 * @author lpjan
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user1 = new Administrator("admin", "123");
        
        System.out.println(user1.getUserID());
        System.out.println(user1.getPassword());
    }
    
}
