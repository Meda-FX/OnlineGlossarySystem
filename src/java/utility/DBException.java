/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author 727153
 */
public class DBException extends Exception {
    public DBException(){
        
    }
    
    public DBException(String msg){
        super(msg);
    }
}
