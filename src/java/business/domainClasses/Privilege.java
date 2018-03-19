package business.domainClasses;

/**
 * Privilege class constructs the privilege object it allowed mutation and accessing of the attributes of the privileges of users.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class Privilege {
    private int privilegeID;
    private String description;

    public Privilege() {
    }

    public Privilege(int privilegeID) {
        this.setPrivilegeID(privilegeID);
    }
    
    /**
     * Constructs a privilege object consist of id and description of the privilege type.
     * Privilege types includes instructor, editor and administrator
     * @param privilegeID privilegeID the privilege id 
     * @param description description the description of the type of the privilege
     */
    public Privilege(int privilegeID, String description) {
        this.privilegeID = privilegeID;
        this.description = description;
    }

    /**
     * method that returns the id of the privilege
     * @return privilegeID the id to return
     */
    public int getPrivilegeID() {
        return privilegeID;
    }

    /**
     * Changes the privilege id to a desired id
     * @param privilegeID privilegeID the privilege id to be set
     */
    public void setPrivilegeID(int privilegeID) {
        this.privilegeID = privilegeID;
    }

    /**
     * Returns the description of the privilege type
     * @return the description to be returned
     */
    public String getDescription() {
        return description;
    }

    /**
     * Changes the description of the privilege 
     * @param description description the privilege description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }    
    
    @Override
    public boolean equals(Object o) {
        Privilege toCompare = (Privilege)o;
        return toCompare.getPrivilegeID() == this.privilegeID;
    }
}
