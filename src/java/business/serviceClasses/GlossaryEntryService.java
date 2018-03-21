package business.serviceClasses;

import business.domainClasses.GlossaryEntry;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.GlossaryEntryBroker;

/**
 * GlossaryEntryService class uses to access data from the database by utilizing the GlossaryEntryBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class GlossaryEntryService {
    private GlossaryEntryBroker glossaryEntryDB;

    /**
     * Constructs a glossary entry object to be used as a service to the glossary entry DB
     */
    public GlossaryEntryService() {
        this.glossaryEntryDB = new GlossaryEntryBroker();
    }
    
    /**
     * Method used to get a glossary entry using a specified string term title
     * @param term term the term to be used to get the glossary entry 
     * @return return a glossary entry object if the term exists and null if the term does not exist
     */
    public GlossaryEntry get(String term) {
        return glossaryEntryDB.getByTerm(term);
    }
    
    /**
     * Method used to get all the entries made by the users from the system
     * @return a list of all glossary entries made by the users
     */
    public List<GlossaryEntry> getAll() {
        List<Object> objectList = glossaryEntryDB.getAll();
        List<GlossaryEntry> glossaryEntryList = new ArrayList<>();
        for (Object o: objectList) {
            glossaryEntryList.add((GlossaryEntry)o);
        }
        return glossaryEntryList;
    }
    
    public List<GlossaryEntry> getByUser(String userID) {
        return glossaryEntryDB.getByUser(userID);
    }
    
    /**
     * Method used to update the glossary entry. If the entry is updated successfully the return type will be 1 or 
     * if the entry is not a success it will return 0.
     * @param glossaryEntry glossaryEntry the specific glossary entry used to update
     * @return returns 1 if the update is a success and 0 if the update is un successful
     */
    public int update(GlossaryEntry glossaryEntry) {
        return glossaryEntryDB.update(glossaryEntry);
    }
    
    /**
     * Method used to delete the glossary entry. If the entry is deleted successfully the return type will be 1 or 
     * if the entry is not a success it will return 0.
     * @param glossaryEntry glossaryEntry the glossary entry used to delete the entry
     * @return returns 1 if the deletion is a success and 0 if the deletion is un successful
     */
    public int delete(GlossaryEntry glossaryEntry) {
        return glossaryEntryDB.delete(glossaryEntry);
    }
    
    /**
     * Method used to insert in to the glossary entry system. If the insertion is successful the return type will be 1 or 
     * if the insertion is not a success it will return 0.
     * @param glossaryEntry glossaryEntry the glossary entry used to insert the entry to the system
     * @return returns 1 if the insertion is a success and 0 if the insertion is un successful
     */
    public int insert(GlossaryEntry glossaryEntry) {
        return glossaryEntryDB.insert(glossaryEntry);
    }
    
    public List<GlossaryEntry> getMatched(String term) {
        return glossaryEntryDB.getMatched(term);
    }
}
