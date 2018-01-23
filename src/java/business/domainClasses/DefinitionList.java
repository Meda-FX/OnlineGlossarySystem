package business.domainClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * DefinitionList class used to list, add, remove, edit and delete the definitions that are set by the user.
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
     * Returns the definition of all terms
     * @return the definitions of all terms
     */
    private List<Definition> getAll(){
        return new ArrayList<Definition>();        
    }
    
    /**
     * Returns the course of the definition belongs to
     * @param course course the course to be set
     * @return the course of the definition 
     */
    private List<Definition> getByCourse(Course course){
        return new ArrayList<Definition>();
    }
    
    /**
     * Gets the instructor of the definition writer
     * @param writtenBy writtenBy the writer of the definition parameter
     * @return the instructor of the definition writer
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
