/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

/**
 *
 * @author lpjan
 */
public class Resource {
    
    private String name;
    private ResourceType type;
    private float category;
    private float userRating;
    
    public Resource(){
        name = "Not Set!";
        type = null;
        category = 0;
        userRating = 0;
    }
    
    public Resource(String name){
        this.name = name;
        type = null;
        category = 0;
        userRating = 0;
    }
    
    public Resource(String name, ResourceType type){
        this.name = name;
        this.type = type;
        category = 0;
        userRating = 0;
    }
    
    public Resource(String name, ResourceType type, float category){
        this.name = name;
        this.type = type;
        this.category = category;
        userRating = 0;
    }
    
}
