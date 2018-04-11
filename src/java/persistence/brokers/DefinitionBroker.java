package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.Department;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
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
     * @param did represents the definition_id column in the course table in the database.
     * @return a definition of a term
     */
    public Definition getByID(int did) {
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
        String dictionaryContent;
        String dictionaryCitation;
        String status;
        java.util.Date newDate;

        String selectSQL = "SELECT * "
                + "from [GlossaryDatabase].[dbo].[definition] "
                //+ "join [GlossaryDatabase].[dbo].[course] "
                //+ "on (definition.course_code=course.course_code) "
                //+ "join [GlossaryDatabase].[dbo].[user] "
                //+ "on (definition.made_by=[dbo].[user].[user_id]) "
                + "where definition_uid = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, did);
            rs = ps.executeQuery();
            while (rs.next()) {
                definition = new Definition();
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                status = rs.getString("status");
                userid = rs.getString("made_by");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                user = new User();
                user.setID(userid);
                courseId = rs.getString("course_code"); // need to get course info
                //course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                //course.setCourseName(course_name);
                // definition = new definition(user,)
                definition = new Definition(did, user, newDate, citation, dictionaryCitation,
                        course, content, dictionaryContent, term, status);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
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
        //need to rewrite
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Definition> delist = new ArrayList<>();

        Definition definition = null;
        //  Course course;
        User user;

        String term;
        String name;
        String userid;

        String content;
        String citation;
        int definitionID;
        String status;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[definition] "
                + "join [GlossaryDataBase].[dbo].[user] "
                + "on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) "
                + "where [GlossaryDataBase].[dbo].[definition].course_code = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseCode());
            rs = ps.executeQuery();
            while (rs.next()) {
                definitionID = rs.getInt("definition_uid");
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                status = rs.getString("status");

                name = rs.getString("name");
                userid = rs.getString("user_id");
                user = new User();
                user.setID(userid);
                user.setName(name);

                // definition = new definition(user,)
                definition = new Definition(definitionID, user, newDate, citation,
                        dictionaryCitation, course, content,
                        dictionaryContent, term, status);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return delist;
    }

    /**
     * The getByCourse method returns a list of definitions related to the user.
     *
     * @param department a department object with the department ID
     * @return a list of definitions by course.
     */
    public List<Definition> getByDepartment(Department department) {
        //need to rewrite
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Definition> delist = new ArrayList<>();

        Definition definition = null;
        //  Course course;
        User user = null;
        Course course = null;

        String term;
        String name;
        String userid;

        String course_code;
        String course_name;

        String content;
        String citation;
        int definitionID;
        String status;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[definition] "
                + "join [GlossaryDataBase].[dbo].[user] "
                + "on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) "
                + "join [GlossaryDataBase].[dbo].[course] "
                + "on ([GlossaryDataBase].[dbo].[course].course_code=[GlossaryDataBase].[dbo].[definition].course_code) "
                + "join [GlossaryDataBase].[dbo].[department] "
                + "on ([GlossaryDataBase].[dbo].[department].department_id=[GlossaryDataBase].[dbo].[course].department_id) "
                + "where [GlossaryDataBase].[dbo].[department].department_id = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, department.getDepartmentID());
            rs = ps.executeQuery();
            while (rs.next()) {
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                definitionID = rs.getInt("definition_uid");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                status = rs.getString("status");

                name = rs.getString("name");
                userid = rs.getString("user_id");
                user = new User();
                user.setID(userid);
                user.setName(name);

                course = new Course();
                course_code = rs.getString("course_code");
                course_name = rs.getString("course_name");
                course.setCourseCode(course_code);
                course.setCourseName(course_name);

                // definition = new definition(user,)
                definition = new Definition(definitionID, user, newDate, citation,
                        dictionaryCitation, course, content,
                        dictionaryContent, term, status);
                definition.setDefinitionID(definitionID);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return delist;
    }

    /**
     * The getByUser method returns a list of definitions related to the user.
     *As well as the courses coralated within the 
     * @param user represents the account in the user table in the database.
     * @return a list of definitions by user.
     */
    public List<Definition> getByUserAndCourse(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CourseService cs = new CourseService();
        ArrayList<Definition> delist = new ArrayList<>();
        Definition definition;

        String term;
        Course course;
        String courseId;
        String content;
        String citation;
        int definitionID;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;
        String status;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[definition] "
                + "where made_by=? "
                + "ORDER BY date_created DESC";

        PreparedStatement ps = null;
        ResultSet rs = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1,user.getID());
            rs = ps.executeQuery();
            while (rs.next()) {
                definitionID = rs.getInt("definition_uid");
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                status = rs.getString("status");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                courseId = rs.getString("course_code"); // need to get course info
                course = new Course(courseId);
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                // definition = new definition(user,)
                definition = new Definition(definitionID, user, newDate, citation,
                        dictionaryCitation, course, content,
                        dictionaryContent, term, status);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
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
                + "where glossary_entry = ? ";
        Definition definition;
        Course course;
        User user;
        int definitionUid;
        String glossaryEntry;
        String content;
        Date dateCreated;
        String citation;
        String madeBy;
        String courseId;
        String status;
        String dictionaryContent;
        String dictionaryCitation;
        String name;
        String course_name;
        try {
            ps = connection.prepareCall(selectSQL);
            ps.setString(1, glossary.getTerm());
            rs = ps.executeQuery();
            while (rs.next()) {
                definitionUid = rs.getInt("definition_uid");
                glossaryEntry = rs.getString("glossary_entry");
                content = rs.getString("definition");
                dateCreated = new Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                madeBy = rs.getString("made_by");
                courseId = rs.getString("course_id");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                status = rs.getString("status");
                name = rs.getString("name");
                user = new User();
                user.setID(madeBy);
                user.setName(name);
                courseId = rs.getString("course_code"); // need to get course info
                course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                course.setCourseName(course_name);
                definition = new Definition(definitionUid, user, dateCreated, citation, dictionaryCitation,
                        course, content, dictionaryContent, glossary.getTerm(), status);
                list.add(definition);
            }
        } catch (SQLException e) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", e);

        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }

        return list;
    }

    @Override
    public int delete(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "DELETE [GlossaryDataBase].[dbo].[definition] WHERE definition_uid = ?";

        PreparedStatement ps = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, definition.getDefinitionID());

            affectRows = ps.executeUpdate();
            // may need to update the definition edit log

            if (affectRows > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to delete definition", ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {

            }
            pool.freeConnection(connection);
        }

        return 0;
    }

    @Override
    public int update(Object object) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "UPDATE [GlossaryDataBase].[dbo].[definition] "
                + "SET definition=?,dictionary_definition=?,"
                + "citation=?,dictionary_citation=?,status=? "
                + "WHERE definition_uid=? ";

        PreparedStatement ps = null;

        int affectRows = 0;

        try {
            ps = connection.prepareStatement(sql);
            //ps.setString(1, definition.getTerm());
            ps.setString(1, definition.getContent());
            ps.setString(2, definition.getDictionaryContent());
            //   ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(3, definition.getCitation());
            ps.setString(4, definition.getDictionaryCitation());
            ps.setString(5, definition.getStatus());
            ps.setInt(6, definition.getDefinitionID());

            affectRows = ps.executeUpdate();
            // may need to update the definition edit log
            if (affectRows > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to update definition", ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            pool.freeConnection(connection);
        }

        return 0;
    }

    @Override
    public List<Object> getAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Object> delist = new ArrayList<Object>();
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
        int definitionID;
        String dictionaryContent;
        String status;
        String dictionaryCitation;
        java.util.Date newDate;

        String selectSQL = "SELECT * "
                + "from [dbo].[definition] ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                definition = new Definition();
                definitionID = rs.getInt("definition_uid");
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                name = rs.getString("name");
                userid = rs.getString("user_id");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                status = rs.getString("status");
                user = new User();
                user.setID(userid);
                user.setName(name);
                courseId = rs.getString("course_code"); // need to get course info
                course_name = rs.getString("course_name");
                course = new Course();
                course.setCourseCode(courseId);
                course.setCourseName(course_name);
                definition = new Definition(definitionID, user, newDate, citation, dictionaryCitation,
                        course, content, dictionaryContent, term, status);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return delist;
    }

    @Override
    public int insert(Object object) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        Definition definition = (Definition) object;
        String sql = "INSERT INTO [GlossaryDataBase].[dbo].[definition] "
                + "(glossary_entry,definition, dictionary_definition, date_created,"
                + "citation, status,dictionary_citation,made_by, course_code) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = null;

        int affectRows = 0;
        Timestamp date = new Timestamp(new java.util.Date().getTime());

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, definition.getTerm());
            ps.setString(2, definition.getContent());
            ps.setString(3, definition.getDictionaryContent());
            ps.setTimestamp(4,date);
            ps.setString(5, definition.getCitation());
            ps.setString(6, definition.getStatus());
            ps.setString(7, definition.getDictionaryCitation());
            ps.setString(8, definition.getWrittenBy().getID());
            ps.setString(9, definition.getCourse().getCourseCode());
            

            affectRows = ps.executeUpdate();
            // may need to update the definition edit log
            if (affectRows > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to insert definition", ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {

            }
            pool.freeConnection(connection);
        }

        return 0;
    }

    public List<Definition> getByDepartmentFilterByTCU(Department department, String txtSearch, String courseCode, String userId) {
        //need to rewrite
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ArrayList<Definition> delist = new ArrayList<>();

        Definition definition = null;
        //  Course course;
        User user = null;
        Course course = null;

        String term;
        String name;
        String userid;

        String course_code;
        String course_name;

        String content;
        String citation;
        int definitionID;
        String status;
        java.util.Date newDate;
        String dictionaryContent;
        String dictionaryCitation;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[definition] "
                + "join [GlossaryDataBase].[dbo].[user] "
                + "on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) "
                + "join [GlossaryDataBase].[dbo].[course] "
                + "on ([GlossaryDataBase].[dbo].[course].course_code=[GlossaryDataBase].[dbo].[definition].course_code) "
                + "join [GlossaryDataBase].[dbo].[department] "
                + "on ([GlossaryDataBase].[dbo].[department].department_id=[GlossaryDataBase].[dbo].[course].department_id) "
                + "where [GlossaryDataBase].[dbo].[department].department_id = ? "
                + "AND [GlossaryDataBase].[dbo].[definition].glossary_entry LIKE ? "
                + "AND [GlossaryDataBase].[dbo].[course].course_code LIKE ? "
                + "AND [GlossaryDataBase].[dbo].[user].user_id LIKE ?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        if(courseCode.equals("")) courseCode="%";
        if(userId.equals("")) userId="%";
        txtSearch = "%"+txtSearch+"%";
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, department.getDepartmentID());
            ps.setString(2, txtSearch);
            ps.setString(3, courseCode);
            ps.setString(4, userId);
         //  if(courseCode != null && courseCode.equals("")) 
            rs = ps.executeQuery();
            while (rs.next()) {
                term = rs.getString("glossary_entry");
                content = rs.getString("definition");
                newDate = new java.util.Date(rs.getTimestamp("date_created").getTime());
                citation = rs.getString("citation");
                definitionID = rs.getInt("definition_uid");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                status = rs.getString("status");

                name = rs.getString("name");
                userid = rs.getString("user_id");
                user = new User();
                user.setID(userid);
                user.setName(name);

                course = new Course();
                course_code = rs.getString("course_code");
                course_name = rs.getString("course_name");
                course.setCourseCode(course_code);
                course.setCourseName(course_name);

                // definition = new definition(user,)
                definition = new Definition(definitionID, user, newDate, citation,
                        dictionaryCitation, course, content,
                        dictionaryContent, term, status);
                definition.setDefinitionID(definitionID);
                delist.add(definition);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return delist;
    }
}
