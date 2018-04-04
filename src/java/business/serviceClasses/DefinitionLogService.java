/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.DefinitionLog;
import java.util.Date;
import java.util.List;
import persistence.brokers.DefinitionLogBroker;

/**
 *
 * @author 727153
 */
public class DefinitionLogService {
    private DefinitionLogBroker definitionLogDB;

    public DefinitionLogService() {
        this.definitionLogDB = new DefinitionLogBroker();
    }
    
    public int insert(DefinitionLog definitionLog) {
        return definitionLogDB.insert(definitionLog);
    }
    
    public List<DefinitionLog> getByDatesAndType(Date start, Date end, int type) {
        return definitionLogDB.getByDatesAndType(start, end, type);
    }
}
