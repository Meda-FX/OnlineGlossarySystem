package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.CourseList;
import business.domainClasses.Department;
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
                + "WHERE email =? and activated = 1";

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

            if (user.getID() == null) {
                return null;
            }

            PrivilegeList privileges = user.getPrivileges();
            String privilegeDescription = null;

            ps2 = connection.prepareStatement(sql_priv);
            ps2.setString(1, user.getID());
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

        String sql_user = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[user] "
                + "WHERE department_id = ?;";

        String sql_priv = "SELECT * "
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
                user.setIsActivated(activated);
                users.add(user);
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            for (User u : users) {
                ps1 = connection.prepareStatement(sql_priv);
                ps1.setString(1, u.getID());
                rs1 = ps1.executeQuery();
                privilegeList = u.getPrivileges();
                while (rs1.next()) {
                    //PRIVILEGE
                    Privilege priv = new Privilege();
                    privID = rs1.getInt("privilege_id");
                    description = rs1.getString("description");
                    priv.setPrivilegeID(privID);
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
                rs2 = ps2.executeQuery();
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

                //LISTS
                //privilegeList.add(priv);
                courseList.add(new Course(courseCode, courseName, department));
                users.add(user);
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

            if (user.getID() == null) {
                return null;
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
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

            if (rs2 != null) {
                rs2.close();
            }
            if (ps2 != null) {
                ps2.close();
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

            if (rs3 != null) {
                rs3.close();
            }
            if (ps3 != null) {
                ps3.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            pool.freeConnection(connection);
        }
        return user;
    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User) object;

        String userSQL = "INSERT INTO [GlossaryDataBase].[dbo].[user]"
                + " (user_id, password, department_id, name, email, activated)"
                + " VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = null;

        String userRoleSQL = "INSERT INTO [GlossaryDataBase].[dbo].[user_role] "
                + "VALUES (?, ?);";
        PreparedStatement ps2 = null;

        try {
            ps = connection.prepareStatement(userSQL);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getDepartment().getDepartmentID());
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getIsActivated() ? 1 : 0);
            ps.executeUpdate();

            for (Privilege privilege : user.getPrivileges().getPrivileges()) {
                ps2 = connection.prepareStatement(userRoleSQL);
                ps2.setInt(1, privilege.getPrivilegeID());
                ps2.setString(2, user.getID());
                ps2.executeUpdate();
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                //rs.close();
                if (ps != null) {
                    ps.close();
                }

                if (ps2 != null) {
                    ps2.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return 0;
    }

    @Override
    public int delete(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User) object;

        String selectSQL = "DELETE FROM [GlossaryDataBase].[dbo].[user]"
                + " WHERE user_id = ?;";
        PreparedStatement ps = null;

        try {

            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {

                if (ps != null) {
                    ps.close();
                }

            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return 1;
    }

    @Override
    public int update(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User) object;

        String selectSQL = "UPDATE [GlossaryDataBase].[dbo].[user] "
                + "SET user_id = ?, password = ?, department_id = ?, name = ?, email = ?, activated = ? "
                + "WHERE user_id = ?;";
        PreparedStatement ps = null;
        //ResultSet rs2 = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getDepartment().getDepartmentID());
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getIsActivated() ? 1 : 0);
            ps.setString(7, user.getID());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return 1;
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
 * reloadCourses method used to update courses selected by a user to user_course table
 * 
 * @param user a user that update his/her course list
 * @return an integer 1 means update successfully, return 0 if any errors occur
 */
    public int reloadCourses(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        ArrayList<Course> courses = (ArrayList<Course>) user.getCourses().getCourses();

        String sql_d = "DELETE FROM [GlossaryDataBase].[dbo].[user_course] WHERE [user_id] = ?;";
        String sql_i = "INSERT INTO [GlossaryDataBase].[dbo].[user_course] (course_code,user_id) VALUES (?,?)";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql_d);
            ps.setString(1, user.getID());
            ps.executeUpdate();
            if (ps != null) {
                ps.close();
            }
            for (Course c : courses) {
                ps = connection.prepareStatement(sql_i);
                ps.setString(1, c.getCourseCode());
                ps.setString(2, user.getID());
                //  ps.setDate(3, x);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return 1;
    }
/**
 * reloadCourses method used to update priviliges/roles assigned for a user by admin to user_role table
 * 
 * @param user a user needs to update his/her privilege list
 * @return an integer 1 means update successfully, return 0 if any errors occur
 */
    public int reloadPrivileges(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        ArrayList<Privilege> privileges = (ArrayList<Privilege>) user.getPrivileges().getPrivileges();

        String sql_d = "DELETE FROM [GlossaryDataBase].[dbo].[user_role] WHERE [user_id] = ?;";
        String sql_i = "INSERT INTO [GlossaryDataBase].[dbo].[user_role] (privilege_id,user_id) VALUES (?,?)";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql_d);
            ps.setString(1, user.getID());
            ps.executeUpdate();

            for (Privilege p : privileges) {
                ps = connection.prepareStatement(sql_i);
                ps.setInt(1, p.getPrivilegeID());
                ps.setString(2, user.getID());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return 1;
    }
}
