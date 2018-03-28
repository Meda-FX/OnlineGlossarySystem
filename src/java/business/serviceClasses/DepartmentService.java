/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Department;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.DepartmentBroker;

/**
 *
 * @author 727153
 */
public class DepartmentService {
    private DepartmentBroker db;

    public DepartmentService() {
        db = new DepartmentBroker();
    }
    
    public List<Department> getAll() {
        List<Object> objectList = db.getAll();
        List<Department> departmentList = new ArrayList<Department>();
        for (Object o: objectList) {
            departmentList.add((Department)o);
        }
        return departmentList;
    }
}
