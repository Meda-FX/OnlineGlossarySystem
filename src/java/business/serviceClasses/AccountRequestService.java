package business.serviceClasses;

import business.domainClasses.AccountRequest;
import business.domainClasses.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
        return requestDB.getRequest(id);
    }
    
    /**
     * Remove the forgotten password request by its id. If the return is 1 it means
     * the deletion is complete. If the return is 0 the delete is not completed.
     * @param id id the id to be deleted
     * @return 1 if the deletion is complete. If the return is 0 the delete is not completed.
     */
    public int delete(String id) {
        return requestDB.delete(requestDB.getRequest(id));
    }
    
    /**
     * Adding the a forgotten password request for a specific user. Returns a string 
     * that is to be sent to the user requesting for a password change
     * @param requestUser requestUser the request made by the user
     * @param requestType requestType the type of request being made, 1 is a request
     * for creating new account, 2 is a forget password request
     * @return the string to be send to the user 
     */
    public String insert(User requestUser, int requestType) throws Exception {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setRequestType(requestType);
        accountRequest.setRequestdBy(requestUser);
        
        SecureRandom sr = new SecureRandom();
        byte salt[] = new byte[32];
        sr.nextBytes(salt);
        String saltStr = salt.toString();
        accountRequest.setSalt(saltStr);
        
        String token = UUID.randomUUID().toString();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update((token + saltStr).getBytes());
        
        String hash = new String(md.digest());
        accountRequest.setRequestID(hash);
        
        accountRequest.setRequestDate(new Date());
        
        //removeOld(requestUser);
        
        requestDB.insert(accountRequest);
        return token;
    }
    
    /**
     * Returns list of all password requests
     * @return all list of the request password 
     */
    public List<AccountRequest> getAll() {
        List<Object> objectList = requestDB.getAll();
        List<AccountRequest> requestList = new ArrayList<>();
        for (Object o: objectList) {
            requestList.add((AccountRequest)o);
        }
        return requestList;
    }
    
    /**
     * Method to verify user identity with the supplied string
     * @param token token the token that is passed to verify the user
     * @param requestType the request type of the current call for verify ID
     * @return the verified user when verified and returns null when failed
     */
    public User verifyID(String token, int requestType) throws NoSuchAlgorithmException {
        List<AccountRequest> accountRequestList = requestDB.getToVerify(requestType);
        for (AccountRequest accountRequest: accountRequestList) {
            String salt = accountRequest.getSalt();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((token + salt).getBytes());
            String hash = new String(md.digest());
            if (hash.equals(accountRequest.getRequestID())) {
                String userID = accountRequest.getRequestdBy().getID();
                UserService us = new UserService();
                User user = us.get(userID);
                //requestDB.delete(accountRequest);
                return user;
            }
        }
        return null;
    }
    
    
    /**
     * Removes a old password request with its requested user
     * @param requestUser requestUser the requester who's password request to be removed
     */
    //public void removeOld(User requestUser) {
    //    
    //}
    
}
