package business.domainClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * DefinitionList class used to list, add, remove, edit and delete the definitions of a GlossaryEntry.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class DefinitionList {
    private List<Definition> definitionList;

    /**
     * Constructor for the definition list
     */
    public DefinitionList() {
        definitionList = new ArrayList<Definition>();
    }
    
    /**
     * Returns all definitions of the term
     * @return all definitions of the term
     */
    public List<Definition> getDefinitionList(){
        return definitionList;        
    }
    
    /**
     * Returns the definitions belong to the same courses
     * @param course the course the definitions belong to
     * @return the definitions belong to the course 
     */
    public List<Definition> getByCourse(Course course){
        ArrayList<Definition> definitionListByCourse = new ArrayList<Definition>();
        for (Definition definition: definitionList) {
            if (definition.getCourse().equals(course))
                definitionListByCourse.add(definition);
        }
        return definitionListByCourse;
    }
    
    /**
     * Returns the definitions written by the User
     * @param writtenBy the User created the definition
     * @return the definitions written by the same User
     */
    public List<Definition> getByInstructor(User writtenBy){
        ArrayList<Definition> definitionListByInstructor = new ArrayList<Definition>();
        for (Definition definition: definitionList) {
            if (definition.getWrittenBy().equals(writtenBy))
                definitionListByInstructor.add(definition);
        }
        return definitionListByInstructor;
    }
          
    /**
     * Adds a definition to the list
     * @param definition definition the definition to be added to the list
     */
    public void add(Definition definition){
        definitionList.add(definition);
    }
    
    /**
     * removes the definition from the list
     * @param definition definition the definition to be removed
     */
    public void remove(Definition definition){
        definitionList.remove(definition);
    }
    
    /**
     * Edits the definition from the list 
     * @param toEdit toEdit the definition to be edited
     * @param newDefinition newDefinition the new definition to be edited
     */
    public void edit(Definition toEdit, Definition newDefinition) {
        definitionList.set(definitionList.indexOf(toEdit), newDefinition);
    } 
}
