/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.User;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.UserService;
import utility.WebMailUtil;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for forget password page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class ForgetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        try {
            String email = request.getParameter("email");
            
            UserService us = new UserService();
            User user = us.getByEmail(email);
            if (!user.getIsActivated()) {
                request.setAttribute("message", "Unable to find email. Please contact your department office");
                getServletContext().getRequestDispatcher("/WEB-INF/forgetPassword.jsp").forward(request, response);
                return;
            }
            
            AccountRequestService ars = new AccountRequestService();
            ars.removeOldPasswordRequest(user);
            String token = ars.insert(user, 2);
            
            HashMap<String, String> contents = new HashMap<>();
            StringBuffer url = request.getRequestURL();
            String uri  = request.getRequestURI();
            String ctx = request.getContextPath();
            String base = url.substring(0, url.length() - uri.length() + ctx.length());
            contents.put("link", base + "/newpassword?id=" + token);
            
            WebMailUtil.sendMail(email, "OnlineGlossarySystem Reset Password", 
                    getServletContext().getRealPath("/WEB-INF") + "/emailtemplates/resetpassword.html", contents);
            request.setAttribute("loginMessage", "Please check your email");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", "Unable to find email. Please contact your department office");
            getServletContext().getRequestDispatcher("/WEB-INF/forgetPassword.jsp").forward(request, response);
            return;
        }
    }
}
