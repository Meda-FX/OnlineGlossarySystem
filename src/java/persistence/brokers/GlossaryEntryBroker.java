package persistence.brokers;

import business.domainClasses.Definition;
import business.domainClasses.GlossaryEntry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.ConnectionPool;

/**
 * The GlossaryEntryBroker provide connectivity to the database and allow
 * insertion, retrieval and removal of GlossaryEntry from the database
 *
 * @author J. Liang, F. Xiao, M. Neguse, O. McAteer, K. Goertzen
 * @version 0.1.2
 */
public class GlossaryEntryBroker extends Broker {

    /**
     * The getByTerm method shows the results of a search of a specified term.
     *
     * @param term represents the term to be entered into the search for a
     * matching result set.
     * @return a Glossary Request object.
     */
    public List<GlossaryEntry> getByTerm(String term) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] where glossary_entry = ?;";
        // String selectSQL2 = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] where glossary_entry = ?;";

        PreparedStatement ps = null;
        ResultSet rs = null;

        String selectSQL2 = "SELECT * from [GlossaryDataBase].[dbo].[definition] join [GlossaryDataBase].[dbo].[user] on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) where glossary_entry = ?;";

        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        
        ArrayList<GlossaryEntry> terms = new ArrayList<>();
        Definition definition;
        ArrayList<Definition> definitionlist= new ArrayList<>();

        String username = null;
        String glossaryTerm = null;
        Date sqlDate = null;
        String content = null;
        int definition_id;
        String citation;
        int user_id;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, term);
            rs = ps.executeQuery();

            while (rs.next()) {
                glossaryTerm = (rs.getString("glossary_entry"));
                //java.util.Date = new Date(rs.getDate(""));
                //date = (rs.getDate("date_added"));

                // if reuslt is null or not
                ps2 = connection.prepareStatement(selectSQL2);
                ps2.setString(1, glossaryTerm);
                rs2 = ps.executeQuery();
                while (rs2.next()) {
                    //glossaryTerm = rs2.getString("");
                    //sqlDate = new Date(rs2.getDate("date_created"));
                    content = rs2.getString("definition");
                    definition_id = rs2.getInt("definition_uid");
                    citation = rs2.getString("citation");
                    user_id=rs2.getInt("made_by");
                   // definition= new Definition();
                }

            }

            String selectSQL3 = "SELECT * from [GlossaryDataBase].[dbo].[user] where user_id = (SELECT made_by from [GlossaryDataBase].[dbo].[glossary_entry] where made_by = '1234')";

            PreparedStatement ps3 = null;
            ResultSet rs3 = null;
            rs3 = ps.executeQuery();
            ps3 = connection.prepareStatement(selectSQL3);
            while (rs3.next()) {
                username = (rs3.getString("user_id"));
            }

            terms.add(new GlossaryEntry(glossaryTerm, username, date));

            pool.freeConnection(connection);
            return terms;
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
        return terms;
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
