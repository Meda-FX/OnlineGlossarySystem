/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.AccountLog;
import java.util.Date;
import java.util.List;
import persistence.brokers.AccountLogBroker;

/**
 *
 * @author 727153
 */
public class AccountLogService {
    private AccountLogBroker accountLogDB;

    /**
     * Constructs a glossary request object 
     */
    public AccountLogService() {
        this.accountLogDB = new AccountLogBroker();
    }
    
    /**
     * Method used to insert a glossary request object in to the system. If the return is 1 the insertion is a success
     * and if the return is 0 the insertion is unsuccessful. 
     * @param glossaryRequest glossaryRequest the glossary request object used to insert in  to
     * @return returns 1 if the insertion is successful and 0 if the insertion is not a success
     */
    public int insert(AccountLog glossaryRequest) {
        return accountLogDB.insert(glossaryRequest);
    }
    
    public List<AccountLog> getByDatesAndType(Date start, Date end, int type) {
        return accountLogDB.getByDatesAndType(start, end, type);
    }
}
