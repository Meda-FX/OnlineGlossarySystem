/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.domainClasses;

import java.util.Date;

/**
 *
 * @author 727153
 */
public class DefinitionLog {
    private int logID;
    private int definitionID;
    private int activityType;
    private User activityBy;
    private Date activityDate;

    public DefinitionLog() {
    }
    
    /**
     * Constructs a glossary request
     * @param logID
     * @param definitionID
     * @param activityType activityType the type of the requested glossary
     * @param activityBy requestBy the glossary request 
     * @param activityDate activityDate the date in which the glossary is created
     */
    public DefinitionLog(int logID, int definitionID, int activityType, User activityBy, Date activityDate) {
        this.logID = logID;
        this.definitionID = definitionID;
        this.activityType = activityType;
        this.activityBy = activityBy;
        this.activityDate = activityDate;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }
    
    /**
     * returns the glossary entry term
     * @return the glossary term
     */
    public int getDefinitionID() {
        return definitionID;
    }

    /**
     * Changes the glossary entry term
     * @param definitionID definitionID the glossary entry term to set
     */
    public void setDefinitionID(int definitionID) {
        this.definitionID = definitionID;
    }

    /**
     * Returns the type of the request
     * @return the type of the request
     */
    public int getActivityType() {
        return activityType;
    }

    /**
     * Changes the request type of the glossary request
     * @param activityType activityType the request type to be set
     */
    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    /**
     * Returns the instructor that requested the term
     * @return the user of the requester 
     */
    public User getActivityBy() {
        return activityBy;
    }

    /**
     * Changes the requester 
     * @param activityBy activityBy the user to be set
     */
    public void setActivityBy(User activityBy) {
        this.activityBy = activityBy;
    }

    /**
     * Returns the date of the term created
     * @return the date in which the term is created
     */
    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}
