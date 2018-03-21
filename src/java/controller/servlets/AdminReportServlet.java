/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 727153
 */
public class AdminReportServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String url = "/WEB-INF/_admin/admin.jsp";
        if(action != null && action.equals("manageUsers"))
        {
            url = "/WEB-INF/_admin/admin_manage_users.jsp";
        }
        if(action != null && action.equals("report"))
        {
            url = "/WEB-INF/_admin/admin_report.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);    
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}