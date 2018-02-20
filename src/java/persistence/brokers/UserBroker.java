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
        //String sql_priv = "SELECT * FROM [dbo].[user_role] JOIN [dbo].[role] ON([dbo].[user_role].priviledge_id = [dbo].[role].priviledge_id) WHERE user_id =?";
        User user = null;
        Department department = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String user_id = null;
        String password = null;
        int department_id = 0;
        String userName = null;
        int activated = 0;
        String deptID = null;
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
                // activated=rs.getInt(5);
                deptName = rs.getString(6);

                department.setDepartmentID(deptID);
                department.setName(deptName);

                user.setEmail(email);
                user.setID(user_id);
                user.setName(userName);
                user.setPassword(password);
                user.setDepartment(department);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            if (user != null) {
                try {
                    ps = connection.prepareStatement(sql_priv);
                    ps.setString(1, user.getID());
                    rs = ps.executeQuery();
                    PrivilegeList pl = new PrivilegeList();
                     while (rs.next()) {
                         //set privlige list to a user 
                         // figure this out
                         pl.add(privID);
                     }
                } catch (SQLException ex) {
                    Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        pool.freeConnection(connection);

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

        String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] join [GlossaryDataBase].[dbo].[definition] on ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) join [GlossaryDataBase].[dbo].[user] on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) where [GlossaryDataBase].[dbo].[user].name = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<User> users = new ArrayList<>();
        Department department = null;

        //String compareName = "";
        User user = null;

        String user_id = null;
        String password = null;
        int department_id = 0;
        String userName = null;
        String userEmail = null;
        int activated = 0;
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
            ps.setString(1, name);
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

        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[user] (user_id, password, department_id, name, email, activated) VALUES (?,?,?,?,?,?);";
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
