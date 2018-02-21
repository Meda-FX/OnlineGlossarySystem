package business.serviceClasses;

import business.domainClasses.AccountRequest;
import business.domainClasses.User;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.AccountRequestBroker;

/**
 * AccountRequestService class uses to access data from the database by utilizing the AccountRequestBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class AccountRequestService {
    private AccountRequestBroker requestDB;

    /**
     * Constructs an object for the password request service
     */
    public AccountRequestService() {
        this.requestDB = requestDB;
    }
    
    /**
     * Returns the forgotten password request with its id
     * @param id id the id of the password request
     * @return the password request 
     */
    public AccountRequest get(String id) {         
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
     * @param requestType requestType the type of request being made, 1 is a request
     * for creating new account, 2 is a forget password request
     * @return the string to be send to the user 
     */
    public String insert(User requestUser, int requestType) {
        return null;
    }
    
    /**
     * Returns list of all password requests
     * @return all list of the request password 
     */
    public List<AccountRequest> getAll() {
        return new ArrayList<AccountRequest>();
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
