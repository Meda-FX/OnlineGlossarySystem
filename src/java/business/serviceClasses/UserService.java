package business.serviceClasses;

import business.domainClasses.User;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.UserBroker;

/**
 * UserService class uses to access data from the database by utilizing the UserBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class UserService {
    private UserBroker userDB;

    /**
     * Constructs a user service object 
     */
    public UserService() {
        this.userDB = userDB;
    }
    
    /**
     * Method used to check a login validity. If the authentication is correct and successful
     * the return type will be the user that logged in. If the authentication is wrong it will return a null
     * object.
     * @param email the email of the user
     * @param password password the password of the user
     * @return returns a user object
     */
    public User checkLogin(String email, String password) {
        return null;
    }
    
    /**
     * Method used to get a user by using a user id parameter
     * @param id id the id of the user to get 
     * @return the user that is get by the search
     */
    public User get(String id) {
        return null;
    }
    
    /**
     * Method used to get a list of all users when requested
     * @return a list of all users upon request
     */
    public List<User> getAll(){
        return new ArrayList<User>();
    }
    
    /**
     * Method updating a specific user to the list and returns 1 or 0 as a result of success and failure.
     * @param user user the user object to be updated
     * @return returns 1 or zero upon a update is made. If the update is successful the return type will return
     * 1 and if the update is un successful the return type will be a 0.
     */
    public int update(User user){
        return 1;
    }
    
    /**
     * Method deletes a specific user from the list and returns 1 or 0 as a result of success and failure.
     * @param id id the id of the user that is being deleted
     * @return returns 1 or zero upon a deletion is made. If the deletion is successful the return type will return
     * 1 and if the deletion is un successful the return type will be a 0. 
     */
    public int delete(String id){
        return 1;
    }
    
    /**
     * Method inserting a specific user to the list and returns 1 or 0 as a result of success and failure.
     * @param user user the user object that will be affected by the insertion process
     * @return returns 1 or zero upon an insertion is made. If the insertion is successful the return type will return
     * 1 and if the insertion is un successful the return type will be a 0. 
     */
    public int insert(User user){
        return 1;
    }
    
    /**
     * Method used to find a specific user by email. As the succession of the search the method returns 
     * the user if the user exists and null if the email with a specific email address does not exist.
     * @param email email the email of the user that will be used for the search
     * @return returns a user if the user with the email exists and returns null if it does not exist
     */
    public User getByEmail(String email){
        return null;
    }
    
    /**
     * The getByName method is to find a list of users with the specified name. If there are
     * entries with that name the list is returned or null otherwise
     * @param name representing a user's name
     * @return returns a List of type user on account that they exist in the database
     */
    public List<User> getByName(String name) {
        return null;
    }
}
