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
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for administrator page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class AdminManageUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Department department = user.getDepartment();
        UserService us = new UserService();
        String action = request.getParameter("action");
        if  (action != null && action.equals("view")) {
            String selectedUserID = request.getParameter("selectedID");
            User selectedUser = us.get(selectedUserID);
            request.setAttribute("selectedUser", selectedUser);
        } 
        if (action != null && action.equals("add")) {
            CourseService cs = new CourseService();
            List<Course> courseList = cs.getByDepartment(department);
            request.setAttribute("courseList", courseList);
        }
        List<User> userList = us.getByDepartment(department);
        request.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher("/WEB-INF/_admin/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
