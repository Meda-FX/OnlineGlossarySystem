package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import persistence.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The DefinitionBroker provide connectivity to the database and allow
 * insertion, retrieval and removal of Definition from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class DefinitionBroker extends Broker {

    /**
     * The getById method returns a definition related to the user's ID.
     *
     * @param id represents the course in the course table in the database.
     * @return a definition of a term
     */
    public Definition getByID(int did) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        //  ArrayList<Definition> delist = new ArrayList<>();
        Definition definition = null;
        Course course;
        User user;
        
        String term;
        String name;
        String userid;
        String courseId;
        String course_name;
        String content;
        String citation;
        String definitionID;
        String dictionaryContent;
        String dictionaryCitation;
        java.util.Date newDate;
        
        String selectSQL = "SELECT * "
                            + "from [dbo].[definition] "
                            + "join [dbo].[course] "
                            + "on (definition.course_code=course.course_code) "
                            + "join [dbo].[user] "
                            + "on (definition.made_by=[dbo].[user].user_id) "
                            + "where definition_uid = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, did);
            rs = ps.executeQuery();
            while (rs.next()) {
                definition= new Definition();
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                name = rs.getString("name");
                userid=rs.getString("user_id");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                user = new User();
                user.setID(userid);
                user.setName(name);
                courseId = rs.getString("course_code"); // need to get course info
                course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                course.setCourseName(course_name);
                // definition = new definition(user,)
                definition = new Definition(user, newDate, citation, dictionaryCitation, 
                        course, content, dictionaryContent, term);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return definition;
    }

    /**
     * The getByCourse method returns a list of definitions related to the user.
     *
     * @param course represents the course in the course table in the database.
     * @return a list of definitions by course.
     */
    public List<Definition> getByCourse(Course course) {
          ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Definition> delist = new ArrayList<>();
     
        Definition definition = null;
      //  Course course;
        User user;
        
        String term;
        String name;
        String userid;
        String courseId;
        String course_name;
        String content;
        String citation;
        String definitionID;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;

        String selectSQL = "SELECT * "
                            + "from [dbo].[definition] "
                            + "join [dbo].[user] "
                            + "on (definition.made_by=[dbo].[user].user_id) "
                            + "where [dbo].[definition].course_code = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseCode());
            rs = ps.executeQuery();
            while (rs.next()) {
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                name = rs.getString("name");
                userid=rs.getString("user_id");
                user = new User();
                user.setID(userid);
                user.setName(name);
                // definition = new definition(user,)
                definition = new Definition(user, newDate, citation, 
                        dictionaryCitation, course, content, 
                        dictionaryContent, term);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return delist;
    }


    /**
     * The getByUser method returns a list of definitions related to the user.
     *
     * @param user represents the account in the user table in the database.
     * @return a list of definitions by user.
     */
    
    public List<Definition> getByUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Definition> delist = new ArrayList<>();
        Definition definition;

        String term;
        Course course;
        String courseId;
        String course_name;
        String content;
        String citation;
        String definitionID;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;

        String selectSQL = "SELECT * "
                            + "from [dbo].[definition] "
                            + "join [dbo].[course] "
                            + "on (definition.course_code=course.course_code) "
                            + "where made_by =?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                courseId = rs.getString("course_code"); // need to get course info
                course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                course.setCourseName(course_name);
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                // definition = new definition(user,)
                definition = new Definition(user, newDate, citation, 
                        dictionaryCitation, course, content, 
                        dictionaryContent, term);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return delist;
    }


    /**
     * The getByGlossaryEntry returns a list of definitions related to the entry
     * in the glossary.
     *
     * @param glossary represents an entry in the glossary.
     * @return a list of definitions by glossary entry.
     */

    public DefinitionList getByGlossaryEntry(GlossaryEntry glossary) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefinitionList list = new DefinitionList();
        String selectSQL = "SELECT * "
                            + "FROM [GlossaryDataBase].[dbo].[definition] "
                            + "join [dbo].[course] "
                            + "on (definition.course_code=course.course_code) "
                            + "join [dbo].[user] "
                            + "on (definition.made_by=[dbo].[user].user_id) "
                            + "where glossary_entry = ?;";
        Definition definition;
        Course course;
        User user;
        String definitionUid;
        String glossaryEntry;
        String content;
        Date dateCreated;
        String citation;
        String madeBy;
        String courseId;
        String dictionaryContent;
        String dictionaryCitation;
        String name;
        String course_name;
        try {
            ps = connection.prepareCall(selectSQL);
            ps.setString(1, glossary.getTerm());
            rs = ps.executeQuery();
            while(rs.next()){
                definitionUid = rs.getString("definition_uid");
                glossaryEntry = rs.getString("glossary_entry");
                content = rs.getString("definition");
                dateCreated = new Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                madeBy = rs.getString("made_by");
                courseId = rs.getString("course_id");       
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                name = rs.getString("name");
                user = new User();
                user.setID(madeBy);
                user.setName(name);
                courseId = rs.getString("course_code"); // need to get course info
                course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                course.setCourseName(course_name);
                definition = new Definition(user, dateCreated, citation, dictionaryCitation, 
                        course, content, dictionaryContent, glossary.getTerm());
                list.add(definition);
            }
        } catch (SQLException e) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, e);

        }

        return list;
    }
    @Override
    public int delete(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "DELETE FROM definition WHERE definition_uid=?";
               

        PreparedStatement ps = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, definition.getDefinitionID());


            affectRows = ps.executeUpdate();
            // may need to update the definition edit log
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return affectRows;
    }

    @Override
    public int update(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "UPDATE definition \n"
                + "SET (definition=?,dictionary_definition=?,"
                + "citation=?,dictionary_citation=?,made_by=?,course_code=?)\n"
                + "WHERE definition_uid=?";

        PreparedStatement ps = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(sql);
            //ps.setString(1, definition.getTerm());
            ps.setString(1, definition.getContent());
            ps.setString(2, definition.getDictionContent());
         //   ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(3, definition.getCitation());
            ps.setString(4, definition.getDictionaryCitation());
            ps.setString(5, definition.getWrittenBy().getID());
            ps.setString(6, definition.getCourse().getCourseCode());

            affectRows = ps.executeUpdate();
            // may need to update the definition edit log
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return affectRows;
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int insert(Object object) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "INSERT INTO definition \n"
                + "(glossary_entry,definition, date_created,citation,made_by,course_code,[type])\n"
                + "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement ps = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, definition.getTerm());
            ps.setString(2, definition.getContent());
            ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(4, definition.getCitation());
            ps.setString(5, definition.getWrittenBy().getID());
            ps.setString(6, definition.getDefinitionType() + "");

            affectRows = ps.executeUpdate();
            // may need to update the definition edit log
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return affectRows;
    }
}

