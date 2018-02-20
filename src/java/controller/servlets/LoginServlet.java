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
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
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

        }
     //   getServletContext().getRequestDispatcher(url).forward(req, resp);
        
        
    }
}
