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
public class PurchaseRequest implements java.io.Serializable{
    
    private String name;
    private ResourceType type;
    private String reason;
    
    public PurchaseRequest (String title, ResourceType type, String reason){
        this.name = title;
        this.type = type;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
