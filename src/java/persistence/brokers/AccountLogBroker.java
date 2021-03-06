/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.brokers;

import business.domainClasses.AccountLog;
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
 * The AccountLogBroker provide connectivity to the database and allow
 * insertion, retrieval and removal of AccountLog from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class AccountLogBroker extends Broker {

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        AccountLog accountLog = (AccountLog)object;
        String insertSQL = "INSERT INTO [GlossaryDataBase].[dbo].[account_log] "
                + "(activity_by, activity_date, activity_type) "
                + "VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setString(1, accountLog.getActivityBy().getID());
            ps.setTimestamp(2, new Timestamp(accountLog.getActivityDate().getTime()));
            ps.setInt(3, accountLog.getActivityType());
            
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountLogBroker.class.getName()).log(Level.SEVERE, "Cannot insert AccountLog", ex);
            
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
/**
 * getByDDT method used to get a list of account log information 
 * by a date period, department and type
 * 
 * @param start represents the date to start
 * @param end represents the date for end
 * @param department represents the department to search
 * @param type represents the type of the log
 * @return a list of account log 
 */
    public List<AccountLog> getByDDT(Date start, Date end,int department, int type) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[account_log] "
                + "JOIN [GlossaryDataBase].[dbo].[user] "
                + "ON ([GlossaryDataBase].[dbo].[account_log].activity_by = [GlossaryDataBase].[dbo].[user].user_id) "
                + "WHERE activity_type = ? "
                + "AND department_id = ? "
                + "AND activity_date >= ? "
                + "AND activity_date <= DATEADD(day, 1, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Timestamp startStamp = new Timestamp(start.getTime());
        Timestamp endStamp = new Timestamp(end.getTime());
        ArrayList<AccountLog> accountLogList = new ArrayList<AccountLog>();
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, type);
            ps.setInt(2, department);
            ps.setTimestamp(3, startStamp);
            ps.setTimestamp(4, endStamp);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                int logID = rs.getInt("log_id");
                String activityBy = rs.getString("activity_by");
                User user = new User();
                user.setID(activityBy);
                Date activityDate = new Date(rs.getTimestamp("activity_date").getTime());
                AccountLog accountLog = new AccountLog(type, user, activityDate);
                accountLogList.add(accountLog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountLogBroker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null)ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return accountLogList;
    }
    
}
