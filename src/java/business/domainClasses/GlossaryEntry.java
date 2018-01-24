package business.domainClasses;

import java.util.Date;
import java.util.List;

/**
 * GlossaryEntry class constructs the glossary entry object it allowed mutation and accessing of the attributes of the glossary entry.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.1 
 */
public class GlossaryEntry {
    private Date dateCreated;
    private List<Definition> definitionList;
    private String term;
    private User createdBy;

    /**
     * constructs a glossary entry object  
     * @param dateCreated dateCreated the date in which the glossary created
     * @param definitionList definitionList the definition list of the glossary
     * @param term term the term of the glossary
     * @param createdBy createdBy the creator of the term
     */
    public GlossaryEntry(Date dateCreated, List<Definition> definitionList, String term, User createdBy) {
        this.dateCreated = dateCreated;
        this.definitionList = definitionList;
        this.term = term;
        this.createdBy = createdBy;
    }
    
    /**
     * Returns the date of the creation of the term
     * @return the date in which the term is created
     */
    public Date getDateCreated() {
        return dateCreated;
    }
    
    /**
     * Returns the definition list of the glossary
     * @return list of the definition list 
     */
    public List<Definition> getDefinitionList() {
        return definitionList;
    }

    /**
     * returns the term of the GlossaryEntry
     * @return the term of the GlossaryEntry
     */
    public String getTerm() {
        return term;
    }
    
    /**
     * Changes the term of the GlossaryEntry
     * @param term the term to be set
     */
    public void setTerm(String term) {
        this.term = term;
    }
    
    /**
     * Returns the creator of the term 
     * @return the creator of the term
     */
    public User getCreatedBy() {
        return createdBy;
    }    
}
