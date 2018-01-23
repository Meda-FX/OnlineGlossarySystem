/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.sql.DataSource;
import java.sql.*;

/**
 *
 * @author 729347
 */
public class ConnectionPool {
    private static ConnectionPool pool;
    private static DataSource source;
    
    /**
     * The getInstance method creates an connection instance using JDBC
     * @return ConnectionPool the 'pool' of connections made available
     */
    public ConnectionPool getInstance() {
        return null;
    }
    
    /**
     * The getConnection method creates a connection between the application
     * and the DataSource
     * @return connection represents the built in java.sql package
     */
    public Connection getConnection() {
        return null;
    }
    
    /**
     * The freeConnection method puts a stop to the connection
     * @param c represents an a variable of type connection
     */
    public void freeConnection(Connection c) {
       
    }
}
