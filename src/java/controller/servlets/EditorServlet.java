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
import business.serviceClasses.UserService;
import com.google.gson.Gson;
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
        //GlossaryEntryLogService grs = new GlossaryEntryLogService();
        ArrayList<Course> courlist = (ArrayList<Course>) cs.getByDepartment(user.getDepartment());
        ArrayList<User> userlist = (ArrayList<User>) us.getByDepartment(user.getDepartment());
        ArrayList<Definition> deflist = new ArrayList<>();
        ArrayList<User> instructorlist = new ArrayList<>();

        ArrayList<Definition> definitionlist = new ArrayList<>();
        String action = request.getParameter("action");
        String defId = request.getParameter("defId");
        String txtSearch = request.getParameter("txtSearch");
        Definition def = new Definition();

        for (User u : userlist) {
            if (u.getPrivileges().contains(4)) {
                instructorlist.add(u);
            }
        }

        if (txtSearch != null && !txtSearch.equals("")) {
            request.setAttribute("txtSearch", txtSearch);
            String courseCode = request.getParameter("courseCode");
            //request.setAttribute("courseCode", courseCode);
            String userId = request.getParameter("userId");
            deflist = (ArrayList<Definition>) ds.getByDepartmentFilterByTCU(user.getDepartment(), txtSearch, courseCode, userId);

        } else {
            deflist = (ArrayList<Definition>) ds.getByDepartment(user.getDepartment());
        }
        if (deflist.isEmpty()) {
            request.setAttribute("message", "There are no terms!");
        } else {
            for (Definition d : deflist) {
                if (d.getStatus().equals("Published")) {
                    definitionlist.add(d);
                }
                if (defId != null && !defId.equals("") && defId.equals(d.getDefinitionID() + "")) {
                    def = d;
                }
            }
        }
        if (action != null && action.equals("edit")) {
            url = "/WEB-INF/_editor/editor.jsp";
            boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

            if (ajax) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                Gson gson = new Gson();
                String str = gson.toJson(def);
                response.getWriter().write(str);
                return;
            }
            // request.setAttribute("selectedTerm", def);

        }

        request.setAttribute("definitionlist", definitionlist);
        request.setAttribute("courselist", courlist);
        request.setAttribute("userlist", instructorlist);

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String url = "/WEB-INF/_editor/editor.jsp";
        DefinitionService ds = new DefinitionService();
        String action = request.getParameter("action");
        //for the buttons in different pages

        //only these fields need to update.
        String contents = request.getParameter("definition");
        String ciation = request.getParameter("citation");
        String dicDef = request.getParameter("defDefinition");
        String dicCitation = request.getParameter("dicCitation");
        String definitionId = request.getParameter("defId");
        int defId;
        //Integer.parseInt(request.getParameter("defId"));
        String status; //status of the term
        Definition definition = new Definition();
//                if (contents != null && !contents.equals("")
//                && ciation != null && !ciation.equals("")
//                && dicDef != null && !dicDef.equals("")
//                && dicCitation != null && !dicCitation.equals("")
//                && definitionId != null && !definitionId.equals("")) {
//            defId = Integer.parseInt(definitionId);
//            definition.setDefinitionID(defId);
//            definition.setContent(contents);
//            definition.setCitation(ciation);
//            definition.setDictionaryContent(dicDef);
//            definition.setDictionaryCitation(dicCitation);
//        } else {
//            request.setAttribute("message", "cannot be empty");
//
//            //getServletContext().getRequestDispatcher(url).forward(request, response);
//        }
        try {
            defId = Integer.parseInt(definitionId);
            definition=ds.getByID(defId);

            if (action != null && action.equals("Delete Term")) {
                url = "/WEB-INF/_editor/editor.jsp";
                status = "Inactive";
                ds.delete(definition);
            }

            if (action != null && action.equals("Save Term")) {
                definition.setContent(contents);
                definition.setCitation(ciation);
                definition.setDictionaryContent(dicDef);
                definition.setDictionaryCitation(dicCitation);
                url = "/WEB-INF/_editor/editor.jsp";
                status = "Under Review";
                definition.setStatus(status);
                ds.update(definition);
            }
            if (action != null && action.equals("Submit Term")) {
                definition.setContent(contents);
                definition.setCitation(ciation);
                definition.setDictionaryContent(dicDef);
                definition.setDictionaryCitation(dicCitation);
                url = "/WEB-INF/_editor/editor.jsp";
                status = "Published";
                definition.setStatus(status);
                ds.update(definition);
            }

        } catch (Exception e) {
            request.setAttribute("message", "cannot be empty");
        }

        doGet(request, response);
        //getServletContext().getRequestDispatcher(url).forward(request, response);

    }
}
