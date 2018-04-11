package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.Privilege;
import business.domainClasses.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 * The PrivilegeBroker provide connectivity to the database and allow insertion,
 * retrieval and removal of Privilege from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class PrivilegeBroker extends Broker {

    /**
     * The getByID method gets the privilege with the privilege ID.
     *
     * @param privilegeID represents the ID of the privilege.
     * @return a Privilege object with the specified ID.
     */
    public Privilege getByID(Integer privilegeID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        //  ArrayList<Definition> delist = new ArrayList<>();
        Privilege privilege = null;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[role] "
                + "where privilege_id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setInt(1, privilegeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                privilege = new Privilege();
                privilege.setPrivilegeID(privilegeID);
                privilege.setDescription(rs.getString("description"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return privilege;

    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        //  ArrayList<Definition> delist = new ArrayList<>();
        Privilege privilege = (Privilege) object;
        int affectRows = 0;

        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[role] (description)"
                + "VALUSE (?) ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, privilege.getDescription());
            affectRows = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return affectRows == 0 ? 0 : 1;
        //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        //  ArrayList<Definition> delist = new ArrayList<>();
        Privilege privilege = (Privilege) object;
        int affectRows = 0;

        String selectSQL = "UPDATE [GlossaryDataBase].[dbo].[role] "
                + "SET description = ? "
                + "WHERE privilege_id = ? ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, privilege.getDescription());
            ps.setInt(2, privilege.getPrivilegeID());
            affectRows = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return affectRows == 0 ? 0 : 1;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        //  ArrayList<Definition> delist = new ArrayList<>();
        List<Object> privilegelist = new ArrayList<>();

        Privilege privilege = null;

        String selectSQL = "SELECT * "
                + "from [GlossaryDataBase].[dbo].[role] ";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);

            rs = ps.executeQuery();
            while (rs.next()) {
                privilege = new Privilege();
                privilege.setPrivilegeID(rs.getInt("privilege_id"));
                privilege.setDescription(rs.getString("description"));

                privilegelist.add(privilege);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DefinitionBroker.class.getName()).log(Level.SEVERE, "Fail to read definition", ex);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
            }
            pool.freeConnection(connection);
        }
        return privilegelist;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
