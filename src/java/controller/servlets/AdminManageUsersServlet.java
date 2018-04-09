/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.AccountLog;
import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.User;
import business.serviceClasses.AccountLogService;
import business.serviceClasses.AccountRequestService;
import business.serviceClasses.CourseService;
import business.serviceClasses.PrivilegeService;
import business.serviceClasses.UserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.WebMailUtil;

/**
 * Receive and response to requests from web client for administrator page
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class AdminManageUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Department department = user.getDepartment();
        UserService us = new UserService();
        String action = request.getParameter("action");

        PrivilegeService ps = new PrivilegeService();
        List<Privilege> privilegeList = ps.getAll();
        request.setAttribute("privilegeList", privilegeList);
        if (action != null) {
            if (action.equals("view")) {
                String selectedUserID = request.getParameter("selectedID");
                User selectedUser = us.get(selectedUserID);
                boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

                if (ajax) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    Gson gson = new Gson();

                    String str = gson.toJson(selectedUser);

                    response.getWriter().write(str);
                    return;
                }
            }
        }
        List<User> userList = us.getByDepartment(department);
        request.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher("/WEB-INF/_admin/admin_manage_users.jsp").forward(request, response);
        
        String msg = (String)session.getAttribute("message");
        if (msg != null && !msg.isEmpty())
            session.removeAttribute("message");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/_admin/admin_manage_users.jsp";
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        UserService us = new UserService();
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            String selectedUserID = request.getParameter("selectedID");
            us.delete(selectedUserID);
        } else if (action != null && action.equals("manage")) {
            Department department = currentUser.getDepartment();
            String name = request.getParameter("userName");
            String email = request.getParameter("email");
            List<Privilege> privilegeList = new ArrayList<Privilege>();
            String[] privilegeStr = request.getParameterValues("privilege");
            String id = request.getParameter("userId");
            boolean active = false;

            if (name == null || name.equals("")
                    || email == null || email.equals("")
                    || privilegeStr == null || privilegeStr.length == 0) {
                //display error message about fields empty
                session.setAttribute("message", "All fields must be completed");
                response.sendRedirect("manageusers");
                return;
            }

            for (int i = 0; i < privilegeStr.length; i++) {
                privilegeList.add(new Privilege(Integer.parseInt(privilegeStr[i])));
            }

            if (!email.endsWith("@edu.sait.ca") && !email.endsWith("@sait.ca")) {
                //display error message about email not from sait
                session.setAttribute("message", "Please use SAIT email for registration");
                response.sendRedirect("manageusers");
                return;
            }

            User user = us.get(id);
            if (user != null) {
                if (request.getParameter("status").equals("active")) {
                    active = true;
                } else if (request.getParameter("status").equals("inactive")) {
                    active = false;
                }

                user.setEmail(email);
                user.setIsActivated(active);
                user.setName(name);
                user.getPrivileges().setPrivileges(privilegeList);
                us.update(user);
                us.reloadPrivileges(user);
            } else {

                if (!id.matches("\\d{9}")) {
                    session.setAttribute("message", "Please use valid 9-digit SAIT ID");
                    response.sendRedirect("manageusers");
                    return;
                }

                if ((us.get(id) != null) || (us.getByEmail(email) != null)) {
                    session.setAttribute("message", "Account already exist");
                    response.sendRedirect("manageusers");
                    return;
                }
                user = new User();
                user.setDepartment(department);
                user.setEmail(email);
                user.setIsActivated(active);
                user.setName(name);
                user.getPrivileges().setPrivileges(privilegeList);
                user.setID(id);
                user.setPassword(id);
                us.insert(user);

                try {
                    AccountRequestService ars = new AccountRequestService();
                    String token = ars.insert(user, 1);

                    AccountLogService als = new AccountLogService();
                    AccountLog log = new AccountLog(1, user, new Date());
                    als.insert(log);

                    HashMap<String, String> contents = new HashMap<>();
                    StringBuffer emailURL = request.getRequestURL();
                    String uri = request.getRequestURI();
                    String ctx = request.getContextPath();
                    String base = emailURL.substring(0, emailURL.length() - uri.length() + ctx.length());
                    contents.put("link", base + "/login?id=" + token);

//                    WebMailUtil.sendMail(email, "Online Glossary System New Registration",
//                            getServletContext().getRealPath("/WEB-INF") + "/emailtemplates/newregistration.html", contents);
                } catch (Exception ex) {
                    Logger.getLogger(AdminManageUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        response.sendRedirect("manageusers");
    }
}
