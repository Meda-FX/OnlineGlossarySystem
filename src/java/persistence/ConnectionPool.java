/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.sql.DataSource;
import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * ConnectionPool class is a singular connection that allow simultaneous
 * connections to the database 
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.1
 */
public class ConnectionPool {
    private static ConnectionPool pool;
    private static DataSource source;
    
    /**
    * construct a ConnectionPool object to be used for database connectivity
    */
    private ConnectionPool() {
    }
    
    
    /**
     * The getInstance method return a singular connection pool to the database
     * @return the connection pool returned
     */
    public ConnectionPool getInstance() {
        return null;
    }
    
    /**
     * The getConnection method creates a connection to the database
     * @return the connection returned
     */
    public Connection getConnection() {
        return null;
    }
    
    /**
     * The freeConnection method stop the connection and free up the resource
     * @param c the connection to be stopped
     */
    public void freeConnection(Connection c) {
       
    }
}
