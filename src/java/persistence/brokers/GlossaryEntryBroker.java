package persistence.brokers;

import business.domainClasses.GlossaryEntry;
import java.util.List;

/**
 * The GlossaryEntryBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of GlossaryEntry from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.1
 */
public class GlossaryEntryBroker extends Broker{

    /**
     * The getByTerm method shows the results of a search of a specified term.
     *
     * @param term represents the term to be entered into the search for a
     * matching result set.
     * @return a Glossary Request object.
     */
    public GlossaryEntry getByTerm(String term) {
        return null;
    }

    @Override
    public Integer insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
