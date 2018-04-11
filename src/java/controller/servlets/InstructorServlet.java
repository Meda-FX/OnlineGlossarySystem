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
import java.util.ArrayList;
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
        
//      List<Course> courseList = cs.getByUser(user);
//       
//      request.setAttribute("courseList", courseList);
        String action = request.getParameter("action");
        
        String errorMessage = "";

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
        if (action != null && action.equals("search")) {
            String searchedEntry = request.getParameter("searchedEntry");
            if(searchedEntry== null ||searchedEntry.trim().isEmpty()) errorMessage="Need contents to search!";
            else
            {
                ArrayList<Definition> temptermList = new ArrayList<>();
                searchedEntry = searchedEntry.trim();
                for(Definition d: termList)
                {
                    if(d.getTerm().contains(searchedEntry)) temptermList.add(d);
                }
                termList = temptermList;
                if(termList.isEmpty()) errorMessage="No matched terms!";
                request.setAttribute("searchedEntry", searchedEntry);
            } 
        }
        request.setAttribute("message", errorMessage);
        request.setAttribute("definitionlist", termList);
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int result = 0;
        String url = "/WEB-INF/_instructor/instructor.jsp";
        String action = request.getParameter("submitButton");
        String term = request.getParameter("term");
        String definition = request.getParameter("definition");
        String citation = request.getParameter("citation");
        String defDict = request.getParameter("defDefinition");
        String defCita = request.getParameter("dicCitation");
        String courseCode = request.getParameter("courseCode");
        String defId = request.getParameter("defId");
        String errorMessage = "The following fields are blank / invalid";
        //       String submitButton = request.getParameter("submitButton");
        Timestamp date = new Timestamp(new Date().getTime());

        GlossaryEntryService ges = new GlossaryEntryService();
        DefinitionService ds = new DefinitionService();
        CourseService cs = new CourseService();

        Course newCourse = cs.get(courseCode);
        Definition newEntry = new Definition();
        User user = (User) session.getAttribute("user");
        GlossaryEntry ge = new GlossaryEntry();

        List<Definition> termList = ds.getByMadeBy(user);

        // request.setAttribute("definitionlist", termList);
        // request.setAttribute("message", errorMessage);
        if (action != null && action.equals("Delete")) {
            Definition deleteDefinition = new Definition();
            deleteDefinition.setDefinitionID(Integer.parseInt(defId));
            //ds.getByID(Integer.parseInt(request.getParameter("defId")));
            result = ds.delete(deleteDefinition);
            
            errorMessage = "Your term has been delete!";
            //getServletContext().getRequestDispatcher(url).forward(request, response);
            doGet(request, response);
            return;
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
        if (courseCode.equalsIgnoreCase("") == true) {
            errorMessage += " course";
        }
        if (term.isEmpty() == true
                || definition.isEmpty() == true || defDict.isEmpty() == true
                || defCita.isEmpty() == true || courseCode.equalsIgnoreCase("") == true) {
            request.setAttribute("term", term);
            request.setAttribute("definition", definition);
            request.setAttribute("citation", citation);
            request.setAttribute("defDefinition", defDict);
            request.setAttribute("dicCitation", defCita);
            request.setAttribute("courseCode", courseCode);
            request.setAttribute("defId", defId);

        } else {
            ge.setTerm(term);
            ge.setCreatedBy(user);
            ge.setDateCreated(date);

            //check if term exists. if not, insert it.
            ges.checkTerm(ge);

            newEntry.setCitation(citation);
            newEntry.setContent(definition);
            newEntry.setCourse(newCourse);
            newEntry.setDictionaryContent(defDict);
            newEntry.setDictionaryCitation(defCita);
            newEntry.setTerm(term);
            newEntry.setWrittenBy(user);
            newEntry.setDateLastModified(date);
            if (action != null && action.equalsIgnoreCase("Submit Term")) {
                newEntry.setStatus("Under Review");
                //Remove all of the something went wrongs!!!!
                errorMessage = "Your term is now pending review!";
                if (defId == null || defId.isEmpty()) {
                    result = ds.insert(newEntry);
                } else {
                    newEntry.setDefinitionID(Integer.parseInt(defId));
                    result = ds.update(newEntry);
                }
            }

            //This is checking to see if the term already exists on the 
            //GlossaryEntry table. If it doesn't already exit the program will
            //Create the entry
            if (action != null && action.equals("Save Term") == true) {
                newEntry.setStatus("In Progress");
                errorMessage = "Your term is now saved!";
                if (defId == null || defId.isEmpty()) {
                    result = ds.insert(newEntry);
                } else {
                    newEntry.setDefinitionID(Integer.parseInt(defId));
                    result = ds.update(newEntry);
                }
            }
        }
        
        if (result == 0) {
            errorMessage = "Something went wrong with the term Entry";

        }
                    request.setAttribute("message", errorMessage);
        doGet(request, response);
        // getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
