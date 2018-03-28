package business.domainClasses;

/**
 * Department class constructs the department object it allowed mutation and accessing of the attributes of the department.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0
 */
public class Department {    
    private int departmentID;
    private String name;
    
    public Department() {
    }
    
    public Department(int departmentID) {
        this.departmentID = departmentID;
    }
    
    /**
     * Constructs the department of the users 
     * @param departmentID departmentID the department id of the school departments
     * @param name name is the name of the department at the school department
     */
    public Department(int departmentID, String name) {
        this.departmentID = departmentID;
        this.name = name;
    }
    
    /**
     * Returns the department number of the school
     * @return gets the department number and returns it
     */
    public int getDepartmentID() {
        return departmentID;
    }
    
    /**
     * Changes the department id of the school 
     * @param departmentID departmentID is the department id to be set
     */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    
    /**
     * Returns the name of the school department 
     * @return the name of the department
     */
    public String getName() {
        return name;
    }
    
    /**
     * Changes the name of the selected school department  
     * @param name name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }    
}
