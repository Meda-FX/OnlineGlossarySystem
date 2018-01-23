package business.serviceClasses;

import business.domainClasses.PasswordRequest;
import business.domainClasses.User;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.PasswordRequestBroker;

/**
 * PasswordRequestService class uses to access data from the database by utilizing the PasswordRequestBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class PasswordRequestService {
    private PasswordRequestBroker requestDB;

    /**
     * Constructs an object for the password request service
     */
    public PasswordRequestService() {
        this.requestDB = requestDB;
    }
    
    /**
     * Returns the forgotten password request with its id
     * @param id id the id of the password request
     * @return the password request 
     */
    public PasswordRequest get(String id) {         
        return null;
    }
    
    /**
     * Remove the forgotten password request by its id. If the return is 1 it means
     * the deletion is complete. If the return is 0 the delete is not completed.
     * @param id id the id to be deleted
     * @return 1 if the deletion is complete. If the return is 0 the delete is not completed.
     */
    public int delete(String id) {
        return 1;
    }
    
    /**
     * Adding the a forgotten password request for a specific user. Returns a string 
     * that is to be sent to the user requesting for a password change
     * @param requestUser requestUser the request made by the user
     * @return the string to be send to the user 
     */
    public String insert(User requestUser) {
        return null;
    }
    
    /**
     * Returns list of all password requests
     * @return all list of the request password 
     */
    public List<PasswordRequest> getAll() {
        return new ArrayList<PasswordRequest>();
    }
    
    /**
     * Method to verify user identity with the supplied string
     * @param token token the token that is passed to verify the user
     * @return the verified user when verified and returns null when failed
     */
    public User verifyID(String token) {
        return null;
    }
    
    /**
     * Removes a old password request with its requested user
     * @param requestUser requestUser the requester who's password request to be removed
     */
    public void removeOld(User requestUser) { }
}
