/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
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
        Boolean confirm_regis=false; //false means not registered
        UserService us = new UserService();
        String url = "/WEB-INF/register.jsp";
        
        if(fname!=null &&!fname.equals("") && 
                lname!=null &&!lname.equals("") &&
                email!=null &&!email.equals("") &&
                student_id!=null &&!student_id.equals("") &&
                password!=null &&!password.equals("") &&
                password_confirm!=null &&!password_confirm.equals(""))
        {
            confirm_regis=us.registerUser(fname+" "+lname,email,student_id,password,password_confirm);
        }
        
        if(confirm_regis==false) 
        {
            //display error message
        }
        else 
        {
            //display message to check their email
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
