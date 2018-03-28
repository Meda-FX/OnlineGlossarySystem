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
                + "[GlossaryDataBase].[dbo].[user].department_id,"
                + "[GlossaryDataBase].[dbo].[user].name,"
                + "activated,"
                + "[GlossaryDataBase].[dbo].[department].name "
                + "FROM [GlossaryDataBase].[dbo].[user] "
                + "JOIN [GlossaryDataBase].[dbo].[department] "
                + "ON ([GlossaryDataBase].[dbo].[user].department_id = [GlossaryDataBase].[dbo].[department].department_id) "
                + "WHERE email =?";

        String sql_priv = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user_role] "
                + "JOIN [GlossaryDataBase].[dbo].[role] "
                + "ON([GlossaryDataBase].[dbo].[user_role].privilege_id = [GlossaryDataBase].[dbo].[role].privilege_id) "
                + "WHERE user_id =?";

        String sql_course = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user_course] "
                + "JOIN [GlossaryDataBase].[dbo].[course] "
                + "ON ([GlossaryDataBase].[dbo].[user_course].course_code = [GlossaryDataBase].[dbo].[course].course_code) "
                + "JOIN [GlossaryDataBase].[dbo].[department] "
                + "ON ([GlossaryDataBase].[dbo].[course].department_id = [GlossaryDataBase].[dbo].[department].department_id) "
                + "WHERE user_id = ?";
        User user = null;
        Department department = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        PreparedStatement ps3 = null;
        ResultSet rs3 = null;

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
            user = new User();
            while (rs.next()) {

                department = new Department();
                user_id = rs.getString(1);
                password = rs.getString(2);
                department_id = rs.getInt(3);
                userName = rs.getString(4);
                activated = rs.getBoolean(5);
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
            
            if (user.getID()==null)
                return null;
            
            PrivilegeList privileges = user.getPrivileges();
            String privilegeDescription = null;

            ps2 = connection.prepareStatement(sql_priv);
            ps2.setString(1, user_id);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                privID = rs2.getInt("privilege_id");
                privilegeDescription = rs2.getString("description");
                privileges.add(new Privilege(privID, privilegeDescription));
            }

            CourseList courses = user.getCourses();
            int courseDepartmentID;
            String courseDepartmentName;
            Department courseDepartment;

            ps3 = connection.prepareStatement(sql_course);
            ps3.setString(1, user_id);
            rs3 = ps3.executeQuery();

            while (rs3.next()) {
                courseCode = rs3.getString("course_code");
                courseName = rs3.getString("course_name");
                courseDepartmentID = rs3.getInt("department_id");
                courseDepartmentName = rs3.getString("name");
                courseDepartment = new Department(courseDepartmentID, courseDepartmentName);
                courses.add(new Course(courseCode, courseName, courseDepartment));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }

                if (rs2 != null) {
                    rs2.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }

                if (rs3 != null) {
                    rs3.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }

            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
    }

    /**
     * The getByName method returns the user by their name
     *
     * @param department represents the department of the user
     * @return a User list
     */
    public List<User> getByDepartment(Department department) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
