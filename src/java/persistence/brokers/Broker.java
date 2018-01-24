package persistence.brokers;


import java.util.List;

/**
 * The generalization contract of all the Broker classes in the Online Glossary System
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public abstract class Broker {


    /**
     * The insert method gives the application the ability of inserting an entry
     * into the database
     *
     * @param object an object being inserting into the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract int insert(Object object);

    /**
     * The delete method gives the application the ability of deleting a row in
     * a certain table in the database.
     *
     * @param object an object being removed from the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract int delete(Object object);

    /**
     * The update method gives the application the ability of updating a row in
     * a certain table of the database.
     *
     * @param object an object being updated in the database as an entry.
     * @return if the operation is successful, the method return Integer 1, 
     * otherwise it returns 0.
     */
    public abstract int update(Object object);

    /**
     * The getAll method returns all of the records from a table.
     *
     * @return all rows from a table as a list of Object.
     */
    public abstract List<Object> getAll();
}
