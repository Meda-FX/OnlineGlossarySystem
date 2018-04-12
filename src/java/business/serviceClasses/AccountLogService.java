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
 * AccountLogService class uses to access data from the database by utilizing
 * the AccountLogBroker.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
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
     * Method used to insert a glossary request object in to the system. If the
     * return is 1 the insertion is a success and if the return is 0 the
     * insertion is unsuccessful.
     *
     * @param accountLog accountLog the glossary request object used to insert
     * in to
     * @return returns 1 if the insertion is successful and 0 if the insertion
     * is not a success
     */
    public int insert(AccountLog accountLog) {
        return accountLogDB.insert(accountLog);
    }

    /**
     * getByDDT method used to get a list of account log information by a date
     * period, department and type
     *
     * @param start represents the date to start
     * @param end represents the date for end
     * @param department represents the department to search
     * @param type represents the type of the log
     * @return a list of account log
     */
    public List<AccountLog> getByDDT(Date start, Date end, int department, int type) {
        return accountLogDB.getByDDT(start, end, department, type);
    }
}
