package business.serviceClasses;

import business.domainClasses.GlossaryEntryLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistence.brokers.GlossaryEntryBroker;
import persistence.brokers.GlossaryEntryLogBroker;

/**
 * GlossaryEntryLogService class uses to access data from the database by utilizing the GlossaryEntryBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.1 
 */
public class GlossaryEntryLogService {
    private GlossaryEntryLogBroker glossaryEntryLogDB;

    /**
     * Constructs a glossary request object 
     */
    public GlossaryEntryLogService() {
        this.glossaryEntryLogDB = new GlossaryEntryLogBroker();
    }
    
    /**
     * Method used to insert a glossary request object in to the system. If the return is 1 the insertion is a success
     * and if the return is 0 the insertion is unsuccessful. 
     * @param glossaryRequest glossaryRequest the glossary request object used to insert in  to
     * @return returns 1 if the insertion is successful and 0 if the insertion is not a success
     */
    public int insert(GlossaryEntryLog glossaryRequest) {
        return glossaryEntryLogDB.insert(glossaryRequest);
    }
    
    public List<GlossaryEntryLog> getByDatesAndType(Date start, Date end, int type) {
        return glossaryEntryLogDB.getByDatesAndType(start, end, type);
    }
}
