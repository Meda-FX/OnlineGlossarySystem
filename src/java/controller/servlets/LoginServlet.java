/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.User;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for login page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String url = "/WEB-INF/login.jsp";
        if(action != null && action.equals("logout"))
        {
            session.invalidate();
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String url = "/WEB-INF/login.jsp";
        HttpSession session = request.getSession();
        if(username==null ||username.isEmpty() || password==null ||password.isEmpty())
        {
            request.setAttribute("isEmpty", true);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return ;
        }
        
        UserService us = new UserService();
        User user = us.checkLogin(username,password);
        if(user == null)
        {
            request.setAttribute("isInvalid", true);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return ;
        }
        else
        {
            //user.setPassword("");
            session.setAttribute("user", user);
            if(user.getPrivileges().contains(1)) // admin
            {
               url = "/WEB-INF/_admin/admin.jsp";
            }
            else if(user.getPrivileges().contains(2)) //editor
            {
                url = "/WEB-INF/_editor/editor.jsp";
            }
            else if(user.getPrivileges().contains(3)) //instructor
            {
                url = "/WEB-INF/_instructor/instructor.jsp";
            }
            else if(user.getPrivileges().contains(4)) //student
            {
                url = "/WEB-INF/_student/student.jsp";
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
        
    }
}
