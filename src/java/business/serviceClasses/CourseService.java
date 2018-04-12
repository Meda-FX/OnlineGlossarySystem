/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.User;
import java.util.List;
import persistence.brokers.CourseBroker;

/**
 * CourseService class uses to access data from the database by utilizing the
 * CourseBroker.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class CourseService {

    private CourseBroker courseDB;

    /**
     * Constructs a Course Service object
     */
    public CourseService() {
        courseDB = new CourseBroker();
    }

    /**
     * get method used to get a course by using courseCode
     *
     * @param courseCode courseCode is the code of a course to get
     * @return the course that is get by the search
     */
    public Course get(String courseCode) {
        return courseDB.getByCourseCode(courseCode);
    }

    /**
     * getByDepartment method used to get all courses under department
     *
     * @param department represents the department to search
     * @return a list of courses
     */
    public List<Course> getByDepartment(Department department) {
        return courseDB.getByDepartmentID(department);
    }

    /**
     * The getByUser method returns a list of courses related to the user.
     *
     * @param user represents the account in the user table in the database.
     * @return a list of course by user.
     */
    public List<Course> getByUser(User user) {
        return courseDB.getByUser(user);
    }
    /**
     * update method used to update course
     *
     * @param course represents the course to update
     * @return if operation perform well return 1, else 0
     */
    public int update(Course course) {
        return courseDB.update(course);
    }
    /**
     * insert method used to insert course
     *
     * @param course represents the course to insert
     * @return if operation perform well return 1, else 0
     */
    public int insert(Course course) {
        return courseDB.insert(course);
    }
    /**
     * delete method used to delete course
     *
     * @param course represents the course to delete
     * @return if operation perform well return 1, else 0
     */
    public int delete(Course course) {
        return courseDB.delete(course);
    }

    /**
     * search method is to all the courses that partially matches the input with
     * course code or course name
     *
     * @param searchWith the text needs to search with
     * @return a list course fulfill requirements
     */
    public List<Course> search(String searchWith) {
        return courseDB.search(searchWith);
    }
}
