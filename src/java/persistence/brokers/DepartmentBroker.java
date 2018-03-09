package persistence.brokers;

import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.Department;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 * The DepartmentBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Department from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class DepartmentBroker extends Broker{

    /**
     * The getByID method gets the department with the ID of a department.
     *
     * @param departmentID represents the ID of a department.
     * @return a Department object from the Department database.
     */
    public Department getByID(int departmentID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT "
                + " [GlossaryDataBase].[dbo].[department].department_id, "
                + " [GlossaryDataBase].[dbo].[department].name"
                + " FROM [GlossaryDataBase].[dbo].[department]"
                + " WHERE [GlossaryDataBase].[dbo].[department].department_id = ?";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Department dept = null;
        int dept_ID = 0;
        String dept_NAME = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, departmentID);
            rs = ps.executeQuery();
            while (rs.next()) {
                dept_ID = rs.getInt("department_id");
                dept_NAME = rs.getString("name");
            }
            
            dept = new Department(dept_ID, dept_NAME);
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return dept;
    }

    @Override
    public int insert(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
