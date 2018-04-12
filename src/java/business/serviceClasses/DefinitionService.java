/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.serviceClasses;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.Department;
import business.domainClasses.User;
import java.util.ArrayList;
import java.util.List;
import persistence.brokers.DefinitionBroker;

/**
 * DefinitionService class uses to access data from the database by utilizing
 * the DefinitionService.
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class DefinitionService {

    private DefinitionBroker db;

    /**
     * Constructs a Definition service object
     */
    public DefinitionService() {
        db = new DefinitionBroker();
    }

    /**
     * getByCourse method used to get all terms/definitions by course
     *
     * @param course represents the course to search
     * @return a list of definitions
     */
    public List<Definition> getByCourse(Course course) {
        //need to use definition broker somewhere
        return db.getByCourse(course);
    }

    /**
     * getByDepartment method used to get all terms/definitions by department
     *
     * @param department represents the department to search
     * @return a list of definitions
     */
    public List<Definition> getByDepartment(Department department) {
        //need to use definition broker somewhere
        return db.getByDepartment(department);
    }

    /**
     * getByDepartmentFilterByTCU method used to get a term list under a
     * particular department which may filtered by searched text, course and
     * instructor/user
     *
     * @param department represents department to search
     * @param txtSearch represents the text to filter
     * @param courseCode represents the course code of a course to filter
     * @param userId represents the user ID of a user to filter
     * @return a list of definition fulfill the requirements
     */
    public List<Definition> getByDepartmentFilterByTCU(Department department, String txtSearch, String courseCode, String userId) {

        return db.getByDepartmentFilterByTCU(department, txtSearch, courseCode, userId);
    }

    /**
     * insert method used to insert definition
     *
     * @param definition represents the definition to insert
     * @return if operation perform well return 1, else 0
     */
    public int insert(Definition definition) {
        return db.insert(definition);
    }

    /**
     * update method used to update definition
     *
     * @param definition represents the definition to insert
     * @return if operation perform well return 1, else 0
     */
    public int update(Definition definition) {
        // need to update the date first
        // definition.setDateLastModified();
        return db.update(definition);
    }

    /**
     * delete method used to delete definition
     *
     * @param definition represents the definition to insert
     * @return if operation perform well return 1, else 0
     */
    public int delete(Definition definition) {
        // need to update the date first
        // definition.setDateLastModified();
        return db.delete(definition);
    }

    /**
     * The getByMadeBy method returns a list of definitions related to the user.
     *
     * @param user represents the account in the user table in the database.
     * @return a list of definitions by user.
     */
    public List<Definition> getByMadeBy(User user) {
        return db.getByUserAndCourse(user);
    }

    /**
     * The getById method returns a definition related to the user's ID.
     *
     * @param id represents the definition_id column in the course table in the
     * database.
     * @return a definition of a term
     */
    public Definition getByID(int id) {
        return db.getByID(id);
    }

    /**
     * getMatchedFilterByDepart method used to all matched term which means a
     * term contains input term under a particular department
     *
     * @param searchEntry represents the text to search
     * @param deptId represents the id of the department to filter
     * @return a list of definition fulfill the requirements
     */
    public List<Definition> getMatchedFilterByDepart(String searchEntry, int deptId) {

        return db.getMatchedFilterByDepart(searchEntry, deptId);

    }

    /**
     * getMatchedFilterByCU method used to get a term list which may filtered by
     * searched text, course and instructor/user
     *
     * @param searchedEntry represents the text to filter
     * @param courseCode represents the course code of a course to filter
     * @param userId represents the user ID of a user to filter
     * @return a list of definition fulfill the requirements
     */
    public List<Definition> getMatchedFilterByCU(String searchedEntry, String courseCode, String userId) {
        return db.getMatchedFilterByCU(searchedEntry, courseCode, userId);
    }

    /**
     * getMatched method used to all terms contain input term in it.
     *
     * @param searchedEntry needs to be checked in DB that any terms contain it
     * @return a term list with all required term
     */
    public List<Definition> getMatched(String searchedEntry) {
        return db.getMatched(searchedEntry);
    }

    /**
     * getByAlpha method used to get a list of terms starts with particular
     * letter
     *
     * @param letter the particular letter from A-Z
     * @return a term list of terms started with the letter
     */
    public ArrayList<Definition> getByAlpha(String letter) {
        return db.getByAlpha(letter);
    }

}
