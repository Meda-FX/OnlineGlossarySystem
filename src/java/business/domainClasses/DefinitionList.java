package business.domainClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * DefinitionList class used to list, add, remove, edit and delete the definitions of a GlossaryEntry.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class DefinitionList {
    private List<Definition> definitionList;

    /**
     * Constructor for the definition list
     */
    public DefinitionList() {
    }
    
    /**
     * Returns all definitions of the term
     * @return all definitions of the term
     */
    private List<Definition> getAll(){
        return new ArrayList<Definition>();        
    }
    
    /**
     * Returns the definitions belong to the same courses
     * @param course the course the definitions belong to
     * @return the definitions belong to the course 
     */
    private List<Definition> getByCourse(Course course){
        return new ArrayList<Definition>();
    }
    
    /**
     * Returns the definitions written by the User
     * @param writtenBy the User created the definition
     * @return the definitions written by the same User
     */
    private List<Definition> getByInstructor(User writtenBy){
        return new ArrayList<Definition>();
    }
          
    /**
     * Adds a definition to the list
     * @param definition definition the definition to be added to the list
     */
    private void add(Definition definition){ }
    
    /**
     * removes the definition from the list
     * @param definition definition the definition to be removed
     */
    private void remove(Definition definition){ }
    
    /**
     * Edits the definition from the list 
     * @param toEdit toEdit the definition to be edited
     * @param newDefinition newDefinition the new definition to be edited
     */
    private void edit(Definition toEdit, Definition newDefinition) { } 
}
