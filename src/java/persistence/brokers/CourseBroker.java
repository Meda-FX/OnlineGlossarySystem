package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.User;
import business.serviceClasses.DepartmentService;
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
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class CourseBroker extends Broker {

    /**
     * The getByID method returns the course by the specified course ID.
     *
     * @param courseCode represents the ID for a certain course.
     * @return a Course object representing a course from the database.
     */
    public Course getByCourseCode(String courseCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[course] "
                + "WHERE [GlossaryDataBase].[dbo].[course].course_code=?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        //for course list
        int department;
        String courseName = null;

        Course course = null;

        try {

            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, courseCode);
            rs = ps.executeQuery();
            while (rs.next()) {

                courseName = rs.getString("course_name");
                department = rs.getInt("department_id");
                course = new Course(courseCode, courseName, new Department(department));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
               if(rs != null) rs.close();
               if(ps != null) ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return course;

    }

    /**
     * The getByDepartmentID return a list of courses by the specified
     * department ID.
     *
     * @param department represents the ID for a certain department.
     * @return a list of Course objects representing courses from the database.
     */
    public List<Course> getByDepartmentID(Department department) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[course] "
                + "WHERE [GlossaryDataBase].[dbo].[course].department_id = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Course> courseList = new ArrayList<>();

        //for course list
        String courseCode = null;
        String courseName = null;

        int departmentID = department.getDepartmentID();

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, departmentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                //COURSE
                courseCode = rs.getString("course_code");
                courseName = rs.getString("course_name");

                courseList.add(new Course(courseCode, courseName, department));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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

        return courseList;

    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        Course course = (Course) object;
        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[course] (course_code, department_id, course_name) VALUES (?,?,?);";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseCode());
            ps.setInt(2, course.getDepartment().getDepartmentID());
            ps.setString(3, course.getCourseName());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CourseBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
               if(ps != null)  ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }

        return 1;
         }

    @Override
    public int delete(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        Course course = (Course) object;

        String selectSQL = "DELETE FROM [GlossaryDataBase].[dbo].[course] WHERE [GlossaryDataBase].[dbo].[course].course_code = ?;";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                if(ps != null) ps.close();
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

        PreparedStatement ps = null;
        Course course = (Course) object;

        String selectSQL = "UPDATE [GlossaryDataBase].[dbo].[course] "
                + "SET [GlossaryDataBase].[dbo].[course].course_code = ?, "
                + "[GlossaryDataBase].[dbo].[course].department_id = ?, "
                + "[GlossaryDataBase].[dbo].[course].course_name = ? "
                + "WHERE [GlossaryDataBase].[dbo].[course].course_code = ?;";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, course.getCourseCode());
            ps.setInt(2, course.getDepartment().getDepartmentID());
            ps.setString(3, course.getCourseName());
            ps.setString(4, course.getCourseCode());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
              if(ps != null)  ps.close();
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
        List<Object> courses = new ArrayList<>();

        String c_code = null;
        int dept_id = 0;
        String c_name = null;

        Course course = null;

        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[course];";
        PreparedStatement ps = null;
        ResultSet rs = null;

        Department department = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                course = new Course();
                department = new Department();
                c_code = rs.getString("course_code");
                dept_id = rs.getInt("department_id");
                c_name = rs.getString("course_name");
                department.setDepartmentID(dept_id);
                course = new Course(c_code, c_name, department);

                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return courses;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * getByUser method used to get all the courses selected by a user
 * 
 * @param user represents the user to get the course
 * @return a course list for the user
 */
    public ArrayList<Course> getByUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        DepartmentService ds = new DepartmentService();
        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[user_course]  "
                + "join [GlossaryDataBase].[dbo].[course] "
                + "on [GlossaryDataBase].[dbo].[course].course_code=[GlossaryDataBase].[dbo].[user_course].course_code "
                + "WHERE user_id=?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Course> courseList = new ArrayList<>();

        //for course list
        String courseCode = null;
        String courseName = null;
        int department;
        String userID = user.getID();

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            while (rs.next()) {
                //COURSE
                courseCode = rs.getString("course_code");
                courseName = rs.getString("course_name");
                department = rs.getInt("department_id");
                courseList.add(new Course(courseCode, courseName, new Department(department)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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

        return courseList;

    }
/**
 * search method is to all the courses that partially matches the input with 
 * course code or course name
 * 
 * @param searchWith the text needs to search with
 * @return a list course fulfill requirements
 */
    public List<Course> search(String searchWith) {
ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[course] "
                + "WHERE [GlossaryDataBase].[dbo].[course].course_code LIKE ? "
                + "OR [GlossaryDataBase].[dbo].[course].course_name LIKE ? ;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Course> courseList = new ArrayList<>();

        //for course list
        String courseCode = null;
        String courseName = null;
        int departmentID;
        Department department;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, "%"+ searchWith +"%");
            ps.setString(2, "%"+ searchWith +"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                //COURSE
                courseCode = rs.getString("course_code");
                courseName = rs.getString("course_name");
                departmentID = rs.getInt("department_id");
                department = new Department(departmentID);
                courseList.add(new Course(courseCode, courseName, department));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
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

        return courseList;
    }
}
