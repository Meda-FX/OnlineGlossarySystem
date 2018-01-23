package persistence.brokers;

import com.mysql.jdbc.Connection;
import java.util.List;

/**
 * The generalization contract of all the Broker classes in the Online Glossary System
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.1
 */
public abstract class Broker {

    private Connection conn;
    private Broker broker;

    /**
     * The getBroker method provide a singular Broker object providing 
     * connectivity to the database
     *
     * @param username the username of the account accessing the database
     * @param password the password of the account accessing the database
     * @return the Broker object providing connectivity to the database
     */
    public Broker getBroker(String username, String password) {
        return null;
    }

    /**
     * The insert method gives the application the ability of inserting an entry
     * into the database
     *
     * @param object an object being inserting into the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract Integer insert(Object object);

    /**
     * The delete method gives the application the ability of deleting a row in
     * a certain table in the database.
     *
     * @param object an object being removed from the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract Integer delete(Object object);

    /**
     * The update method gives the application the ability of updating a row in
     * a certain table of the database.
     *
     * @param object an object being updated in the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract Integer update(Object object);

    /**
     * The getAll method returns all of the records from a table.
     *
     * @return all rows from a table as a list of Object.
     */
    public abstract List<Object> getAll();
}
