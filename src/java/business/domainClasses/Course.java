package business.domainClasses;

/**
 * Course class contains the data of the courses that exists in SAIT. The class constructs the course object.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class Course {
    private String courseCode;
    private String courseName;
    private Department department;

    /**
     * Constructs a course object for courses exists in the system
     * @param courseCode courseCode the course code of the courses
     * @param courseName courseName the course name of the courses
     * @param department department the department i which he courses reside
     */
    public Course(String courseCode, String courseName, Department department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
    }

    /**
     * Returns the course code of the course 
     * @return courseCode the course code to return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Changes the course code of the course
     * @param courseCode courseCode the course of the course
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Returns the course name of the course
     * @return courseName the course name to return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Changes the course name of the course selected
     * @param courseName courseName the course name to be set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns the department in which the course belong to
     * @return the department to be returned
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Changes the department of the course
     * @param department department the department to be set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }    
    
    @Override
    public boolean equals(Object o) {
        Course toCompare = (Course)o;
        return toCompare.getCourseCode().equals(this.courseCode);
    }
}
