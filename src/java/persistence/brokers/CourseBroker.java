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
 * The CourseBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Course from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class CourseBroker extends Broker{

    /**
     * The getByID method returns the course by the specified course ID.
     *
     * @param courseID represents the ID for a certain course.
     * @return a Course object representing a course from the database.
     */
    public Course getByID(String courseID) {
        return null;
    }

    /**
     * The getByDepartmentID return a list of courses by the specified
     * department ID.
     *
     * @param departmentID represents the ID for a certain department.
     * @return a list of Course objects representing courses from the database.
     */
    public List<Course> getByDepartmentID(int departmentID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[course] "
                + "JOIN [GlossaryDataBase].[dbo].[department] "
                + "ON ([GlossaryDataBase].[dbo].[course].department_id=[GlossaryDataBase].[dbo].[course].department_id) "
                + "WHERE [GlossaryDataBase].[dbo].[course].department_id = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Course> courseList = new ArrayList<>();

       
        //for course list
        String courseCode = null;
        String courseName = null;
        String year = null;
        
       // int department_id=0;
        String deptName=null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, departmentID);
            rs = ps.executeQuery();
            //PrivilegeList privilegeList = null;
            Course course = null;
            Department department = null;
            
            while (rs.next()) {

   

                //DEPARTMENT
                department = new Department();
              
                deptName = rs.getString("name");

                department.setDepartmentID(departmentID);
                department.setName(deptName);
//                //PRIVILEGE
//                Privilege priv = new Privilege();
//                privID = rs.getInt("privilegeID");
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

                //COURSE
               course = new Course();
                courseCode = rs.getString("courseCode");
                courseName = rs.getString("courseName");
               
               // year = rs.getString("year");

                //LISTS
                //privilegeList.add(priv);
                courseList.add(new Course(courseCode, courseName, department));
               
            }

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

        return courseList;

    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = (Course) object;
        //int dept_id = 0;
        
        //String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[course] WHERE [GlossaryDataBase].[dbo].[course].department_id = ?;";
        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[course] (course_code, department_id, course_name) VALUES (?,?,?);";
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, course.getDepartment().getDepartmentID());
            ps.setInt(2, course.getDepartment().getDepartmentID());
            ps.setString(3, course.getCourseName());
            rs = ps.executeQuery();
//            while(rs.next()){
//                dept_id = rs.getInt("department_id");
//            }
            
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = (Course) object;
        
        String selectSQL = "DELETE FROM [GlossaryDataBase].[dbo].[course] WHERE [GlossaryDataBase].[dbo].[course].course_name = ?;";
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseName());
            rs = ps.executeQuery();            
            ps.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(CourseBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
