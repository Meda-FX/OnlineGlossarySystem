package business.domainClasses;

import java.util.Date;

/**
 * GlossaryRequest class constructs the glossary request object it allowed mutation and accessing of the attributes of the glossary request.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1 
 */
public class GlossaryRequest {
    private String glossaryEntryTerm;
    private Definition definition;
    private Integer requestType;
    private Integer requestID;
    private User requestedBy;
    private Date dateCreated;

    /**
     * Constructs a glossary request
     * @param glossaryEntryTerm glossaryEntryTerm the glossary term that is requested
     * @param definition definition the definition of the glossary that is requested
     * @param requestType requestType the type of the requested glossary
     * @param requestID requestedID the id that is requested
     * @param requestedBy requestBy the glossary request 
     * @param dateCreated dateCreated the date in which the glossary is created
     */
    public GlossaryRequest(String glossaryEntryTerm, Definition definition, Integer requestType, Integer requestID, User requestedBy, Date dateCreated) {
        this.glossaryEntryTerm = glossaryEntryTerm;
        this.definition = definition;
        this.requestType = requestType;
        this.requestID = requestID;
        this.requestedBy = requestedBy;
        this.dateCreated = dateCreated;
    }

    /**
     * returns the glossary entry term
     * @return the glossary term
     */
    public String getGlossaryEntryTerm() {
        return glossaryEntryTerm;
    }

    /**
     * Changes the glossary entry term
     * @param glossaryEntryTerm glossaryEntryTerm the glossary entry term to set
     */
    public void setGlossaryEntryTerm(String glossaryEntryTerm) {
        this.glossaryEntryTerm = glossaryEntryTerm;
    }

    /**
     * Returns the definition of the glossary request
     * @return the definition of the term
     */
    public Definition getDefinition() {
        return definition;
    }

    /**
     * Changes the definition of the request
     * @param definition definition the definition to be set
     */
    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    /**
     * Returns the type of the request
     * @return the type of the request
     */
    public Integer getRequestType() {
        return requestType;
    }

    /**
     * Changes the request type of the glossary request
     * @param requestType requestType the request type to be set
     */
    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    /**
     * Returns the request id for the glossary request
     * @return the request id
     */
    public Integer getRequestedID() {
        return requestID;
    }

    /**
     * Changes the request id of for the glossary request
     * @param requestedID requestedID the id if the request to be set
     */
    public void setRequestedID(Integer requestedID) {
        this.requestID = requestedID;
    }

    /**
     * Returns the instructor that requested the term
     * @return the user of the requester 
     */
    public User getRequestedBy() {
        return requestedBy;
    }

    /**
     * Changes the requester 
     * @param requestedBy requestedBy the user to be set
     */
    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    /**
     * Returns the date of the term created
     * @return the date in which the term is created
     */
    public Date getDateCreated() {
        return dateCreated;
    }
}
