package business.serviceClasses;

import business.domainClasses.GlossaryRequest;
import java.util.ArrayList;
import java.util.List;
import persistence.GlossaryEntryBroker;

/**
 * GlossaryRequestService class uses to access data from the database by utilizing the GlossaryEntryBroker.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class GlossaryRequestService {
    private GlossaryEntryBroker requestDB;

    /**
     * Constructs a glossary request object 
     */
    public GlossaryRequestService() {
        this.requestDB = requestDB;
    }
    
    /**
     * Method used to get a glossary request made by the user using a specified string id
     * upon search if the request exists in the list the return type will be a glossary request object. If the 
     * search did not find the glossary request it returns a null value
     * @param id id the id that is passed to find a specific glossary request
     * @return returns a glossary request object if the request exists and null if it does not
     */
    public GlossaryRequest get(String id) {
        return null;
    }
    
    /**
     * Method that returns all list of glossary request objects
     * @return returns a list of all glossary requests made by the users
     */
    public List<GlossaryRequest> getAll() {
        return new ArrayList<GlossaryRequest>();
    }
    
    /**
     * Method used to delete a glossary object by using a specified id of the glossary request 
     * provided
     * @param id id the id of the glossary request to be deleted
     * @return returns 1 if the deletion is successful and 0 if the deletion is not a success
     */
    public int delete(int id){
        return 1;
    }
    
    /**
     * Method used to insert a glossary request object in to the system. If the return is 1 the insertion is a success
     * and if the return is 0 the insertion is unsuccessful. 
     * @param glossaryRequest glossaryRequest the glossary request object used to insert in  to
     * @return returns 1 if the insertion is successful and 0 if the insertion is not a success
     */
    public int insert(GlossaryRequest glossaryRequest) {
        return 1;
    }
    
    /**
     * Method used to update the glossary request in the system. If the return is 1 the update is a success
     * and if the return is 0 the update is unsuccessful. 
     * @param glossaryRequest glossaryRequest the glossary request to updated
     * @return returns 1 and 0 depending the condition. If the return is 1 the update is a success
     * and if the return is 0 the update is unsuccessful. 
     */
     public int update(GlossaryRequest glossaryRequest) {
        return 1;
    }    
}
