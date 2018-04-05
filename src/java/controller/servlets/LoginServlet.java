/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.AccountLog;
import business.domainClasses.User;
import business.serviceClasses.AccountLogService;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            AccountRequestService ars = new AccountRequestService();
            try {
                User user = ars.verifyID(id, 1);
                if (user != null) {
                    user.setIsActivated(true);
                    UserService us = new UserService();
                    us.update(user);
                    ars.removeOldRequest(user, 1);
                    request.setAttribute("loginMessage", "Account activated, now you can log in");
                } else {
                    request.setAttribute("loginMessage", "Unable to activate account. Plese contact your department office.");
                }
            } catch (Exception ex) {
                request.setAttribute("loginMessage", "Unable to activate account. Plese contact your department office.");
            }
        }
        
        if(action != null && action.equals("logout"))
        {
            url = "/WEB-INF/index.jsp";
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
            //request.setAttribute("isEmpty", true);
            request.setAttribute("loginMessage", "You need to enter your email and password.");
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return ;
        }
        
        UserService us = new UserService();
        User user = us.checkLogin(username,password);
        if(user == null)
        {
            //request.setAttribute("isInvalid", true);
            request.setAttribute("loginMessage", "Invalid email or password!");
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return ;
        }
        else
        {
            //user.setPassword("");
            AccountLogService als = new AccountLogService();
            AccountLog log = new AccountLog(2, user, new Date());
            als.insert(log);
            session.setAttribute("user", user);
            url = "/WEB-INF/index.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
        
    }
}
