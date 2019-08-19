/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apexsystem;

import Notifications.*;
import Resources.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lpjan
 */
public class ResourceHandler {
    
    public ArrayList<Resource> resourceList = new ArrayList<Resource>();
    private ApexSystem system;
    
    public ResourceHandler(ApexSystem system){
        this.system = system;
        
        Load();
    }
    
    private void Load(){
        
        File folder = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/resources/");
        File[] resourceFiles = folder.listFiles();
        
        for (File file : resourceFiles){
        
            try {
                 FileInputStream fileIn = new FileInputStream(file);
                 ObjectInputStream in = new ObjectInputStream(fileIn);
                 resourceList.add((Resource)in.readObject());
                 in.close();
                 fileIn.close();
            } 
            catch (InvalidClassException c) {
                System.out.println("Resource class changed and file is no longer valid!");
                System.out.println("File deleted: " + file.delete());
                return;
            }
            catch (IOException i) {
                i.printStackTrace();
                 return;
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } 
        }
        
        if (resourceList.size() == 0) CreateDefaultResources();
        
        System.out.println("Loaded " + resourceList.size() + " Resources!");        
    }
    
    public void Save(){
     
        for (Resource resource : resourceList){
        
            try {
                File file = new File(System.getenv("LOCALAPPDATA") + "/Apex Library System/data/resources/" + resource.getID() + ".ser");
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
    
    public void AddNotifications(String userID){
        NotificationHandler notificationHandler = system.getNotificationHandler();
        
        for (Resource resource : resourceList){
            if (resource.getLoanNoticeID() != 0){
                if ((resource.getDueDate() - System.currentTimeMillis() < (-86400000 * 20))){
                    notificationHandler.Add(userID, "Overdue Ban", "The resource " + resource.getName() + " has been overdue for over 20 days. Therefore your account has been locked until this book is returned.", NotificationType.WARNING);
                }
                else if (System.currentTimeMillis() > resource.getDueDate()){    
                    notificationHandler.Add(userID, "Overdue Notification", "The resource " + resource.getName() + " is now overdue.", NotificationType.INFO);
                }
            }
            else if ((resource.getDueDate() - System.currentTimeMillis()) < (86400000 * 7)){
                notificationHandler.Add(userID, "Due Date Warning", "The resource " + resource.getName() + " will be overdue in less than one week.", NotificationType.INFO);
            }
        }
    } 
    
    public void CreateDefaultResources(){
        resourceList.add(new Resource("Discrete mathematics for Computer Science", ResourceType.BOOK, 510, 0,LoanType.SHORTTERM));
        resourceList.add(new Resource("Art Incorporated: the story of contemporary art", ResourceType.BOOK, 709.05f, 1,LoanType.SHORTTERM));
        resourceList.add(new Resource("When the pyramids were built : Egyptian art of the Old Kingdom", ResourceType.BOOK, 709.32f, 2,LoanType.REFERENCE));
        resourceList.add(new Resource("An introduction to using GIS in marine biology", ResourceType.BOOK, 578.770285f, 3,LoanType.LONGTERM));
        resourceList.add(new Resource("Monty Python, Shakespeare, and English Renaissance drama", ResourceType.BOOK, 822.33f, 4,LoanType.SHORTTERM));
        resourceList.add(new Resource("Computer hacking : computer hacking and Python", ResourceType.BOOK, 005.8f, 5,LoanType.SHORTTERM));
        resourceList.add(new Resource("The Social science enyclopedia", ResourceType.BOOK, 300.3f, 6,LoanType.REFERENCE));
        resourceList.add(new Resource("Food science & technology", ResourceType.NEWSPAPER, 664f, 7,LoanType.SHORTTERM));
        resourceList.add(new Resource("Sophie's World", ResourceType.DVD, 839.828f, 8,LoanType.SHORTTERM));
        resourceList.add(new Resource("The role of the forensic psychologist in child mental health.", ResourceType.NEWSPAPER, 104f, 9,LoanType.SHORTTERM));
        resourceList.add(new Resource("The Ashgate Research Companion to Religion and Conflict Resolution", ResourceType.BOOK, 201.7273f, 10,LoanType.LONGTERM));
        resourceList.add(new Resource("This is Scientology an overview of the world's fastest growing religion.", ResourceType.DVD, 299.936f, 11,LoanType.REFERENCE));
        resourceList.add(new Resource("Voters, patrons, and parties : the unreformed electoral system of Hanoverian England, 1734-1832", ResourceType.BOOK, 942.073f, 12,LoanType.LONGTERM));
        resourceList.add(new Resource("Monuments & maidens : the allegory of the female form", ResourceType.BOOK, 704.942f, 13,LoanType.SHORTTERM));
        resourceList.add(new Resource("Probabilistic and statistical methods in computer science", ResourceType.BOOK, 004.0151f, 14,LoanType.SHORTTERM));
        resourceList.add(new Resource("Visible thought : the new psychology of body language", ResourceType.BOOK, 153.69f, 15,LoanType.REFERENCE));
        resourceList.add(new Resource("Introducing second language acquisition", ResourceType.BOOK, 418, 16,LoanType.SHORTTERM));
        resourceList.add(new Resource("The Cambridge introduction to literature and psychoanalysis", ResourceType.BOOK, 801.92f, 17,LoanType.SHORTTERM));
        resourceList.add(new Resource("The culture of death", ResourceType.BOOK, 306.9f, 18,LoanType.SHORTTERM));
        resourceList.add(new Resource("Anime : a history", ResourceType.BOOK, 741.5f, 19,LoanType.SHORTTERM));
    }
}
