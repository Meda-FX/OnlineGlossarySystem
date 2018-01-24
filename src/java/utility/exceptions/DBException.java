/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.exceptions;

/**
 * DBException is a database exception to be thrown if
 * connection to the database fails
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class DBException extends Exception {
    /**
     * Create a default DBException
     */
    public DBException(){
        
    }
    
    /**
     * create a DBException with the supplied message
     * @param msg the message to be displayed when exception is thrown
     */
    public DBException(String msg){
        super(msg);
    }
}
