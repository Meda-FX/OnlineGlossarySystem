package persistence.brokers;

import business.domainClasses.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 * The UserBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of User from the database
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class UserBroker extends Broker{

    /**
     * The getByEmail method returns the user with the specified email
     *
     * @param email represents the email of an account in the user table of the
     * database.
     * @return a User object with the specified email.
     */
    public User getByEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[user] WHERE [GlossaryDataBase].[dbo].[user].email = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String compareName = "";
        User user = null;
        
        String user_id = null;
	String password = null;
	int department_id = 0;
	String name = null;
	String userEmail = null;
	int activated = 0;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new User();
                user_id = (rs.getString("user_id"));
                password = (rs.getString("password"));
                department_id = (rs.getInt("department_id"));
                name = (rs.getString("name"));
                userEmail = (rs.getString("email"));
                activated = (rs.getInt("activated"));
                
                
//                if(!compareName.equals(username)) {
//                        return user;
//                }
                user.setID(user_id);
                user.setPassword(password);
                //user.setDepartment("1");
                user.setName(name);
                user.setEmail(email);
                //user.
            }
        
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
        
        return user;
    }
    
    /**
     * The getByName method returns the user by their name
     * @param name represents the name of the user
     * @return a User list
     */
    public List<User> getByName(String name) {
        return null;
    }

    /**
     * The getByID method returns a user based on their ID.
     *
     * @param ID represents the ID of an account in the user table of the
     * database.
     * @return a User object with a specified users ID.
     */
    public User getByID(String ID) {
        return null;
    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        User user = (User)object;
        
        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[user] (user_id, password, department_id, name, email, activated) VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ps.setInt(3, '1');
            ps.setString(4, user.getName());
            ps.setString(5, user.getEmail());
            ps.setInt(6, '1');
            rs = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
            return 0;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        
        return 1;        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
