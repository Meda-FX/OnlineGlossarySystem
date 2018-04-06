/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import business.serviceClasses.CourseService;
import business.serviceClasses.DefinitionService;
import business.serviceClasses.GlossaryEntryService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistence.brokers.GlossaryEntryBroker;

/**
 * Receive and response to requests from web client for instructor page
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class InstructorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/WEB-INF/_instructor/instructor.jsp";

        HttpSession session = request.getSession();
        DefinitionService ds = new DefinitionService();
        CourseService cs = new CourseService();

        User user = (User) session.getAttribute("user");
        List<Definition> termList = ds.getByMadeBy(user);
        List<Course> courseList = cs.getByUser(user);
        request.setAttribute("definitionlist", termList);
        request.setAttribute("courseList", courseList);
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {

            url = "/WEB-INF/_instructor/instructor.jsp";
            boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

            if (ajax) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                Gson gson = new Gson();


                String str = gson.toJson(ds.getByID(Integer.parseInt(request.getParameter("defId"))));

                response.getWriter().write(str);
                return;
            }
            // request.setAttribute("selectedTerm", def);

        }

         
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "/WEB-INF/_instructor/instructor.jsp";
        String action = request.getParameter("submitButton");
        String term = request.getParameter("term");
        String definition = request.getParameter("definition");
        String citation = request.getParameter("citation");
        String defDict = request.getParameter("defDefinition");
        String defCita = request.getParameter("dicCitation");
        String course = request.getParameter("courseCode");
        String errorMessage = "The following fields are blank / invalid";
        Timestamp date = new Timestamp(new Date().getTime());
        DefinitionService ds = new DefinitionService();
        CourseService cs = new CourseService();
        Course newCourse = cs.get(course);
        Definition newEntry = new Definition();
        User user = (User) session.getAttribute("user");

        
        newEntry.setCitation(citation);
        newEntry.setContent(definition);
        newEntry.setCourse(newCourse);
        newEntry.setDictionaryContent(defDict);
        newEntry.setDictionaryCitation(defCita);
        newEntry.setTerm(term);
        newEntry.setWrittenBy((User) session.getAttribute("user"));

        // checking to see if any of the required terms are null
        if (action.equalsIgnoreCase("Submit Term") == true) {
            if (checkGlossaryEntry(newEntry) == false) {
                GlossaryEntryBroker ges = new GlossaryEntryBroker();
                GlossaryEntry newGlossaryEntry = new GlossaryEntry(date, term, user);
                ges.insert(newGlossaryEntry);
            }
            if (term.isEmpty() == true) {
                errorMessage += " Term";
            }
            if (definition.isEmpty() == true) {
                errorMessage += " definition";
            }
            if (defDict.isEmpty() == true) {
                errorMessage += " dictionary definition";
            }
            if (defCita.isEmpty() == true) {
                errorMessage += " dictionary citation";
            }
            if (course.equalsIgnoreCase("-1") == true) {
                errorMessage += " course";
            }
            if (term.isEmpty() == true
                    || definition.isEmpty() == true || defDict.isEmpty() == true
                    || defCita.isEmpty() == true || course.equalsIgnoreCase("-1") == true) {
                request.setAttribute("term", term);
                request.setAttribute("definition", definition);
                request.setAttribute("citation", citation);
                request.setAttribute("defDefinition", defDict);
                request.setAttribute("dicCitation", defCita);
                request.setAttribute("courseCode", course);
                request.setAttribute("message", errorMessage);
                action = "";
            } else {
                newEntry.setStatus("Under Review");
                //Remove all of the something went wrongs!!!!
                if (ds.insert(newEntry) == 1) {
                    errorMessage = "Your term is now pending review!";
                } else {
                    errorMessage = "Something went wrong with the term Entry";
                }

            }
        }
        //This is checking to see if the term already exists on the 
        //GlossaryEntry table. If it doesn't already exit the program will
        //Create the entry

        if (action.equals("Save Term") == true) {
            if (checkGlossaryEntry(newEntry) == false) {
                GlossaryEntryBroker ges = new GlossaryEntryBroker();
                GlossaryEntry newGlossaryEntry = new GlossaryEntry(date, term, user);
                ges.insert(newGlossaryEntry);
            }
            newEntry.setStatus("In Progress");
            if (ds.insert(newEntry) == 1) {
                errorMessage = "Your term is now saved!";
            }
        } else if (action != null && action.equals("Delete")) {
            Definition deleteDefinition = ds.getByID(Integer.parseInt(request.getParameter("defId")));
            ds.delete(deleteDefinition);
            errorMessage = "Your term has been delete!";
        }
        List<Definition> termList = ds.getByMadeBy(user);
        List<Course> courseList = cs.getByUser(user);

        request.setAttribute("courseList", courseList);
        request.setAttribute("definitionlist", termList);
        request.setAttribute("message", errorMessage);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    public boolean checkGlossaryEntry(Definition definition) {
        GlossaryEntryService ges = new GlossaryEntryService();
        List<GlossaryEntry> gesList = ges.getMatched(definition.getTerm());
        for (int i = 0; i < gesList.size(); i++) {
            if (definition.getTerm().equals(gesList.get(i).getTerm()) == true) {
                return true;
            }
        }
        return false;
    }
}
