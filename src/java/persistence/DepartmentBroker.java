package persistence;

import business.domainClasses.Department;
import java.util.List;

/**
 * The DepartmentBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Department from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class DepartmentBroker extends Broker{

    /**
     * The getByID method gets the department with the ID of a department.
     *
     * @param departmentID represents the ID of a department.
     * @return a Department object from the Department database.
     */
    public Department getByID(String departmentID) {
        return null;
    }

    @Override
    public Integer insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
