/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
import business.serviceClasses.DefinitionService;
import business.serviceClasses.GlossaryEntryService;
import business.serviceClasses.GlossaryRequestService;
import business.serviceClasses.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Receive and response to requests from web client for editor page
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class EditorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/_editor/editor.jsp";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        GlossaryEntryService ges = new GlossaryEntryService();
        DefinitionService ds = new DefinitionService();
        CourseService cs = new CourseService();
        UserService us = new UserService();
        //useless, there no table in the database
        GlossaryRequestService grs = new GlossaryRequestService();
        ArrayList<Course> courlist = (ArrayList<Course>) cs.getByDepartment(user.getDepartment());
        ArrayList<User> userlist = (ArrayList<User>) us.getByDepartment(user.getDepartment());
        ArrayList<Definition> deflist = (ArrayList<Definition>) ds.getByDepartment(user.getDepartment());

        for (Definition d : deflist) {
            if (d.getStatus().equals("Under Review") || d.getStatus().equals("In Progress")) {
                deflist.remove(d);
            }
        }
        request.setAttribute("definitionlist", deflist);
        request.setAttribute("courselist", courlist);
        request.setAttribute("userlist", userlist);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String url = "/WEB-INF/_editor/editor.jsp";

        String action = request.getParameter("action");
        //for the buttons in different pages
        int dId = Integer.parseInt(request.getParameter("definitionId"));
        //only these fields need to update.
        String contents = request.getParameter("definition");
        String ciation = request.getParameter("citation");
        String dicDef = request.getParameter("defDefinition");
        String dicCitation = request.getParameter("dicCitation");
        String status; //status of the term

        if (action != null && action.equals("delete")) {
            url = "/WEB-INF/_editor/editor.jsp";
            status="Inactive";
        }
        if (action != null && action.equals("SavePending")) {
            url = "/WEB-INF/_editor/editor.jsp";
            status = "Under Review";
        }
        if (action != null && action.equals("SavePublish")) {
            url = "/WEB-INF/_editor/editor.jsp";
            status = "Published";
        }
        if (action != null && action.equals("EditDefinition")) {
            url = "/WEB-INF/_editor/editor.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

    }
}
