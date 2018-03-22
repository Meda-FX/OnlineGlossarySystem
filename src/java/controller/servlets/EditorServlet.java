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
import business.serviceClasses.GlossaryEntryService;
import business.serviceClasses.GlossaryRequestService;
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

        String action = request.getParameter("action");
        String url = "/WEB-INF/_editor/editor.jsp";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        GlossaryEntryService ges = new GlossaryEntryService();
        CourseService cs = new CourseService();
        //useless, there no table in the database
        GlossaryRequestService grs = new GlossaryRequestService();
        ArrayList<Definition> deflist = new ArrayList<>();
        ArrayList<Course> courlist = (ArrayList<Course>) cs.getByDepartment(user.getDepartment());

        if (courlist.size() == 0) {
            //need to discuss
            request.setAttribute("message", true);
        } else {
            for (Course c : courlist) {
                deflist.addAll(ges.getByCourse(c));
            }
        }

        if (action != null && action.equals("pendingTerms")) {
            url = "/WEB-INF/_editor/editor_pending_terms.jsp";

        }
        if (action != null && action.equals("manageTerms")) {
            url = "/WEB-INF/_editor/editor.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
    }
}
