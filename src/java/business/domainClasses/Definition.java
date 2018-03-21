package business.domainClasses;

import java.util.Date;

/**
 * Definition class constructs the definition object it allowed mutation and accessing of the attributes of the definition.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0 
 */
public class Definition {
    private User writtenBy;
    private Date dateCreated;
    private String citation;
    private String dictionaryCitation;
    private Course course;
    private String content;
    private String dictionaryContent;
    private Date dateLastModified;
    private int definitionID; //need to change to int
    private String term;
    private int status;
    /*
    definition_uid int IDENTITY(1,1) PRIMARY KEY, 
	glossary_entry varchar (40) NOT NULL,   
        definition varchar (500) NOT NULL,
        dictionary_definition varchar(500) NOT NULL,
	date_created datetime NOT NULL,
	citation varchar(100) ,
	activated bit NOT NULL,
        dictionary_citation varchar(100)NOT NULL,
	made_by Varchar(20) NOT NULL,
	course_code varchar (20
    */

    public Definition() {
    }
    
    /**
     * Constructs the definition object 
     * @param writtenBy writtenBy the writer of the definition
     * @param dateCreated dateCreated the date in which the definition is created
     * @param citation citation the original writer of the definition credit
     * @param course course the course in which the definition is written
     * @param content content the content of the definition written by the user
     */
    public Definition(User writtenBy, Date dateCreated, String citation, 
            String dictionaryCitation, Course course, String content, 
            String dictionaryContent, String term, int status) {
        this.writtenBy = writtenBy;
        this.dateCreated = dateCreated;
        this.citation = citation;
        this.dictionaryCitation = dictionaryCitation;
        this.course = course;
        this.content = content;
        this.dictionaryContent = dictionaryContent;
        this.term = term;
        this.status=status;
    }

    /**
     * Returns the writer of the definition
     * @return the writer of the definition
     */
    public User getWrittenBy() {
        return writtenBy;
    }

    /**
     * Changes the writer of the definition
     * @param writtenBy writtenBy the writer of the definition to set
     */
    public void setWrittenBy(User writtenBy) {
        this.writtenBy = writtenBy;
    }

    /**
     * Returns the date of the definition created
     * @return the date in which the definition is created
     */
    public Date getDateCreated() {
        return dateCreated;
    }
    
    /**
     * Sets the date of the definition created
     * @param date representing the current date
     */
    public void setDateCreated(Date date) {
        this.dateCreated = date;
    }

    /**
     * Returns the citation of the definition
     * @return returns the citation of the definition
     */
    public String getCitation() {
        return citation;
    }

    /**
     * Changes the citation of the definition
     * @param citation citation the citation to be set
     */
    public void setCitation(String citation) {
        this.citation = citation;
    }

    /**
     * Returns the course of the definition belongs to
     * @return the course in which the definition belongs to
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Changes the course of the definition belongs to
     * @param course course the course to be set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * returns the content of the definition 
     * @return the content of the definition
     */
    public String getContent() {
        return content;
    }

    /**
     * Changes the content of the definition 
     * @param content content the content to be set
     */
    public void setContent(String content) {
        this.content = content;
    }    

    /**
     * Returns the date of the definition las modified
     * @return the date in which the definition is last modified 
     */
    public Date getDateLastModified() {
        return dateLastModified;
    }

    /**
     * Changes the date of the definition modified time
     * @param dateLastModified dateLastModified the date to be set
     */
    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    /**
     * Returns the id of the definition
     * @return the definition id
     */
    public int getDefinitionID() {
        return definitionID;
    }

    /**
     * Changes the definition id of the term
     * @param definitionID definitionID the definition id to be set
     */
    public void setDefinitionID(int definitionID) {
        this.definitionID = definitionID;
    }

    /**
     * Returns the dictionary definition citation
     * @return the dictionary definition citation
     */
    public String getDictionaryCitation() {
        return dictionaryCitation;
    }

    /**
     * Changes the dictionary definition citation
     * @param dictionaryCitation is the new value of dictionaryCitation
     */
    public void setDictionaryCitation(String dictionaryCitation) {
        this.dictionaryCitation = dictionaryCitation;
    }    
    
    
    /**
     * Returns the diction content in string format
     * @return dictionary Content
     */
    public String getDictionaryContent(){
        return dictionaryContent;
    }
    /**
     * Gives dictionaryContent a new value
     * @param dictionaryContent is the new  value for dictionaryContent
     */
    public void setDictionaryContent(String dictionaryContent){
        this.dictionaryContent = dictionaryContent;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
