package business.domainClasses;

import java.util.Date;

/**
 * GlossaryEntry class constructs the glossary entry object it allowed mutation
 * and accessing of the attributes of the glossary entry.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0
 */
public class GlossaryEntry {

    private Date dateCreated;
    private DefinitionList definitionList;
    private String term;
    private User createdBy;

    public GlossaryEntry() {
        definitionList = new DefinitionList();
    }

    /**
     * constructs a glossary entry object
     *
     * @param dateCreated dateCreated the date in which the glossary created
     * @param definitionList definitionList the definition list of the glossary
     * @param term term the term of the glossary
     * @param createdBy createdBy the creator of the term
     */
    public GlossaryEntry(Date dateCreated, DefinitionList definitionList, String term, User createdBy) {
        this.dateCreated = dateCreated;
        this.definitionList = definitionList;
        this.term = term;
        this.createdBy = createdBy;
    }

    /**
     * constructs a glossary entry object
     *
     * @param dateCreated dateCreated the date in which the glossary created
     * @param term term the term of the glossary
     * @param createdBy createdBy the creator of the term
     */
    public GlossaryEntry(Date dateCreated, String term, User createdBy) {
        this.dateCreated = dateCreated;
        this.term = term;
        this.createdBy = createdBy;
    }

    /**
     * Returns the date of the creation of the term
     *
     * @return the date in which the term is created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns the definition list of the glossary
     *
     * @return list of the definition list
     */
    public DefinitionList getDefinitionList() {
        return definitionList;
    }

    /**
     * returns the term of the GlossaryEntry
     *
     * @return the term of the GlossaryEntry
     */
    public String getTerm() {
        return term;
    }

    /**
     * Changes the term of the GlossaryEntry
     *
     * @param term the term to be set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Returns the creator of the term
     *
     * @return the creator of the term
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * set the created date
     *
     * @param dateCreated the date of creation
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * set the user who create the entry
     *
     * @param createdBy the user who create the entry
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

}
