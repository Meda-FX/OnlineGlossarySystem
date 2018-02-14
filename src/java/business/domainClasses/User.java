package business.domainClasses;

/**
 * User class constructs the user object it allowed mutation and accessing of the attributes of the definition.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class User {
    private Department department;
    private String name;
    private String email;
    private String id;
    private String password;
    private PrivilegeList privileges;
    private CourseList courses;

    public User() {
    }
    
    
    
    /**
     * Constructs a User object for the online glossary system.   
     * 
     * @param department the department of the user 
     * @param name the name of the user
     * @param email the email of the user
     * @param id id the id of the user
     * @param password the password of the user
     * @param privileges the privilege given by the administrator if the glossary system manager
     * @param courses the corse that the user enrolled into.
     */
    public User(Department department, String name, String email, String id, String password, PrivilegeList privileges, CourseList courses) {
        this.department = department;
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
        this.privileges = privileges;
        this.courses = courses;
    }      
    
    /**
     * This method gets the department of the user from the user object 
     * @return department the department of the user to return
    */
    public Department getDepartment() {
        return department;
    }
    
    /**
     * Changes the department of the user 
     * @param department department the department to be set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    /**
     * Returns the name of the user of the glossary system
     * @return name returns the name of the user
     */
    public String getName() {
        return name;
    }
    
    /**
     * Changes the name of the user
     * @param name name the user name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * returns the email address of the user
     * @return method returns the email address of the user
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Changes the email address of the user in the glossary system
     * @param email email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * returns the id of the user
     * @return the id of the user
     */
    public String getID() {
        return id;
    }
    
    /**
     * Changes the id of the user
     * @param id id the id to be set
     */
    public void setID(String id) {
        this.id = id;
    }
    
    /**
     * The method gets and returns the user password
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * This method will change the users password
     * @param password password the password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * The method will return the privilege list. 
     * The privilege refers to the users access in the system
     * @return returns the PrivilegeList
     */
    public PrivilegeList getPrivileges() {
        return privileges;
    }
    
    /**
     * The method will return the list of the courses that the users 
     * @return the courseList of the users 
     */
    public CourseList getCourses() {
        return courses;
    }
}
