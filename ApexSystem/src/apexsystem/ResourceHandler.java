/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Resources.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author lpjan
 */
public class ResourceHandler {
    
    public ArrayList<Resource> resourceList = new ArrayList<Resource>();
    
    public ResourceHandler(){
        Load();
    }
    
    private void Load(){
        
        File folder = new File("data/resources/");
        File[] resourceFiles = folder.listFiles();
        
        for (File file : resourceFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 resourceList.add((Resource)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (IOException i) {
                 i.printStackTrace();
                 return;
            } 
            catch (ClassNotFoundException c) {
                 System.out.println("Resource class not found");
                 c.printStackTrace();
                return;
            }
        }
        
        System.out.println("Loaded " + resourceList.size() + " Resources!");        
    }
    
    public void Save(){
     
        for (Resource resource : resourceList){
        
            try {
                File file = new File("data/resources/" + resource.getID() + ".ser");
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(resource);
                out.close();
                fileOut.close();
                System.out.printf("\nSerialized data for resource " + resource.getID());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }   
    } 
    
}
