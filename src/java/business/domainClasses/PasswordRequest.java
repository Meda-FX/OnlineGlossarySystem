package business.domainClasses;

import java.util.Date;

/**
 * PasswordRequest class constructs the password request object it allowed mutation and accessing of the attributes of password requests.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class PasswordRequest {
    private String requestID;
    private User requestedBy;
    private Date requestDate;
    private String salt;
    
    /**
     * Constructs a password request object
     * @param requestID  requestID the request id in changing password
     * @param requestedBy requestdBy the requester of the password change
     * @param requestDate requestDate the date in which the request is sent
     * @param salt salt the string used for hashing 
     */
    public PasswordRequest(String requestID, User requestedBy, Date requestDate, String salt) {
        this.requestID = requestID;
        this.requestedBy = requestedBy;
        this.requestDate = requestDate;
        this.salt = salt;
    }
    
    /**
     * returns the request id of the password 
     * @return the request id
     */
    public String getRequestID() {
        return requestID;
    }
    
    /**
     * method changes the requested id 
     * @param requestID requestID the requested id to be set
     */
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
    
    /**
     * returns a user object for the request
     * @return the user for the request 
     */
    public User getRequestdBy() {
        return requestedBy;
    }
    
    /**
     * Changes the request user object 
     * @param requestdBy  requestdBy the requester to be set
     */
    public void setRequestdBy(User requestdBy) {
        this.requestedBy = requestdBy;
    }

    /**
     * Returns the date of the password request
     * @return the date of the password request 
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * Changes the request date of the password request
     * @param requestDate requestDate the date of the request to be set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    public String getSalt() {
        return salt;
    }
}
