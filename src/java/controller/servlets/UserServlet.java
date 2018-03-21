/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.CourseList;
import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.PrivilegeList;
import business.domainClasses.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistence.brokers.CourseBroker;
import persistence.brokers.DepartmentBroker;
import persistence.brokers.PrivilegeBroker;

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
        User user = (User) session.getAttribute("user");
        DepartmentBroker db = new DepartmentBroker();

        
        String userId = user.getID();
        String name = user.getName();
        String email = user.getEmail();
        Department department = user.getDepartment();
        boolean activated = user.getIsActivated();
        PrivilegeList privilegeList = user.getPrivileges();
        CourseList courseList = user.getCourses();
        
        
        request.setAttribute("userId", userId);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("department", department);
        request.setAttribute("privilegeList", privilegeList);
        request.setAttribute("activated", activated);
        request.setAttribute("courseList", courseList);
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
