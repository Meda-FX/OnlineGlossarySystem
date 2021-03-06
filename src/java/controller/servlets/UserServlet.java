/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for user account page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Department department = user.getDepartment();
        CourseService cs = new CourseService();
        List<Course> courseList = cs.getByDepartment(department);
        request.setAttribute("courseList", courseList);
        getServletContext().getRequestDispatcher("/WEB-INF/userAccount.jsp").forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Department department = user.getDepartment();
        CourseService cs = new CourseService();
        UserService us = new UserService();
        List<Course> courseList = cs.getByDepartment(department);
        Course c = new Course();        
       
        String action = request.getParameter("action");
        String selectedCourse[] = request.getParameterValues("selectedCourse");          
        
        if(action != null && action.equals("addCourse")) {
            user.getCourses().reload(selectedCourse);
            us.reloadCourses(user);
            user = us.get(user.getID());
            session.setAttribute("user", user);
           // request.setAttribute("test", "You have reached action.");
            
        }
        //getServletContext().getRequestDispatcher("/WEB-INF/userAccount.jsp").forward(request, response);
        doGet(request, response);
    }
}
