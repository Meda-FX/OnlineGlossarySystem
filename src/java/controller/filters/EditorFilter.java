package controller.filters;

import business.domainClasses.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Editor filter makes sure that anyone trying to access the page
 * for the editor is validated as being logged in as an Editor.
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1
 */
public class EditorFilter implements Filter {
    
    private FilterConfig filterConfig = null;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
                        // this code executes before the servlet
        // ...
        
        // ensure user is authenticated
        HttpSession session = ((HttpServletRequest)request).getSession();
        User user  = (User) session.getAttribute("user");
      
  
     
        if (user != null && user.getPrivileges().contains(3)==true) {
            // yes, go onwards to the servlet or next filter
            chain.doFilter(request, response);
        } else {
            // get out of here!
            ((HttpServletResponse)response).sendRedirect("search");
        }
        
       // this code executes after the servlet
       // ...
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
}