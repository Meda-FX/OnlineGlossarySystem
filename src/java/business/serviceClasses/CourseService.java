/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Course;
import persistence.brokers.CourseBroker;

/**
 *
 * @author 727153
 */
public class CourseService {
    private CourseBroker courseDB;
    
    public CourseService() {}
    
    public Course get(String courseCode) {
        return null;
    }
}
