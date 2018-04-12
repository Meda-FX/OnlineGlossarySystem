/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.domainClasses;

import java.util.Date;

/**
 * AccountLog class constructs the account log object it allowed mutation and
 * accessing of the attributes of account logs.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 1.0
 */
public class AccountLog {

    private int activityType;
    private User activityBy;
    private Date activityDate;

    /**
     * Constructs a glossary request
     *
     * @param activityType activityType the type of the requested glossary
     * @param activityBy requestBy the glossary request
     * @param activityDate activityDate the date in which the glossary is
     * created
     */
    public AccountLog(int activityType, User activityBy, Date activityDate) {
        this.activityType = activityType;
        this.activityBy = activityBy;
        this.activityDate = activityDate;
    }

    /**
     * Returns the type of the request
     *
     * @return the type of the request
     */
    public int getActivityType() {
        return activityType;
    }

    /**
     * Changes the request type of the glossary request
     *
     * @param activityType activityType the request type to be set
     */
    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    /**
     * Returns the instructor that requested the term
     *
     * @return the user of the requester
     */
    public User getActivityBy() {
        return activityBy;
    }

    /**
     * Changes the requester
     *
     * @param activityBy activityBy the user to be set
     */
    public void setActivityBy(User activityBy) {
        this.activityBy = activityBy;
    }

    /**
     * Returns the date of the term created
     *
     * @return the date in which the term is created
     */
    public Date getActivityDate() {
        return activityDate;
    }

    /**
     * Set the activity date of the account log
     *
     * @param activityDate the activity date of the account log
     */
    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}
