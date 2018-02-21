package persistence.brokers;

import business.domainClasses.AccountRequest;
import java.util.List;

/**
 * The AccountRequestBroker provide connectivity to the database and allow insertion,
 retrieval and removal of AccountRequest from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class AccountRequestBroker extends Broker{
    
    /**
     * The getRequest method get the AccountRequest with it ID
     * @param id represents the ID of a the AccountRequest
     * @return a AccountRequest object with the specified ID.
     */
    public AccountRequest getRequest(String id) {
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
    
    public List<AccountRequest> getToVerify(int requestType) {
        return null;
    }
}
