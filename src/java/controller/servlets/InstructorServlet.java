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
        GlossaryEntryService ges = new GlossaryEntryService();
        
        User user = (User) session.getAttribute("user");
        List<GlossaryEntry> termList = ges.getByUser(user.getID());
        request.setAttribute("termList", termList);
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("submitButton");
        String term = request.getParameter("term");
        String definition = request.getParameter("definition");
        String citation = request.getParameter("citation");
        String defDict = request.getParameter("defDefinition");
        String defCita = request.getParameter("defCitation");
        String course = request.getParameter("courseCode");
        String errorMessage = "The following fields are blank / invalid";
        String url = "/WEB-INF/_instructor/instructor.jsp";
        Timestamp date = new Timestamp(new Date().getTime());
        DefinitionService ds = new DefinitionService();
        CourseService cS = new CourseService();
        Course newCourse = cS.get(course);
        Definition newEntry = new Definition();
        User user = (User) session.getAttribute("user");

        if (term == null) {
            errorMessage += " Term";
        }
        if (definition == null) {
            errorMessage += " definition";
        }
        if (defDict == null) {
            errorMessage += " dictionary definition";
        }
        if (defCita == null) {
            errorMessage += " dictionary citation";
        }
        if (course == null) {
            errorMessage += " course";
        }

        newEntry.setCitation(citation);
        newEntry.setContent(definition);
        newEntry.setCourse(newCourse);
        newEntry.setDictionaryContent(defDict);
        newEntry.setDictionaryCitation(defCita);
        newEntry.setTerm(term);
        newEntry.setWrittenBy((User) session.getAttribute("user"));

        //This is checking to see if the term already exists on the 
        //GlossaryEntry table. If it doesn't already exit the program will
        //Create the entry
        if (checkGlossaryEntry(newEntry) == false) {
            GlossaryEntryBroker ges = new GlossaryEntryBroker();
            GlossaryEntry newGlossaryEntry = new GlossaryEntry(date, term, user);
            if (ges.insert(newGlossaryEntry) == 0) {
                errorMessage = "Error something went wrong with the glossary entry!";
            }
        }
        if (action.equals("Submit Term") == true) {
            // checking to see if any of the required terms are null
            if (term != null && definition != null && defDict != null
                    && defCita != null && course != null) {
                request.setAttribute("message", errorMessage);
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            newEntry.setStatus("Under Review");
            //Remove all of the something went wrongs!!!!
            if (ds.insert(newEntry) == 1) {
                errorMessage = "Your term is now pending review!";
            } else {
                errorMessage = "Something went wrong with the term Entry";
            }
            request.setAttribute("message", errorMessage);

        } else if (action.equals("Save Term") == true) {
            newEntry.setStatus("In Progress");
            if (ds.insert(newEntry) == 1) {
                errorMessage = "Your term is now saved!";
            }
        }
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
