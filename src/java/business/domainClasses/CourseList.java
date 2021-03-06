package business.domainClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseList class contain a list of course for a specific user. Methods used in these class are used to fetch lists of courses,
 * add, and remove courses.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class CourseList {
    private List<Course> courses;

    /**
     * Constructs a course list of the courses in the school
     */
    public CourseList() {
        courses = new ArrayList<Course>();
    }
    
    /**
     * Returns all of the courses from the list 
     * @return the list of all courses
     */
    public List<Course> getCourses() { 
        return courses;
    }
    
    /**
     * Adds a course in to the list using a parameter course code
     * @param newCourse courseCode the course code to be added to the list
     */
    public void add(Course newCourse) {
        courses.add(newCourse);
    }
    
    /**
     * Removes a course from the course by accessing the list using a course code
     * provided as a parameter
     * @param courseCode courseCode the course code to be removed
     */
    public void remove(String courseCode) {
        for (Course course: courses) {
            if (course.getCourseCode().equals(courseCode))
                courses.remove(course);
        }
    }
    
    /**
     * Checks if the the course exists inside the list using a parameter courseCode 
     * @param courseCode courseCode the course code to be checked
     * @return returns true if the course exists in the list
     */
    public boolean contains(String courseCode) {
       for (Course course: courses) {
           if (course.getCourseCode().equals(courseCode))
               return true;
       }
       return false;
    }
/**
 * set a list of course
 * @param courses  a list of course to be set
 */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
/**
 * the reload method used update the course list
 * @param selectedCourse the course list used to replace the old list
 */
    public void reload(String[] selectedCourse) {
        //Tools | Templates.
        List<Course> courselist = new ArrayList<>();
        Course course=null;
        int len = 0;
        if(selectedCourse!=null) len = selectedCourse.length;
        
        for(int i=0;i<len;i++)
        {
            course = new Course();
            course.setCourseCode(selectedCourse[i]);
            courselist.add(course);
        }
        courses=courselist;
    }
}
