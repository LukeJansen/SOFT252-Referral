/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Accounts.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all the information about a single resource.
 * @author lpjan
 */
public class Resource implements java.io.Serializable {
    
    private String name;
    private ResourceType type;
    private float category;
    
    private List<Integer> ratings;
    private float userRating;
    
    private final long creationDate;
    
    private ResourceStatus status;
    private String loanedUser;
    private LoanType loanType;
    private long dueDate;
    private int loanNoticeID;
    
    private boolean returnRequested;
    
    private boolean extensionRequested;
    private int daysRequested;
    
    private int ID;
    
    /**
     * The default constructor for no inputs.
     * Should not be used!
     */
    public Resource(){
        name = "Not Set!";
        type = null;
        category = 0;
        userRating = 0;
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        
        ratings = new ArrayList<>();
        
        creationDate = System.currentTimeMillis();
    }
    
    /**
     * The default constructor with all inputs.
     * @param name Resource Name
     * @param type Resource Type
     * @param category Resources Dewey Decimal Number
     * @param ID Resource ID
     * @param loanType Loan Type for this Resource.
     */
    public Resource(String name, ResourceType type, float category, int ID, LoanType loanType){
        this.name = name;
        this.type = type;
        this.category = category;
        this.ID = ID;
        this.loanType = loanType;
        
        userRating = -1;
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        
        ratings = new ArrayList<>();
        
        creationDate = System.currentTimeMillis();
    }
    
    /**
     * Adds a rating to the list of ratings
     * and then generates the new average rating.
     * @param rating User's Rating to be added.
     */
    public void addRating(int rating){
        ratings.add(rating);
        
        float sum = 0f;
        
        for (int num : ratings){
            sum += num;
        }
        
        userRating = sum / ratings.size();
        
    }
    
    /**
     * Loans a resource to the user specified.
     * @param user User to loan book to
     */
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
    
    /**
     * Return a resource.
     */
    public void Return(){
        status = ResourceStatus.AVAILABLE;
        loanedUser = "";
        returnRequested = false;
        loanNoticeID = 0;
    }
    
    /**
     * Checks the status of a loan and makes sure a
     * loan is not overdue.
     */
    public void CheckLoan(){
        if (loanType == LoanType.REFERENCE){
            status = ResourceStatus.AVAILABLE;
        }
        else if (System.currentTimeMillis() > dueDate && !"".equals(loanedUser)){
            status = ResourceStatus.OVERDUE;
        }
    }
    
    /**
     * Stores a user's request for an extension to their loan.
     * @param days Days to extend loan by.
     */
    public void RequestExtension(int days){
        if (days != 0){
            daysRequested = days;
            extensionRequested = true;
        }
    }
    
    /**
     * Extends the loan after the request is approved by an admin.
     */
    public void ExtendLoan(){
        dueDate += (86400000 * daysRequested);
        
        daysRequested = 0;
        extensionRequested = false;
    }
    
    /**
     * Denies the loan request and resets the variables.
     */
    public void DenyLoan(){
        daysRequested = 0;
        extensionRequested = false;
    }

    /**
     * Returns the Resource Name
     * @return Resource Name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Resource Name
     * @param name New Resource Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Resource Type
     * @return Resource Type
     */
    public ResourceType getType() {
        return type;
    }

    /**
     * Sets the Resource Type
     * @param type New Resource Type
     */
    public void setType(ResourceType type) {
        this.type = type;
    }

    /**
     * Returns the Resource's Category
     * @return Resource's Category
     */
    public float getCategory() {
        return category;
    }

    /**
     * Sets the Resource's Category
     * @param category New Resource Category
     */
    public void setCategory(float category) {
        this.category = category;
    }

    /**
     * Returns the average user rating
     * @return Average User Rating
     */
    public String getUserRating() {
        String string = String.format ("%.2f", userRating);
        return string;
    }

    /**
     * Returns the Resource's ID
     * @return Resource's ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets the Resource's ID
     * @param ID New Resource ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Returns the Resource's Current Status
     * @return Resource's Status
     */
    public ResourceStatus getStatus() {
        return status;
    }

    /**
     * Sets the Resource's Status
     * @param status New Resource's Status
     */
    public void setStatus(ResourceStatus status) {
        this.status = status;
    }

    /**
     * Returns the User who is currently loaning the Resource
     * @return User who currently has the Resource.
     */
    public String getLoanedUser() {
        return loanedUser;
    }

    /**
     * Sets the User who is currently loaning the Resource
     * @param loanedUser User to be Loaning resource.
     */
    public void setLoanedUser(String loanedUser) {
        this.loanedUser = loanedUser;
    } 

    /**
     * Returns the due date of the resource if it is on loan
     * @return Date due back
     */
    public long getDueDate() {
        if (status == ResourceStatus.AVAILABLE){
            return 0;
        }
        else{
            return dueDate;
        }
    }

    /**
     * Returns the Resource's Loan Type
     * @return Resource's Loan Type
     */
    public LoanType getLoanType() {
        return loanType;
    }

    /**
     * Returns a boolean value based on whether a 
     * return has been requested by a user.
     * @return Boolean value of whether a return has been requested
     */
    public boolean isReturnRequested() {
        return returnRequested;
    }

    /**
     * Sets whether a return has been requested
     * @param returnRequest Boolean value for whether the user is requested a return
     */
    public void setReturnRequest(boolean returnRequest) {
        this.returnRequested = returnRequest;
    }

    /**
     * Returns the ID of the Loan Notice.
     * @return ID of Loan Notice.
     */
    public int getLoanNoticeID() {
        return loanNoticeID;
    }

    /**
     * Sets the ID of the Loan Notice.
     * @param loanNoticeSent Loan Notice ID
     */
    public void setLoanNoticeID(int loanNoticeSent) {
        this.loanNoticeID = loanNoticeSent;
    }

    /**
     * Returns a boolean value on whether an extension has been requested.
     * @return Boolean value on whether an extension has been requested.
     */
    public boolean isExtensionRequested() {
        return extensionRequested;
    }

    /**
     * Returns the number of days loan extension requested.
     * @return Number of days requested
     */
    public int getDaysRequested() {
        return daysRequested;
    }

    /**
     * Returns the date the resource was created.
     * @return Date resource was created.
     */
    public long getCreationDate() {
        return creationDate;
    }
}
