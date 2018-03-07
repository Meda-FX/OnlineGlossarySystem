/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.CourseList;
import business.domainClasses.Department;
import business.domainClasses.Privilege;
import business.domainClasses.PrivilegeList;
import business.domainClasses.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.microsoft.sqlserver.jdbc.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Clock;

/**
 *
 * @author 715583
 */
public class sampleBrokeTest {
     static Connection connection;
    
    public sampleBrokeTest() {
    }
    
    @Before
    public void setUp() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             String connectionUrl = "jdbc:sqlserver://localhost:61501;" +  
   "databaseName=GlossaryDataBase;user=sa;password=password123;"; 
       
        connection = DriverManager.getConnection(connectionUrl);
       
        } catch (SQLException ex) {
             Logger.getLogger(sampleBrokeTest.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(sampleBrokeTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() 
     {
         User user = null;
         String sql = "SELECT * FROM [GlossaryDataBase].[dbo].[user]";
         try {
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next())
             {
                 user = new User();
                 user.setEmail(rs.getString("email"));
                 user.setName(rs.getString("name"));
                 System.out.println("user:"+user.getName()+" email:"+user.getEmail());
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(sampleBrokeTest.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
     }
}
