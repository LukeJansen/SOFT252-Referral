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
    
    /**
     *
     * @param title
     * @param type
     * @param reason
     */
    public PurchaseRequest (String title, ResourceType type, String reason){
        this.name = title;
        this.type = type;
        this.reason = reason;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param title
     */
    public void setName(String title) {
        this.name = title;
    }

    /**
     *
     * @return
     */
    public ResourceType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(ResourceType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
