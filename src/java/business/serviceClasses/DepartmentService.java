/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Department;
import business.domainClasses.User;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.DepartmentBroker;

/**
 * DepartmentService class uses to access data from the database by utilizing the
 * DepartmentBroker.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class DepartmentService {
    private DepartmentBroker db;
    /**
     * Constructs a Department service object
     */
    public DepartmentService() {
        db = new DepartmentBroker();
    }
    /**
     * getAll method used to get all Departments
     *
     * @return a list of Departments
     */
    public List<Department> getAll() {
        List<Object> objectList = db.getAll();
        List<Department> departmentList = new ArrayList<Department>();
        for (Object o: objectList) {
            departmentList.add((Department)o);
        }
        return departmentList;
    }
    


    public Department  getByUserID(User user) {
        return db.getByUserID(user);
    }


}
