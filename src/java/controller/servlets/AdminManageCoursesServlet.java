/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.AccountLog;
import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.User;
import business.serviceClasses.AccountLogService;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.CourseService;
import business.serviceClasses.PrivilegeService;
import business.serviceClasses.UserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.WebMailUtil;

/**
 *
 * @author 727153
 */
@WebServlet(name = "AdminManageCoursesServlet", urlPatterns = {"/managecourses"})
public class AdminManageCoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Department department = user.getDepartment();
        CourseService cs = new CourseService();
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("view")) {
                String selectedCourseCode = request.getParameter("selectedID");
                Course selectedCourse = cs.get(selectedCourseCode);
                session.setAttribute("sessionSelectedCourseID", selectedCourseCode);
                boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

                if (ajax) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    Gson gson = new Gson();

                    String str = gson.toJson(selectedCourse);

                    response.getWriter().write(str);
                    return;
                }
            }
        }
        List<Course> courseList = cs.getByDepartment(department);
        request.setAttribute("courseList", courseList);
        String sessionCourseID = (String) session.getAttribute("sessionSelectedCourseID");
        if (sessionCourseID != null && !sessionCourseID.isEmpty()) {
            session.removeAttribute("sessionSelectedCourseID");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/_admin/admin_manage_courses.jsp").forward(request, response);

        String msg = (String) session.getAttribute("message");
        if (msg != null && !msg.isEmpty()) {
            session.removeAttribute("message");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/_admin/admin_manage_courses.jsp";
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        CourseService cs = new CourseService();
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            String selectedCourseID = request.getParameter("selectedID");
            cs.delete(new Course(selectedCourseID));
            session.setAttribute("message", "Course deleted");
        } else if (action != null && action.equals("manage")) {
            String sessionSelectedCourseID = (String) session.getAttribute("sessionSelectedCourseID");
            Department department = currentUser.getDepartment();
            String name = request.getParameter("courseName");
            String id = request.getParameter("courseId");

            if (name == null || name.equals("")
                    || id == null || id.equals("")) {
                //display error message about fields empty
                session.setAttribute("message", "All fields must be completed");
                response.sendRedirect("managecourses");
                return;
            }

            if (sessionSelectedCourseID != null && sessionSelectedCourseID.equals(id)) {
                Course course = cs.get(id);
                course.setCourseName(name);
                cs.update(course);
                session.setAttribute("message", "Course updated");
            } else {

                Course course = cs.get(id);
                if ((cs.get(id) != null)) {
                    session.setAttribute("message", "Course already exists");
                    response.sendRedirect("managecourses");
                    return;
                }
                try {
                    course = new Course();
                    course.setDepartment(department);
                    course.setCourseCode(id);
                    course.setCourseName(name);
                    cs.insert(course);

                    session.setAttribute("message", "Course created successfully");
                } catch (Exception ex) {
                    Logger.getLogger(AdminManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                    session.setAttribute("message", "Unable to create course");
                }
            }
        }
        response.sendRedirect("managecourses");
    }
}
