package business.domainClasses;

import business.serviceClasses.PrivilegeService;
import java.util.ArrayList;
import java.util.List;

/**
 * PrivilegeList class used to list, add, remove by id, and checks the availability of the users privilege.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class PrivilegeList {
    private List<Privilege> privileges;

    /**
     * Constructs the privilege list of the users
     */
    public PrivilegeList() {
        privileges = new ArrayList<Privilege>();
    }

    /**
     * Returns all of the privileges 
     * @return the list of the privileges
     */
    public List<Privilege> getPrivileges() {
        return privileges;
    }
    
    /**
     * A method that adds a privilege for a user using the 
     * privilege id that is passed as a parameter
     * @param privilegeID privilegeID the parameter that is passed to add a user privilege
     */
    public void add(Privilege newPrivilege) {
        privileges.add(newPrivilege);
    }
    
    /**
     * A method that removes a privilege that is granted to a user by passing 
     * a parameter privilege id
     * @param privilegeID privilegeID the privilege id that is passed in order to remove 
     * the privilege granted for the user
     */
    public void removeByID(int privilegeID) {
        for (Privilege privilege: privileges) {
            if (privilege.getPrivilegeID() == privilegeID)
                privileges.remove(privilege);
        }
    }
    
    /**
     * Method that checks if an id exists in the list
     * @param privilegeID privilegeID the privilege id that is passed in order to check of the 
     * id exists in the list
     * @return true if contains the privilege id that is passed as
     * a parameter
     */
    public boolean contains(int privilegeID) { 
        for (Privilege privilege: privileges) {
            if (privilege.getPrivilegeID() == privilegeID)
                return true;
        }
        return false;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
    
}
