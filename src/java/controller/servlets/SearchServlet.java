/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

import business.domainClasses.GlossaryEntry;
import business.serviceClasses.GlossaryEntryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Receive and response to requests from web client for search page 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        GlossaryEntryService ges = new GlossaryEntryService();
        ArrayList<GlossaryEntry> termlist;
        String url="/WEB-INF/index.jsp";
        
        //get searching key word from field
        if(action!=null && action.equals("searchTerm"))
        {
             url="/WEB-INF/search.jsp";
            String searchedEntry = request.getParameter("searchedEntry");
            //term can't be null or empty
            if(searchedEntry==null || searchedEntry.equals(""))
            {
                //display error message about empty input
                request.setAttribute("emptyInput", true);
            }
            else
            {                
                //TODO 
                //should return a list of entries based on the searching term
                termlist = (ArrayList<GlossaryEntry>) ges.getMatched(searchedEntry);
                if(termlist != null)
                {
                    request.setAttribute("termlist", termlist);
                }
                //return null means no such entries
                else
                {
                    //display message to tell user
                    request.setAttribute("noSuchEntry", true);
                }
            }
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}