//        String selectSQL = "SELECT * "
//                + "FROM [GlossaryDataBase].[dbo].[user] "
//                + "JOIN [GlossaryDataBase].[dbo].[user_role] "
//                + "ON ([GlossaryDataBase].[dbo].[user].user_id=[GlossaryDataBase].[dbo].[user_role].user_id) "
//                + "JOIN [GlossaryDataBase].[dbo].[role] "
//                + "ON ([GlossaryDataBase].[dbo].[role].privilege_id=[GlossaryDataBase].[dbo].[user_role].privilege_id) "
//                + "WHERE [GlossaryDataBase].[dbo].[user].department_id = ?;";

        String sql_user = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user] "
                + "WHERE department_id = ?;";

        String sql_priv = "SELECT [GlossaryDataBase].[dbo].[user_role].privilege_id privilege_id1, [GlossaryDataBase].[dbo].[user_role].description description"
                + "FROM [GlossaryDataBase].[dbo].[user_role] "
                + "JOIN [GlossaryDataBase].[dbo].[role] "
                + "ON([GlossaryDataBase].[dbo].[user_role].privilege_id = [GlossaryDataBase].[dbo].[role].privilege_id) "
                + "WHERE user_id =?;";

        String sql_course = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user_course] "
                + "JOIN [GlossaryDataBase].[dbo].[course] "
                + "ON ([GlossaryDataBase].[dbo].[user_course].course_code = [GlossaryDataBase].[dbo].[course].course_code) "
                + "WHERE user_id = ? ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        PreparedStatement ps1 = null;
        ResultSet rs1 = null;

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        ArrayList<User> users = new ArrayList<>();

        User user = null;

        String user_id = null;
        String password = null;
        String userName = null;
        String userEmail = null;
        // int department_id = 0;
        boolean activated;

        //for privilege list
        int privID;
        String description;
        //for course list
        String courseCode = null;
        String courseName = null;
        String year = null;

        try {
            ps = connection.prepareStatement(sql_user);
            ps.setInt(1, department.getDepartmentID());
            rs = ps.executeQuery();
            PrivilegeList privilegeList = null;
            CourseList courseList = null;
            user_id = null;

            while (rs.next()) {
                //USER
                user = new User();
                user_id = rs.getString("user_id");
                userName = rs.getString("name");
                userEmail = rs.getString("email");
                activated = rs.getBoolean("activated");
                user.setID(user_id);
                user.setDepartment(department);
                user.setName(userName);
                user.setEmail(userEmail);
//                privilegeList = user.getPrivileges();
//                courseList = user.getCourses();
//                //PRIVILEGE
//                Privilege priv = new Privilege();
//                privID = rs.getInt("privilege_id");
//                description = rs.getString("description");
//                priv.setPrivilegeID(privID);
//                priv.setDescription(description);
//                privilegeList.add(new Privilege(privID, description));
//
//                //USER
//                password = (rs.getString("password"));
//                department_id = (rs.getInt("department_id"));
//                userName = (rs.getString("name"));
//                userEmail = (rs.getString("email"));
//                activated = (rs.getBoolean("activated"));
//
//                //user.setID(user_id);
//                user.setPassword(password);
//                user.setDepartment(department);
//                user.setName(userName);
//                user.setEmail(userEmail);

//                //COURSE
//                Course course = new Course();
//                courseCode = rs.getString("course_code");
//                courseName = rs.getString("course_name");
//             //   year = rs.getString("year");
//
//                //LISTS
//                //privilegeList.add(priv);
//                courseList.add(new Course(courseCode, courseName, department));
                users.add(user);
            }
            for (User u : users) {
                ps1 = connection.prepareStatement(sql_priv);
                ps1.setString(1, u.getID());
                rs1 = ps.executeQuery();
                privilegeList = u.getPrivileges();
                while (rs1.next()) {
                    //PRIVILEGE
                    Privilege priv = new Privilege();
                    privID = rs1.getInt("privilege_id1");
                    description = rs1.getString("description");
                   // priv.setPrivilegeID(privID);
                    priv.setDescription(description);
                    privilegeList.add(priv);
                }
                if (rs1 != null) {
                    rs1.close();
                }
                if (ps1 != null) {
                    ps1.close();
                }
            }
            for (User u : users) {
                ps2 = connection.prepareStatement(sql_course);
                ps2.setString(1, u.getID());
                rs2 = ps.executeQuery();
                courseList = u.getCourses();
                while (rs2.next()) {
                    //COURSE
                    Course course = new Course();
                    courseCode = rs2.getString("course_code");
                    courseName = rs2.getString("course_name");
                    course.setCourseCode(courseCode);
                    course.setCourseName(courseName);
                    courseList.add(course);
                }
                if (rs2 != null) {
                    rs2.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return users;
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
        int deptID = 0;
        String deptName = null;
        int privID;
        String description;
        String courseCode = null;
        String courseName = null;
        String year = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, searchPattern);
            rs = ps.executeQuery();
            PrivilegeList privilegeList = null;
            CourseList courseList = null;

            while (rs.next()) {

                user_id = (rs.getString(1));
                user = new User();
                user.setID(user_id);
                privilegeList = user.getPrivileges();
                courseList = user.getCourses();

                //DEPARTMENT
                department = new Department();
                deptID = rs.getInt("departmentID");
                deptName = rs.getString("name");

                department.setDepartmentID(deptID);
                department.setName(deptName);

                //PRIVILEGE
                Privilege priv = new Privilege();
                privID = rs.getInt("privilegeID");
                description = rs.getString("description");
                priv.setPrivilegeID(privID);
                priv.setDescription(description);
                privilegeList.add(new Privilege(privID, description));

                //USER
                password = (rs.getString("password"));
                department_id = (rs.getInt("department_id"));
                name = (rs.getString("name"));
                userEmail = (rs.getString("email"));
                activated = (rs.getBoolean("activated"));

                //user.setID(user_id);
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
                //privilegeList.add(priv);
                courseList.add(new Course(courseCode, courseName, department));
                users.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String sql_user = "SELECT email,"
                + "password,"
                + "[GlossaryDataBase].[dbo].[user].department_id,"
                + "[GlossaryDataBase].[dbo].[user].name,"
                + "activated,"
                + "[GlossaryDataBase].[dbo].[department].name "
                + "FROM [GlossaryDataBase].[dbo].[user] "
                + "JOIN [GlossaryDataBase].[dbo].[department] "
                + "ON ([GlossaryDataBase].[dbo].[user].department_id = [GlossaryDataBase].[dbo].[department].department_id) "
                + "WHERE user_id =?";

        String sql_priv = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user_role] "
                + "JOIN [GlossaryDataBase].[dbo].[role] "
                + "ON([GlossaryDataBase].[dbo].[user_role].privilege_id = [GlossaryDataBase].[dbo].[role].privilege_id) "
                + "WHERE user_id =?";

        String sql_course = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user_course] "
                + "JOIN [GlossaryDataBase].[dbo].[course] "
                + "ON ([GlossaryDataBase].[dbo].[user_course].course_code = [GlossaryDataBase].[dbo].[course].course_code) "
                + "JOIN [GlossaryDataBase].[dbo].[department] "
                + "ON ([GlossaryDataBase].[dbo].[course].department_id = [GlossaryDataBase].[dbo].[department].department_id) "
                + "WHERE user_id = ?";
        User user = null;
        Department department = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        PreparedStatement ps3 = null;
        ResultSet rs3 = null;

        String email = null;
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
            ps.setString(1, ID);
            rs = ps.executeQuery();
            user = new User();
            while (rs.next()) {

                department = new Department();
                email = rs.getString(1);
                password = rs.getString(2);
                department_id = rs.getInt(3);
                userName = rs.getString(4);
                activated = rs.getBoolean(5);
                deptName = rs.getString(6);

                department.setDepartmentID(department_id);
                department.setName(deptName);

                user.setEmail(email);
                user.setID(ID);
                user.setName(userName);
                user.setPassword(password);
                user.setDepartment(department);
                user.setIsActivated(activated);
            }
            
            if (user.getID()==null)
                return null;
            
            PrivilegeList privileges = user.getPrivileges();
            String privilegeDescription = null;

            ps2 = connection.prepareStatement(sql_priv);
            ps2.setString(1, ID);
            rs2 = ps2.executeQuery();

            while (rs2.next()) {
                privID = rs2.getInt("privilege_id");
                privilegeDescription = rs2.getString("description");
                privileges.add(new Privilege(privID, privilegeDescription));
            }

            CourseList courses = user.getCourses();
            int courseDepartmentID;
            String courseDepartmentName;
            Department courseDepartment;

            ps3 = connection.prepareStatement(sql_course);
            ps3.setString(1, ID);
            rs3 = ps3.executeQuery();

            while (rs3.next()) {
                courseCode = rs3.getString("course_code");
                courseName = rs3.getString("course_name");
                courseDepartmentID = rs3.getInt("department_id");
                courseDepartmentName = rs3.getString("name");
                courseDepartment = new Department(courseDepartmentID, courseDepartmentName);
                courses.add(new Course(courseCode, courseName, courseDepartment));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }

                if (rs2 != null) {
                    rs2.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }

                if (rs3 != null) {
                    rs3.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }

            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return user;
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

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getDepartment().getDepartmentID());
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getIsActivated()? 1:0);
            ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                //rs.close();
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
        User user = (User) object;

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
        //ResultSet rs = null;

        String selectSQL2 = "DELETE FROM [GlossaryDataBase].[dbo].[user_course]"
                + " WHERE user_id = ?;";
        PreparedStatement ps2 = null;
        //ResultSet rs2 = null;

        String selectSQL3 = "DELETE FROM [GlossaryDataBase].[dbo].[user]"
                + " WHERE user_id = ?;";
        PreparedStatement ps3 = null;
        //ResultSet rs3 = null;

        String selectSQL4 = "DELETE FROM [GlossaryDataBase].[dbo].[definition]"
                + " WHERE made_by = ?;";
        PreparedStatement ps4 = null;
        //ResultSet rs4 = null;

        String selectSQL5 = "DELETE FROM [GlossaryDataBase].[dbo].[glossary_entry]"
                + " WHERE made_by = ?;";
        PreparedStatement ps5 = null;
        //ResultSet rs5 = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            //rs = ps.executeQuery();
            ps.executeUpdate();

            ps2 = connection.prepareStatement(selectSQL2);
            ps2.setString(1, user.getID());
            //rs2 = ps2.executeQuery();
            ps2.executeUpdate();

            ps3 = connection.prepareStatement(selectSQL3);
            ps3.setString(1, user.getID());
            //rs3 = ps3.executeQuery();
            ps3.executeUpdate();

            ps4 = connection.prepareStatement(selectSQL4);
            ps4.setString(1, user.getID());
            //rs4 = ps4.executeQuery();
            ps4.executeUpdate();

            ps5 = connection.prepareStatement(selectSQL5);
            ps5.setString(1, user.getID());
            //rs5 = ps5.executeQuery();
            ps5.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                //rs.close();
                ps.close();
                ps2.close();
                ps3.close();
                ps4.close();
                ps5.close();
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
        User user = (User) object;

        String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] join [GlossaryDataBase].[dbo].[definition] on ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) join [GlossaryDataBase].[dbo].[user] on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) join [GlossaryDataBase].[dbo].[user_course] on [GlossaryDataBase].[dbo].[user].user_id=[GlossaryDataBase].[dbo].[user_course].user_id where [GlossaryDataBase].[dbo].[user].user_id = ?;";
        PreparedStatement ps = null;
        //ResultSet rs = null;

        String selectSQL2 = "UPDATE [GlossaryDataBase].[dbo].[user] SET user_id = ?, password = ?, department_id = ?, name = ?, email = ?, activated = ? WHERE name = ?;";
        PreparedStatement ps2 = null;
        //ResultSet rs2 = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            ps.executeUpdate();

            ps2 = connection.prepareStatement(selectSQL2);
            ps2.setString(1, user.getID());
            ps2.setString(2, user.getPassword());
            ps2.setInt(3, '1');
            ps2.setString(4, user.getName());
            ps2.setString(5, user.getEmail());
            ps2.setInt(6, '1');
            ps2.setString(7, user.getID());
            ps2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                //rs.close();
                ps.close();
                ps2.close();
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
        boolean activated;
        int deptID = 0;
        String deptName = null;
        int privID;
        String description;
        String courseCode = null;
        String courseName = null;
        String year = null;

        Department department = null;

        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[user];";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            PrivilegeList privilegeList = null;
            CourseList courseList = null;
            privilegeList = user.getPrivileges();
            courseList = user.getCourses();
            while (rs.next()) {
                //DEPARTMENT
                department = new Department();
                deptID = rs.getInt("departmentID");
                deptName = rs.getString("name");

                department.setDepartmentID(deptID);
                department.setName(deptName);

                //PRIVILEGE
                Privilege priv = new Privilege();
                privID = rs.getInt("privilegeID");
                description = rs.getString("description");
                priv.setPrivilegeID(privID);
                priv.setDescription(description);
                privilegeList.add(new Privilege(privID, description));

                //USER
                password = (rs.getString("password"));
                department_id = (rs.getInt("department_id"));
                name = (rs.getString("name"));
                userEmail = (rs.getString("email"));
                activated = (rs.getBoolean("activated"));

                user.setID(user_id);
                user.setPassword(password);
                user.setDepartment(department);
                user.setName(name);
                user.setEmail(userEmail);
                user.setIsActivated(activated);

                //COURSE
                Course course = new Course();
                courseCode = rs.getString("courseCode");
                courseName = rs.getString("courseName");
                year = rs.getString("year");

                //LISTS
                //privilegeList.add(privID);
                courseList.add(new Course(courseCode, courseName, department));

                users.add(user);
            }

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return users;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
