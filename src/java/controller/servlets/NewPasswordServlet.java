/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.User;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 727153
 */
public class NewPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            String id = request.getParameter("id");
            AccountRequestService ars = new AccountRequestService();
            User user = ars.verifyID(id, 2);
            if (user != null) {
                session.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/newPassword.jsp").forward(request, response);
                return;
            } else {

            }

        } catch (Exception ex) {
            Logger.getLogger(NewPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("loginMessage", "Unable to reset password, please send another request");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        //response.sendRedirect("login");
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        String password = request.getParameter("password");
        user.setPassword(password);
        UserService us = new UserService();
        try {
            us.update(user);
            //session.invalidate();
            request.setAttribute("loginMessage", "password reset, please log in again");
            //response.sendRedirect("login");
            return;
        } catch (Exception ex) {
            Logger.getLogger(NewPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("loginMessage", "Unable to reset password, please send another request");
        }
        session.invalidate();
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        //response.sendRedirect("login");
        return;
    }
}
