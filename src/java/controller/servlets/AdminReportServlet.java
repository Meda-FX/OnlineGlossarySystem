/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.AccountLog;
import business.domainClasses.Department;
import business.domainClasses.User;
import business.serviceClasses.AccountLogService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.ReportUtil;

/**
 *
 * @author 727153
 */
public class AdminReportServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/_admin/admin_report.jsp";
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null && action.equals("report")) {
            try {
                User user = (User) session.getAttribute("user");
                Department department = user.getDepartment();
                Date start = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("start"));
                Date end = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("end"));
                int type = Integer.parseInt(request.getParameter("type"));
                
                AccountLogService als = new AccountLogService();
                List<AccountLog> logList = als.getByDDT(start, end, department.getDepartmentID(), type);

                boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

                if (ajax) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    String json = ReportUtil.prepareData(logList);
                    response.getWriter().write(json);
                    return;
                }
            } catch (Exception ex) {
                request.setAttribute("message", "Error generating report. Please ensure all options are selected.");
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
