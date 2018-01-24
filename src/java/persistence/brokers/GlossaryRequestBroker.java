package persistence.brokers;

import business.domainClasses.GlossaryRequest;
import business.domainClasses.User;
import java.util.List;

/**
 * The GlossaryRequestBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of GlossaryRequest from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class GlossaryRequestBroker extends Broker{

    /**
     * The getByTerm method searches for all the GlossaryRequest of a specified term.
     *
     * @param term represents the term to be entered into the search for a
     * matching result set.
     * @return a list of glossary requests for the specified term
     */
    public List<GlossaryRequest> getByTerm(String term) {
        return null;
    }

    /**
     * The getByType method searches for all the GlossaryRequest of a specified type.
     *
     * @param type represents the type of GlossaryRequest.
     * @return a list of glossary requests of the specified type.
     */
    public List<GlossaryRequest> getByType(Integer type) {
        return null;
    }

    /**
     * The getByUser method searches for all the GlossaryRequest created by a specified user.
     * @param user represents the user creating the GlossaryRequest.
     * @return a list of Glossary Requests.
     */
    public List<GlossaryRequest> getByUser(User user) {
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
