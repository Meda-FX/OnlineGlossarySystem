package persistence.brokers;

import business.domainClasses.AccountRequest;
import business.domainClasses.User;
import java.util.List;
import persistence.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AccountRequestBroker provide connectivity to the database and allow
 * insertion, retrieval and removal of AccountRequest from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class AccountRequestBroker extends Broker {

    /**
     * The getRequest method get the AccountRequest with it ID
     *
     * @param id represents the ID of a the AccountRequest
     * @return a AccountRequest object with the specified ID.
     */
    public AccountRequest getRequest(String id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT * "
                            + "FROM [GlossaryDataBase].[dbo].[account_request] "
                            + "WHERE [GlossaryDataBase].[dbo].[account_request].request_id = ? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        AccountRequest accountRequest = null;

        int requestType;
        java.util.Date requestDate = null;
        String salt = null;
        String requestBy = null;
        User user = new User();
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                requestType = rs.getInt("request_type");
                requestDate = new java.util.Date(rs.getTimestamp("request_date").getTime());
                salt = rs.getString("salt");
                requestBy = rs.getString("request_by");

                accountRequest.setRequestDate(requestDate);
                accountRequest.setRequestID(id);
                accountRequest.setRequestType(requestType);
                //the user is not fully construct but only hold its id to avoid 
                //large amount of reading from database
                user.setID(requestBy);
                accountRequest.setRequestdBy(user);
                accountRequest.setSalt(salt);
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot read account requests", e);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return accountRequest;
    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        AccountRequest accountRequest = (AccountRequest)object;
        String insertSQL = "INSERT INTO [GlossaryDataBase].[dbo].[account_request] "
                            + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(insertSQL);
            ps.setString(1, accountRequest.getRequestID());
            ps.setTimestamp(2, new Timestamp(accountRequest.getRequestDate().getTime()));
            ps.setString(3, accountRequest.getSalt());
            
            //this method should not involve inserting new user, codes if calling this method should
            //also ensure the user already exist. 
            ps.setString(4, accountRequest.getRequestdBy().getID());
            ps.setInt(5, accountRequest.getRequestType());
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot insert AccountRequest", ex);
            
        } finally {
            try {
               if(ps != null) ps.close();
            } catch (SQLException ex){
                
            }
            pool.freeConnection(connection);
        }
        return 0;
    }

    @Override
    public int delete(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        AccountRequest accountRequest = (AccountRequest)object;
        String deleteSQL = "DELETE FROM [GlossaryDataBase].[dbo].[account_request] "
                            + "WHERE request_id = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(deleteSQL);
            
            ps.setString(1, accountRequest.getRequestID());
            
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot insert AccountRequest", ex);
            
        } finally {
            try {
               if(ps != null) ps.close();
            } catch (SQLException ex){
                
            }
            pool.freeConnection(connection);
        }
        return 0;
    }

    @Override
    public int update(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        AccountRequest accountRequest = (AccountRequest)object;
        String updateSQL = "UPDATE [GlossaryDataBase].[dbo].[account_request] "
                            + "SET request_date = ?, "
                            + "SET salt = ?, "
                            + "SET request_by = ?, "
                            + "SET request_type = ?, "
                            + "WHERE request_id = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(updateSQL);
            ps.setTimestamp(1, new Timestamp(accountRequest.getRequestDate().getTime()));
            ps.setString(2, accountRequest.getSalt());
            
            //this method should not involve inserting new user, codes if calling this method should
            //also ensure the user already exist.
            ps.setString(3, accountRequest.getRequestdBy().getID());
            ps.setInt(4, accountRequest.getRequestType());
            ps.setString(5, accountRequest.getRequestID());
            
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot insert AccountRequest", ex);
            
        } finally {
            try {
               if(ps != null) ps.close();
            } catch (SQLException ex){
                
            }
            pool.freeConnection(connection);
        }
        return 0;
    }

    @Override
    public List<Object> getAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT * "
                            + "FROM [GlossaryDataBase].[dbo].[account_request]";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Object> accountRequestList = new ArrayList<Object>();
        AccountRequest accountRequest = null;

        String requestID = null;
        int requestType;
        java.util.Date requestDate = null;
        String salt = null;
        String requestBy = null;
        User user = new User();
        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                requestID = rs.getString("request_id");
                requestType = rs.getInt("request_type");
                requestDate = new java.util.Date(rs.getTimestamp("request_date").getTime());
                salt = rs.getString("salt");
                requestBy = rs.getString("request_by");

                accountRequest.setRequestDate(requestDate);
                accountRequest.setRequestID(requestID);
                accountRequest.setRequestType(requestType);
                //the user is not fully construct but only hold its id to avoid 
                //large amount of reading from database
                user.setID(requestBy);
                accountRequest.setRequestdBy(user);
                accountRequest.setSalt(salt);
                accountRequestList.add(accountRequest);
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot read account requests", e);
        } finally {
            try {
               if(rs != null) rs.close();
               if(ps != null) ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return accountRequestList;
    }

    public List<AccountRequest> getToVerify(int requestType) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String selectSQL = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[account_request] "
                + "WHERE [GlossaryDataBase].[dbo].[account_request].request_type = ? "
                + "AND DATEDIFF(hour, [GlossaryDataBase].[dbo].[account_request].request_date, GETDATE()) < 72";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<AccountRequest> accountRequestList = new ArrayList<AccountRequest>();
        AccountRequest accountRequest = null;

        String requestID = null;
        java.util.Date requestDate = null;
        String salt = null;
        String requestBy = null;
        User user = new User();
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, requestType);
            rs = ps.executeQuery();
            while (rs.next()) {
                requestID = rs.getString("request_id");
                requestDate = new java.util.Date(rs.getTimestamp("request_date").getTime());
                salt = rs.getString("salt");
                requestBy = rs.getString("request_by");
                accountRequest = new AccountRequest();
                accountRequest.setRequestDate(requestDate);
                accountRequest.setRequestID(requestID);
                accountRequest.setRequestType(requestType);
                //the user is not fully construct but only hold its id to avoid 
                //large amount of reading from database
                user.setID(requestBy);
                accountRequest.setRequestdBy(user);
                accountRequest.setSalt(salt);
                accountRequestList.add(accountRequest);
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot read account requests", e);
        } finally {
            try {
               if(rs != null) rs.close();
               if(ps != null) ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return accountRequestList;
    }
/**
 * removeOldRequest method used to remove unnecessary request by id and type
 * 
 * @param id represents the id of a request
 * @param requestType represents the type of a request
 * @return if remove successfully, return 1. else return 0
 */
    public int removeOldRequest(String id, int requestType) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String deleteSQL = "DELETE FROM [GlossaryDataBase].[dbo].[account_request] "
                            + "WHERE request_by = ? "
                            + "AND request_type = ?";
        PreparedStatement ps = null;
        
        try {
            ps = connection.prepareStatement(deleteSQL);
            
            ps.setString(1, id);
            ps.setInt(2, requestType);
            int result = ps.executeUpdate();
            if (result >0)
                return 1;
        } catch (SQLException ex) {
            Logger.getLogger(AccountRequestBroker.class.getName()).log(Level.SEVERE, "Cannot insert AccountRequest", ex);
            
        } finally {
            try {
                ps.close();
            } catch (SQLException ex){
                
            }
            pool.freeConnection(connection);
        }
        return 0;
    }
}
