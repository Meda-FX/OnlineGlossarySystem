package persistence.brokers;

import business.domainClasses.AccountRequest;
import business.domainClasses.User;
import java.util.List;
import persistence.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        String selectSQL = "SELECT *"
                            + "FROM [GlossaryDataBase].[dbo].[account_request]"
                            + "WHERE [GlossaryDataBase].[dbo].[account_request].request_id = ?";
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

    public List<AccountRequest> getToVerify(int requestType) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String selectSQL = "SELECT *"
                + "FROM [GlossaryDataBase].[dbo].[account_request]"
                + "WHERE [GlossaryDataBase].[dbo].[account_request].[request_type] = ?"
                + "AND DATEDIFF(hour, [GlossaryDataBase].[dbo].[account_request].[request_date], GETDATE()) < 24";
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
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return accountRequestList;
    }
}
