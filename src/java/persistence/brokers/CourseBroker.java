package persistence.brokers;

import business.domainClasses.Course;
import java.util.List;

/**
 * The CourseBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Course from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class CourseBroker extends Broker{

    /**
     * The getByID method returns the course by the specified course ID.
     *
     * @param courseID represents the ID for a certain course.
     * @return a Course object representing a course from the database.
     */
    public Course getByID(String courseID) {
        return null;
    }

    /**
     * The getByDepartmentID return a list of courses by the specified
     * department ID.
     *
     * @param departmentID represents the ID for a certain department.
     * @return a list of Course objects representing courses from the database.
     */
    public List<Course> getByDepartmentID(int departmentID) {
        return null;

    }

    @Override
    public int insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
