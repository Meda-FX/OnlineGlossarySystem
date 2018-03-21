/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Privilege;
import business.domainClasses.User;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.UserService;
import business.serviceClasses.WebMailService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 608964
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String url = "/WEB-INF/register.jsp";
        //ajax to check the field
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String student_id = request.getParameter("studentId"); 
        String password = request.getParameter("pass");
        String password_confirm =request.getParameter("confirmPass"); 
        //Boolean confirm_regis=false; //false means not registered
        UserService us = new UserService();
        AccountRequestService ars = new AccountRequestService();
        String url = "/WEB-INF/register.jsp";
        
        if(fname==null || fname.equals("") || 
                lname==null || lname.equals("") ||
                email==null || email.equals("") ||
                student_id==null || student_id.equals("") ||
                password==null || password.equals("") ||
                password_confirm==null || password_confirm.equals(""))
        {
            //display error message about fields empty
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if (!password.equals(password_confirm)) {
            //display error message about password not matching
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if (!email.endsWith("@edu.sait.ca") && !email.endsWith("@sait.ca")) {
            //display error message about email not from sait
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        User newUser = new User();
        newUser.setName(fname + " " + lname);
        newUser.setEmail(email);
        newUser.setID(student_id);
        newUser.setPassword(password);
        newUser.setIsActivated(false);
        newUser.getPrivileges().add(new Privilege(1));
        
        
        try {
            String token = ars.insert(newUser, 1);
            us.insert(newUser);
            
            HashMap<String, String> contents = new HashMap<>();
            StringBuffer emailURL = request.getRequestURL();
            String uri = request.getRequestURI();
            String ctx = request.getContextPath();
            String base = emailURL.substring(0, emailURL.length() - uri.length() + ctx.length());
            contents.put("link", base + "/login?id=" + token);
            
            WebMailService.sendMail(email, "Online Glossary System New Registration", 
                    getServletContext().getRealPath("/WEB-INF") + "/emailstemplates/newregistration.html", contents);
            
            //display message about checking the email
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        } catch (Exception ex) {
            //display message about failing registration
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
    }
}