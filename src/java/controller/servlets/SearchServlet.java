/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.Department;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
import business.serviceClasses.DefinitionService;
import business.serviceClasses.DepartmentService;
import business.serviceClasses.GlossaryEntryService;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for search page
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        GlossaryEntryService ges = new GlossaryEntryService();
        DepartmentService ds = new DepartmentService();
        CourseService cs = new CourseService();
        UserService us = new UserService();
        DefinitionService defs = new DefinitionService();

        String url = "/WEB-INF/index.jsp";
        String searchedEntry;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //ArrayList<GlossaryEntry> termlist = new ArrayList<>();
        ArrayList<Course> courselist = new ArrayList<>();
        ArrayList<User> instructorlist = new ArrayList<>();
        ArrayList<Department> deparlist = (ArrayList<Department>) ds.getAll();
        ArrayList<Definition> definitionlist = new ArrayList<>();
        ArrayList<Definition> deflist = new ArrayList<>();
        Boolean emptyTerm = true;
        //load course list and instructor list
        if (user != null) {
            courselist = (ArrayList<Course>) cs.getByDepartment(user.getDepartment());
            ArrayList<User> userlist = (ArrayList<User>) us.getByDepartment(user.getDepartment());
            for (User u : userlist) {
                if (u.getPrivileges().contains(4)) {
                    instructorlist.add(u);
                }
            }
        }

        //get advanced search from the page
        String departmentID = request.getParameter("departmentID");
        String courseCode = request.getParameter("courseCode");
        String userId = request.getParameter("userId");
        //get searching key word from field
        if (action != null && action.equals("searchTerm")) {
            url = "/WEB-INF/search.jsp";
            searchedEntry = request.getParameter("searchedEntry");
            //term can't be null or empty
            if (searchedEntry == null || searchedEntry.equals("")) {
                //display error message about empty input
                request.setAttribute("emptyInput", true);
            } else {
                request.setAttribute("searchedEntry", searchedEntry);

                //should return a list of entries based on the searching term
//               ArrayList<GlossaryEntry> temptermlist;
//                temptermlist = (ArrayList<GlossaryEntry>) ges.getMatched(searchedEntry);
                // termlist
                if (user == null && departmentID != null && !departmentID.isEmpty()) {
                    //filter by deparment
                    int deptId = 0;
                    try {
                        deptId = Integer.parseInt(departmentID);
                        request.setAttribute("curSelectedDepart", departmentID);
                        definitionlist = (ArrayList<Definition>) defs.getMatchedFilterByDepart(searchedEntry, deptId);
                    } catch (NumberFormatException e) {
                        System.out.println("error occur!");
                    }

                } else if ((user != null && (courseCode != null) && !courseCode.isEmpty()) || (user != null && (userId != null) && !userId.isEmpty())) {
                    // request.setAttribute("recCourseCode", courseCode);
                    if (courseCode == null) {
                        courseCode = "";
                    }
                    if (userId == null) {
                        userId = "";
                    }
                    //curSelectedCour curSelectedUser
                    request.setAttribute("curSelectedCour", courseCode);
                    request.setAttribute("curSelectedUser", userId);
                    definitionlist = (ArrayList<Definition>) defs.getMatchedFilterByCU(searchedEntry, courseCode, userId);
                } //                if (user != null && (userId != null) && !userId.isEmpty()) {
                //                    // request.setAttribute("recInstrID", userId);
                //                }
                else {
                    definitionlist = (ArrayList<Definition>) defs.getMatched(searchedEntry);
                }
            }
        }
        if (action != null && action.equals("alphSearch")) {
            String letter = request.getParameter("letter") + "";
            url = "/WEB-INF/search.jsp";
            boolean res = Pattern.matches("[A-Za-z]", letter);
            if (res == false) {
                request.setAttribute("message", "error occur!");
            } else {
                letter = letter.toUpperCase();
                //   termlist = ges.getByAlpha(letter);
                definitionlist = defs.getByAlpha(letter);
            }
        }
        if (action != null && action.equals("advancedSearch")) {
            url = "/WEB-INF/search.jsp";
            emptyTerm = false;
        }
        for (Definition d : definitionlist) {
            if (d.getStatus().equals("Published")) {
                deflist.add(d);
            }
        }
        if (!deflist.isEmpty()) {

            request.setAttribute("definitionlist", deflist);
        } //return null means no such entries
        else {
            //display message to tell user
            if (emptyTerm == true) {
                request.setAttribute("noSuchEntry", true);
            }
        }
        request.setAttribute("deparlist", deparlist);
        request.setAttribute("courselist", courselist);
        request.setAttribute("instructorlist", instructorlist);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}
