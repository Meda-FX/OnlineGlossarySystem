package business.domainClasses;

import java.util.Date;

/**
 * GlossaryEntryLog class constructs the glossary request object it allowed mutation and accessing of the attributes of the glossary request.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class GlossaryEntryLog {
    private int logID;
    private int activityType;
    private User activityBy;
    private Date activityDate;

    public GlossaryEntryLog() {
        
    }
    
    /**
     * Constructs a glossary request
     * @param logID
     * @param requestType activityType the type of the requested glossary
     * @param requestedBy requestBy the glossary request 
     * @param dateCreated activityDate the date in which the glossary is created
     */
    public GlossaryEntryLog(int logID, int requestType, User requestedBy, Date dateCreated) {
        this.logID = logID;
        this.activityType = requestType;
        this.activityBy = requestedBy;
        this.activityDate = dateCreated;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
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
