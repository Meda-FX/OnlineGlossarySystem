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

//       private ConnectionPool pool = ConnectionPool.getInstance();
//       private Connection connection = pool.getConnection();
    /**
     * The getByUser method returns a list of definitions related to the user.
     *
     * @param user represents the account in the user table in the database.
     * @return a list of definitions by user.
     */
    public List<Definition> getByUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        DefinitionList dl = new DefinitionList();
        Definition definition;

        String term;
        Course course;
        String courseId;
        String content;
        String citation;
        String definitionID;
        java.util.Date newDate;

        String selectSQL = "SELECT * from [dbo].[definition] where made_by =?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                term = rs.getString(2);
                content = rs.getString(3);
                newDate = rs.getDate(4);
                citation = rs.getString(5);
                courseId = rs.getString(6); // need to get course info
                // definition = new definition(user,)
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * The getById method returns a definition related to the user's ID.
     *
     * @param id represents the course in the course table in the database.
     * @return a definition of a term
     */
    public Definition getByID(String id) {
        return null;
    }

    /**
     * The getByCourse method returns a list of definitions related to the user.
     *
     * @param course represents the course in the course table in the database.
     * @return a list of definitions by course.
     */
    public List<Definition> getByCourse(Course course) {
        return null;
    }

    /**
     * The getByGlossaryEntry returns a list of definitions related to the entry
     * in the glossary.
     *
     * @param glossary represents an entry in the glossary.
     * @return a list of definitions by glossary entry.
     */
    public List<Definition> getByGlossaryEntry(GlossaryEntry glossary) {
        return null;
    }

    @Override
    public int insert(Object object) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "INSERT INTO definition \n" +
                     "(glossary_entry,definition, date_created,citation,made_by,course_code,[type])\n" +
                     "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(sql);
             ps.setString(1, definition.getTerm());
             ps.setString(2, definition.getContent());
             ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
             ps.setString(4, definition.getCitation());
             ps.setString(5, definition.getWrittenBy().getID());
             ps.setString(6,definition.getDefinitionType()+"");
            
          // may need to update the definition edit log
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return 1;
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
