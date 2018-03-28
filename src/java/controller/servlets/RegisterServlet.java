/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.User;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.DepartmentService;
import business.serviceClasses.UserService;
import utility.WebMailUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
        
        String url = "/WEB-INF/register.jsp";
        DepartmentService ds = new DepartmentService();
        List<Department> departments = ds.getAll();
        request.setAttribute("departments", departments);
        
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
        int departmentID = Integer.parseInt(request.getParameter("department"));
        UserService us = new UserService();
        AccountRequestService ars = new AccountRequestService();
        String url = "/WEB-INF/register.jsp";
        
        //for dropdown menu
        DepartmentService ds = new DepartmentService();
        List<Department> departments = ds.getAll();
        request.setAttribute("departments", departments);
        
        if(fname==null || fname.equals("") || 
                lname==null || lname.equals("") ||
                email==null || email.equals("") ||
                student_id==null || student_id.equals("") ||
                password==null || password.equals("") ||
                password_confirm==null || password_confirm.equals(""))
        {
            //display error message about fields empty
            request.setAttribute("message", "All fields must be completed");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            request.setAttribute("email",email);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if (!password.equals(password_confirm)) {
            //display error message about password not matching
            request.setAttribute("message", "Entered passwords not matching");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            request.setAttribute("email",email);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if (!email.endsWith("@edu.sait.ca") && !email.endsWith("@sait.ca")) {
            //display error message about email not from sait
            request.setAttribute("message", "Please use your SAIT email for registration");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if (!student_id.matches("\\d{9}")) {
            request.setAttribute("message", "Please enter valid 9 digit student ID");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
        
        if ((us.get(student_id)!=null) || (us.getByEmail(email)!=null)) {
            request.setAttribute("message", "Account already exist.");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
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
        newUser.setDepartment(new Department(departmentID));
        
        try {
            us.insert(newUser);
            String token = ars.insert(newUser, 1);
            
            
            HashMap<String, String> contents = new HashMap<>();
            StringBuffer emailURL = request.getRequestURL();
            String uri = request.getRequestURI();
            String ctx = request.getContextPath();
            String base = emailURL.substring(0, emailURL.length() - uri.length() + ctx.length());
            contents.put("link", base + "/login?id=" + token);
            
            WebMailUtil.sendMail(email, "Online Glossary System New Registration", 
                    getServletContext().getRealPath("/WEB-INF") + "/emailtemplates/newregistration.html", contents);
            
            //display message about checking the email
            request.setAttribute("message", "Please check your email for account activation");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            request.setAttribute("email",email);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        } catch (Exception ex) {
            //display message about failing registration
            request.setAttribute("message", "Unable to register account, please contact your department office.");
            request.setAttribute("fname", fname);
            request.setAttribute("lname",lname);
            request.setAttribute("studentId", student_id);
            request.setAttribute("email",email);
            getServletContext().getRequestDispatcher(url).forward(request, response);
            return;
        }
    }
}
