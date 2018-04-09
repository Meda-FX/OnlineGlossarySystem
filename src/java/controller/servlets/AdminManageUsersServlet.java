/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Course;
import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
import business.serviceClasses.PrivilegeService;
import business.serviceClasses.UserService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for administrator page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class AdminManageUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        
        Department department = user.getDepartment();
        UserService us = new UserService();
        String action = request.getParameter("action");
        if  (action != null && action.equals("view")) {
            String selectedUserID = request.getParameter("selectedID");
            User selectedUser = us.get(selectedUserID);
            selectedUser.setPassword("");
            request.setAttribute("selectedUser", selectedUser);
        } 
        if (action != null && action.equals("add")) {
            CourseService cs = new CourseService();
            List<Course> courseList = cs.getByDepartment(department);
            request.setAttribute("courseList", courseList);
            PrivilegeService ps = new PrivilegeService();
            List<Privilege> privilegeList = ps.getAll();
            request.setAttribute("privilegeList", privilegeList);
        }
        List<User> userList = us.getByDepartment(department);
        request.setAttribute("userList", userList);
        getServletContext().getRequestDispatcher("/WEB-INF/_admin/admin_manage_users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        String url = "/WEB-INF/_admin/admin_manage_users.jsp";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Department department = user.getDepartment();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        List<Privilege> privilegeList = null; //TODO
        List<Course> courseList = null; //TODO
        boolean active = request.getParameter("active") != null;
        UserService us = new UserService();
        String action = request.getParameter("action");
        User users = new User();
        if (action != null && action.equals("delete")) {
            String selectedUserID = request.getParameter("selectedID");
            us.delete(selectedUserID);
        } else if (action != null && action.equals("edit")) {
//            User userEdit = us.get(id);
//            userEdit.setDepartment(department);
//            userEdit.setEmail(email);
//            userEdit.setIsActivated(active);
//            userEdit.setName(name);
//            userEdit.getPrivileges().setPrivileges(privilegeList);
//            userEdit.getCourses().setCourses(courseList);
//            if (password!=null & !password.isEmpty())
//                userEdit.setPassword(password);
//            us.update(user);
            
            boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

            if (ajax) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                Gson gson = new Gson();

                String str = gson.toJson(users);

                response.getWriter().write(str);
                return;
            }
        } else if (action.equals("register")) {
            User userRegister = new User();
            userRegister.setDepartment(department);
            userRegister.setEmail(email);
            userRegister.setIsActivated(active);
            userRegister.setName(name);
            userRegister.getPrivileges().setPrivileges(privilegeList);
            userRegister.getCourses().setCourses(courseList);
            userRegister.setID(id);
            userRegister.setPassword(password);
            us.insert(user);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
        //response.sendRedirect("managerusers");
    }
}
