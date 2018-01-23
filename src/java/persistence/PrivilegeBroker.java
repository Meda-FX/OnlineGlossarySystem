package persistence;

import business.domainClasses.Privilege;
import java.util.List;

/**
 * The PrivilegeBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Privilege from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class PrivilegeBroker extends Broker{

    /**
     * The getByID method gets the privilege with the privilege ID.
     *
     * @param privilegeID represents the ID of the privilege.
     * @return a Privilege object with the specified ID.
     */
    public Privilege getByID(Integer privilegeID) {
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
