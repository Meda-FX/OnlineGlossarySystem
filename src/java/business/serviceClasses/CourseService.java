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

public class CourseService {
    private CourseBroker courseDB;
    
    public CourseService() {
        courseDB = new CourseBroker();
    }
    
    public Course get(String courseCode) {
        return courseDB.getByCourseCode(courseCode);
    }

    public List<Course> getByDepartment(Department department) {
        return courseDB.getByDepartmentID(department);
    }

    public List<Course> getByUser(User user) {
        return courseDB.getByUser(user);
    }


    
    public int insert(Course course) {
        return courseDB.insert(course);
    }
    
    public int delete(Course course) {
        return courseDB.delete(course);
    }
}
