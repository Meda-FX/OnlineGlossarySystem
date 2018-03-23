/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import java.util.List;
import persistence.brokers.DefinitionBroker;

/**
 *
 * @author 715583
 */
public class DefinitionService {
    private DefinitionBroker db;
    
    public DefinitionService()
    {
        db = new DefinitionBroker();
    }
    
    public List<Definition> getByCourse(Course course) {
        //need to use definition broker somewhere
       return db.getByCourse(course);
    }
    
    public int insert (Definition definition){
        return db.insert(definition);
    }
}
