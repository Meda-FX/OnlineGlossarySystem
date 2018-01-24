package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import java.util.List;

/**
 * The DefinitionBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Definition from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class DefinitionBroker extends Broker{

    /**
     * The getByUser method returns a list of definitions related to the user.
     *
     * @param user represents the account in the user table in the database.
     * @return a list of definitions by user.
     */
    public List<Definition> getByUser(User user) {
        return null;
    }
    
    /**
     * The getById method returns a definition related to the user's ID.
     * @param id represents the course in the course table in the database.
     * @return a definition of a term
     */
    public Definition getByID(String id) {
        return null;
    }

    /**
     * The getByCourse method returns a list of definitions related to the user.
     *
     * @param course represents the course in the course table in the database.
     * @return a list of definitions by course.
     */
    public List<Definition> getByCourse(Course course) {
        return null;
    }

    /**
     * The getByGlossaryEntry returns a list of definitions related to the entry
     * in the glossary.
     *
     * @param glossary represents an entry in the glossary.
     * @return a list of definitions by glossary entry.
     */
    public List<Definition> getByGlossaryEntry(GlossaryEntry glossary) {
        return null;
    }

    @Override
    public int insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
