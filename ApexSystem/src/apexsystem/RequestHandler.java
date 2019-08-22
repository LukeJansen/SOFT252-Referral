/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Resources.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class RequestHandler {
    
    private ArrayList<PurchaseRequest> requestList = new ArrayList<>();
    
    public RequestHandler(){
        Load();
    }
    
    private void Load(){
        
        File folder = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/requests/");
        File[] resourceFiles = folder.listFiles();
        
        for (File file : resourceFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 requestList.add((PurchaseRequest)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (IOException i) {
                 return;
            } 
            catch (ClassNotFoundException c) {
                 System.out.println("Request class not found");
                return;
            }
        }
        
        System.out.println("Loaded " + requestList.size() + " Requests!");        
    }
    
    public void Save(){
     
        for (PurchaseRequest request : requestList){
        
            try {
                File file = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/requests/" + requestList.indexOf(request) + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(request);
                out.close();
                fileOut.close();
                System.out.printf("\nSerialized data for request " + requestList.indexOf(request));
            } catch (IOException e) {
            }
        }   
    } 

    public ArrayList<PurchaseRequest> getRequestList() {
        return requestList;
    }
    
}
