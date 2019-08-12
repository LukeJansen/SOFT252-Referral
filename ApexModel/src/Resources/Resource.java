/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Accounts.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lpjan
 */
public class Resource implements java.io.Serializable {
    
    private String name;
    private ResourceType type;
    private float category;
    
    private List<Integer> ratings;
    private float userRating;
    
    private ResourceStatus status;
    private String loanedUser;
    private LoanType loanType;
    private long dueDate;
    
    private boolean returnRequested;
    private boolean inNewsletter;
    
    private int ID;
    
    public Resource(){
        name = "Not Set!";
        type = null;
        category = 0;
        userRating = 0;
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        
        ratings = new ArrayList<>();
    }
    
    public Resource(String name, ResourceType type, float category, int ID, LoanType loanType){
        this.name = name;
        this.type = type;
        this.category = category;
        this.ID = ID;
        this.loanType = loanType;
        
        userRating = 0;
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        
        ratings = new ArrayList<>();
    }
    
    public void addRating(int rating){
        ratings.add(rating);
        
        float sum = 0f;
        
        for (int num : ratings){
            sum += num;
        }
        
        userRating = sum / ratings.size();
        
    }
    
    public void Loan(User user){
        status = ResourceStatus.LOANED;
        loanedUser = user.getUserID();
        
        if (loanType == LoanType.SHORTTERM){
            dueDate = System.currentTimeMillis() + (86400000 * 14);
        }
        else if (loanType == LoanType.LONGTERM){
            long add = 86400000L * 180L;
            System.out.println(add);
            dueDate = System.currentTimeMillis() + add;
        }
    }
    
    public void Return(){
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        returnRequested = false;
    }
    
    public void CheckLoan(){
        if (loanType == LoanType.REFERENCE){
            status = ResourceStatus.AVAILABLE;
        }
        else if (System.currentTimeMillis() > dueDate && !"".equals(loanedUser)){
            status = ResourceStatus.OVERDUE;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public float getCategory() {
        return category;
    }

    public void setCategory(float category) {
        this.category = category;
    }

    public String getUserRating() {
        String string = String.format ("%.2f", userRating);
        return string;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ResourceStatus getStatus() {
        return status;
    }

    public void setStatus(ResourceStatus status) {
        this.status = status;
    }

    public String getLoanedUser() {
        return loanedUser;
    }

    public void setLoanedUser(String loanedUser) {
        this.loanedUser = loanedUser;
    } 

    public long getDueDate() {
        if (status == ResourceStatus.AVAILABLE){
            return 0;
        }
        else{
            return dueDate;
        }
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public boolean isReturnRequested() {
        return returnRequested;
    }

    public void setReturnRequest(boolean returnRequest) {
        this.returnRequested = returnRequest;
    }

    public boolean isInNewsletter() {
        return inNewsletter;
    }

    public void setInNewsletter(boolean inNewsletter) {
        this.inNewsletter = inNewsletter;
    }
}
