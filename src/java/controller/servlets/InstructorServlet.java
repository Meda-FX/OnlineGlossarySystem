/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.User;
import business.serviceClasses.GlossaryEntryService;
import java.io.IOException;
import java.io.PrintWriter;
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
        
//        String action = request.getParameter("action");
//        String url = "/WEB-INF/_instructor/instructor.jsp";
//        if(action != null && action.equals("yourterm"))
//        {
//            url = "/WEB-INF/_instructor/instructor_terms.jsp";
//        }
//        getServletContext().getRequestDispatcher(url).forward(request, response);

        HttpSession session = request.getSession();
        GlossaryEntryService ges = new GlossaryEntryService();
        
        User user = (User)session.getAttribute("user");
        ArrayList<GlossaryEntry> termList = ges.

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("newTerm");
        String term = request.getParameter("terms");
        String definition = request.getParameter("definition");
        String citation = request.getParameter("citation");
        String defDict = request.getParameter("defDict");
        String defCita = request.getParameter("defCita");
        GlossaryEntryBroker geb = new GlossaryEntryBroker();
        
        if (action.compareTo("newTerm") == 1) {
            
        } else if (action.compareTo("save") == 1) {
            
        } else if (action.compareTo("cancel") == 1) {

        }

    }
}
