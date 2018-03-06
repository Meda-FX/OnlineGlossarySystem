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
 *
 * @author 727153
 */
public class PrivilegeService {
    private PrivilegeBroker privilegeDB;
    
    public PrivilegeService() {
        privilegeDB = new PrivilegeBroker();
    }
    
    public Privilege get(int privilegeID) {
        return privilegeDB.getByID(privilegeID);
    }

    public List<Privilege> getAll() {
        List<Object> objectList = privilegeDB.getAll();
        List<Privilege> privilegeList = new ArrayList<Privilege>();
        for (Object o: objectList) {
            privilegeList.add((Privilege)o);
        }
        return privilegeList;
    }
    
    
}
