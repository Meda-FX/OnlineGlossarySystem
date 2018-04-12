/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Privilege;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.PrivilegeBroker;

/**
 * PrivilegeService class uses to access data from the database by utilizing the
 * PrivilegeBroker.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class PrivilegeService {

    private PrivilegeBroker privilegeDB;

    /**
     * Constructs a Privilege service object
     */
    public PrivilegeService() {
        privilegeDB = new PrivilegeBroker();
    }
    /**
     * get method used to get a Privilege by using privilegeID
     * @param privilegeID privilegeID is the id of a privilege to get
     * @return the privilege that is get by the search
     */
    public Privilege get(int privilegeID) {
        return privilegeDB.getByID(privilegeID);
    }
    /**
     * getAll method used to get all Privileges
     *
     * @return a list of privileges
     */
    public List<Privilege> getAll() {
        List<Object> objectList = privilegeDB.getAll();
        List<Privilege> privilegeList = new ArrayList<Privilege>();
        for (Object o : objectList) {
            privilegeList.add((Privilege) o);
        }
        return privilegeList;
    }

}
