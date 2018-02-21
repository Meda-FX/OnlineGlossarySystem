package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.CourseList;
import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.Department;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.Privilege;
import business.domainClasses.PrivilegeList;
import business.domainClasses.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 * The UserBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of User from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class UserBroker extends Broker {

    /**
     * The getByEmail method returns the user with the specified email
     *
     * @param email represents the email of an account in the user table of the
     * database.
     * @return a User object with the specified email.
     */
    public User getByEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String sql_user = "SELECT user_id,"
                                + "password,"
                                + "[dbo].[user].department_id,"
                                + "[dbo].[user].name,"
                                + "activated,"
                                + "[dbo].[department].name "
                        + "FROM [dbo].[user] "
                        + "JOIN [dbo].[department] "
                        + "ON ([dbo].[user].department_id = [dbo].[department].department_id) "
                        + "WHERE email =?";
        
        String sql_priv = "SELECT * "
                        + "FROM [dbo].[user_role] "
                        + "JOIN [dbo].[role] "
                        + "ON([dbo].[user_role].priviledge_id = [dbo].[role].priviledge_id) "
                        + "WHERE user_id =?";
        
        String sql_course = "SELECT *"
                            + "FROM [dbo].[user_course]"
                            + "JOIN [dbo].[course]"
                            + "ON [dbo].[user_course].course_code = [dbo].[course].course_code"
                            + "JOIN [dbo].[department]"
                            + "ON ([dbo].[course].department_id = [dbo].[department].department_id)"
                            + "WHERE user_id = ?";
        User user = null;
        Department department = null;        
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        String user_id = null;
        String password = null;
        int department_id;
        String userName = null;
        boolean activated;
        String deptName = null;
        int privID;
        String description;
        String courseCode = null;
        String courseName = null;
        String year = null;

        try {
            ps = connection.prepareStatement(sql_user);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                department = new Department();
                user_id = rs.getString(1);
                password = rs.getString(2);
                department_id = rs.getInt(3);
                userName = rs.getString(4);
                activated=rs.getBoolean(5);
                deptName = rs.getString(6);

                department.setDepartmentID(department_id);
                department.setName(deptName);

                user.setEmail(email);
                user.setID(user_id);
                user.setName(userName);
                user.setPassword(password);
                user.setDepartment(department);
                user.setIsActivated(activated);
            }
            
            PrivilegeList privileges = user.getPrivileges();
            String privilegeDescription = null;
            
            ps = connection.prepareStatement(sql_priv);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                privID = rs.getInt("privilege_id");
                privilegeDescription = rs.getString("description");
                privileges.add(new Privilege(privID, privilegeDescription));
            }
            
            CourseList courses = user.getCourses();
            int courseDepartmentID ;
            String courseDepartmentName;
            Department courseDepartment;
            
            ps = connection.prepareStatement(sql_course);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                courseCode = rs.getString("course_code");
                courseName = rs.getString("course_name");
                courseDepartmentID = rs.getInt("department_id");
                courseDepartmentName = rs.getString("name");
                courseDepartment = new Department(courseDepartmentID, courseDepartmentName);
                courses.add(new Course(courseCode, courseName, courseDepartment));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }

        pool.freeConnection(connection);
        }
        return user;
    }

    /**
     * The getByName method returns the user by their name
     *
     * @param name represents the name of the user
     * @return a User list
     */
    public List<User> getByName(String name) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String searchPattern = ("%" + name + "%").toUpperCase();
        String selectSQL = "SELECT * "
                            + "FROM [GlossaryDataBase].[dbo].[glossary_entry] "
                            + "JOIN [GlossaryDataBase].[dbo].[definition] "
                            + "ON ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) "
                            + "JOIN [GlossaryDataBase].[dbo].[user] "
                            + "ON ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) "
                            + "WHERE UPPER([GlossaryDataBase].[dbo].[user].name) LIKE ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<User> users = new ArrayList<>();
        Department department = null;

        //String compareName = "";
        User user = null;

        String user_id = null;
        String password = null;
        int department_id;
        String userName = null;
        String userEmail = null;
        boolean activated;
        String deptID = null;
        String deptName = null;
        int privID;
        String description;
        String courseCode = null;
        String courseName = null;
        String year = null;

        String compareName = "";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, searchPattern);
            rs = ps.executeQuery();
            PrivilegeList privilegeList = null;
            CourseList courseList = null;

            while (rs.next()) {

                user_id = (rs.getString("user_id"));
                if (!compareName.equals(user_id)) {
                    if (!compareName.equals("")) {
                        users.add(user);
                    }
                    compareName = user_id;
                    user = new User();
                    user.setID(user_id);
                    privilegeList = user.getPrivileges();
                    courseList = user.getCourses();
                }

                //DEPARTMENT
                department = new Department();
                deptID = rs.getString("departmentID");
                deptName = rs.getString("name");

                department.setDepartmentID(deptID);
                department.setName(deptName);

                //PRIVILEGE
                Privilege priv = new Privilege();
                privID = rs.getInt("privilegeID");
                description = rs.getString("description");
                priv.setPrivilegeID(privID);
                priv.setDescription(description);
                privilegeList.add(privID);

                //USER
                password = (rs.getString("password"));
                department_id = (rs.getInt("department_id"));
                name = (rs.getString("name"));
                userEmail = (rs.getString("email"));
                activated = (rs.getInt("activated"));

                user.setID(user_id);
                user.setPassword(password);
                user.setDepartment(department);
                user.setName(name);
                user.setEmail(userEmail);

                //COURSE
                Course course = new Course();
                courseCode = rs.getString("courseCode");
                courseName = rs.getString("courseName");
                year = rs.getString("year");

                //LISTS
                privilegeList.add(privID);
                courseList.add(courseCode);
            }
            users.add(user);

        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return users;
    }

    /**
     * The getByID method returns a user based on their ID.
     *
     * @param ID represents the ID of an account in the user table of the
     * database.
     * @return a User object with a specified users ID.
     */
    public User getByID(String ID) {
        return null;
    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User) object;

        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[user]"
                + " (user_id, password, department_id, name, email, activated)"
                + " VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();

            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ps.setInt(3, '1');
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, '1');
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User)object;
        
        
        String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry]"
                + " join [GlossaryDataBase].[dbo].[definition]"
                + " on ([GlossaryDataBase].[dbo].[definition].glossary_entry"
                + "=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry)"
                + " join [GlossaryDataBase].[dbo].[user]"
                + " on ([GlossaryDataBase].[dbo].[definition].made_by"
                + "=[GlossaryDataBase].[dbo].[user].user_id)"
                + " join [GlossaryDataBase].[dbo].[user_course]"
                + " on [GlossaryDataBase].[dbo].[user].user_id"
                + "=[GlossaryDataBase].[dbo].[user_course].user_id"
                + " where [GlossaryDataBase].[dbo].[user].user_id = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String selectSQL2 = "DELETE FROM [GlossaryDataBase].[dbo].[user_course]"
                + " WHERE user_id = ?;";
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        
        String selectSQL3 = "DELETE FROM [GlossaryDataBase].[dbo].[user]"
                + " WHERE user_id = ?;";
        PreparedStatement ps3 = null;
        ResultSet rs3 = null;
        
        String selectSQL4 = "DELETE FROM [GlossaryDataBase].[dbo].[definition]"
                + " WHERE made_by = ?;";
        PreparedStatement ps4 = null;
        ResultSet rs4 = null;
        
        String selectSQL5 = "DELETE FROM [GlossaryDataBase].[dbo].[glossary_entry]"
                + " WHERE made_by = ?;";
        PreparedStatement ps5 = null;
        ResultSet rs5 = null;
        
        try {            
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            rs = ps.executeQuery();
            
            ps2 = connection.prepareStatement(selectSQL2);
            ps2.setString(1, user.getID());
            rs2 = ps2.executeQuery();
            
            ps3 = connection.prepareStatement(selectSQL3);
            ps3.setString(1, user.getID());
            rs3 = ps3.executeQuery();
            
            ps4 = connection.prepareStatement(selectSQL4);
            ps4.setString(1, user.getID());
            rs4 = ps4.executeQuery();
            
            ps5 = connection.prepareStatement(selectSQL5);
            ps5.setString(1, user.getID());
            rs5 = ps5.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        
        return 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User)object;
        
        String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] join [GlossaryDataBase].[dbo].[definition] on ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) join [GlossaryDataBase].[dbo].[user] on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) join [GlossaryDataBase].[dbo].[user_course] on [GlossaryDataBase].[dbo].[user].user_id=[GlossaryDataBase].[dbo].[user_course].user_id where [GlossaryDataBase].[dbo].[user].user_id = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        String selectSQL2 = "UPDATE [GlossaryDataBase].[dbo].[user] SET user_id = ?, password = ?, department_id = ?, name = ?, email = ?, activated = ? WHERE name = ?;";
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            rs = ps2.executeQuery();
            
            ps2 = connection.prepareStatement(selectSQL2);
            ps2.setString(1, user.getID());
            ps2.setString(2, user.getPassword());
            ps2.setInt(3, '1');
            ps2.setString(4, user.getName());
            ps2.setString(5, user.getEmail());
            ps2.setInt(6, '1');
            ps2.setString(7, rs.getString("user_id"));
            rs2 = ps2.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        
        return 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        List<Object> users = new ArrayList<>();
        
        String user_id = null;
	String password = null;
	int department_id = 0;
	String name = null;
	String userEmail = null;
	int activated = 0;
        String deptID = null;
        String deptName = null;
        int privID;
        String description;
        String courseCode =null;
        String courseName = null;
        String year = null;
        
        Department department = null;
        
        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[user];";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, name);
            rs = ps.executeQuery();
            PrivilegeList privilegeList=null;
            CourseList courseList = null;
            privilegeList = user.getPrivileges();
            courseList = user.getCourses();
            while (rs.next()) {
                //DEPARTMENT
                department = new Department();
                deptID = rs.getString("departmentID");
                deptName = rs.getString("name");
                
                department.setDepartmentID(deptID);
                department.setName(deptName);
                
                //PRIVILEGE
                Privilege priv = new Privilege();
                privID = rs.getInt("privilegeID");
                description = rs.getString("description");
                priv.setPrivilegeID(privID);
                priv.setDescription(description);
                privilegeList.add(privID);
                
                //USER
                password = (rs.getString("password"));
                department_id = (rs.getInt("department_id"));
                name = (rs.getString("name"));
                userEmail = (rs.getString("email"));
                activated = (rs.getInt("activated"));
                
                user.setID(user_id);
                user.setPassword(password);
                user.setDepartment(department);
                user.setName(name);
                user.setEmail(userEmail);
                
                //COURSE
                Course course = new Course();
                courseCode = rs.getString("courseCode");
                courseName = rs.getString("courseName");
                year = rs.getString("year");
                
                //LISTS
                privilegeList.add(privID);
                courseList.add(courseCode);
                
                users.add(user);
            }
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
