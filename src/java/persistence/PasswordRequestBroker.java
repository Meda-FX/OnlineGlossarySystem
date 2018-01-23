package persistence;

import business.domainClasses.PasswordRequest;
import java.util.List;

/**
 * The PasswordRequestBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of PasswordRequest from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class PasswordRequestBroker extends Broker{
    
    /**
     * The getRequest method get the PasswordRequest with it ID
     * @param id represents the ID of a the PasswordRequest
     * @return a PasswordRequest object with the specified ID.
     */
    public PasswordRequest getRequest(String id) {
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
