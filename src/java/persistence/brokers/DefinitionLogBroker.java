/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.brokers;

import business.domainClasses.DefinitionLog;
import business.domainClasses.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 *
 * @author 727153
 */
public class DefinitionLogBroker extends Broker {

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        DefinitionLog definitionLog = (DefinitionLog)object;
        String insertSQL = "INSERT INTO [GlossaryDataBase].[dbo].[definition_log] "
                + "(activity_by, activity_date, activity_type) "
                + "VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setString(1, definitionLog.getActivityBy().getID());
            ps.setTimestamp(2, new Timestamp(definitionLog.getActivityDate().getTime()));
            ps.setInt(3, definitionLog.getActivityType());
            
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionLogBroker.class.getName()).log(Level.SEVERE, "Cannot insert DefinitionLog", ex);
            
        } finally {
            try {
                ps.close();
            } catch (SQLException ex){
                
            }
            pool.freeConnection(connection);
        }
        return 0;
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

    public List<DefinitionLog> getByDatesAndType(Date start, Date end, int type) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[definition_log] "
                + "WHERE [GlossaryDataBase].[dbo].[definition_log].activity_type = ? "
                + "AND [GlossaryDataBase].[dbo].[definition_log].activity_date >= ? "
                + "AND [GlossaryDataBase].[dbo].[definition_log].activity_date <= ? + 1 day";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Timestamp startStamp = new Timestamp(start.getTime());
        Timestamp endStamp = new Timestamp(end.getTime());
        ArrayList<DefinitionLog> definitionLogList = new ArrayList<DefinitionLog>();
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, type);
            ps.setTimestamp(2, startStamp);
            ps.setTimestamp(3, endStamp);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                int logID = rs.getInt("log_id");
                String activityBy = rs.getString("activity_by");
                User user = new User();
                user.setID(activityBy);
                Date activityDate = new Date(rs.getTimestamp("activity_date").getTime());
                DefinitionLog definitionLog = new DefinitionLog(logID, type, user, activityDate);
                definitionLogList.add(definitionLog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DefinitionLogBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return definitionLogList;
    }
    
}
