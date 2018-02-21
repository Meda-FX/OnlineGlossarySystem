package persistence.brokers;

import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
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
     * @return a Glossary Entry object.
     */
    
    public GlossaryEntry getByTerm(String term) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(Object object) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        GlossaryEntry ge = (GlossaryEntry)object;
        boolean check = true;
        
//        String user_id = null;
//        String password = null;
//        int department_id = 0;
//        String name = null;
//        String email = null;
//        int activated = 0;
//        
//        String glossary_entry = null;
//        Date date_added = null;
//        String made_by = null;
//        
//        int definition_uid = 0;
//	  String geGlossary_entry = null;  
//        String definition = null;
//	  Date date_created = null;
//	  String citation = null;
//	  String geMade_by = null;
//	  String course_code = null;
//	  char type = 'x';
                
//        String selectSQL = "SELECT * FROM [GlossaryDataBase].[dbo].[glossary_entry], [GlossaryDataBase].[dbo].[user], [GlossaryDataBase].[dbo].[definition] WHERE [GlossaryDataBase].[dbo].[user].user_id = [GlossaryDataBase].[dbo].[definition].made_by AND [GlossaryDataBase].[dbo].[user].user_id = [GlossaryDataBase].[dbo].[glossary_entry].made_by;";
        
        String selectSQL = "INSERT INTO [GlossaryDataBase].[dbo].[glossary_entry] (glossary_entry, date_added, made_by) VALUES (?,?,?);";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            ps = connection.prepareStatement(selectSQL);
            rs = ps.executeQuery();
            
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, ge.getTerm());
            ps.setDate(2, (java.sql.Date)ge.getDateCreated());
            ps.setString(3, ge.getCreatedBy().getName());
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
    
    public List<GlossaryEntry> getMatched(String term) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String searchPattern = ("%" + term + "%").toUpperCase();
       // String selectSQL = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] where glossary_entry = ?;";
        // String selectSQL2 = "SELECT * from [GlossaryDataBase].[dbo].[glossary_entry] where glossary_entry = ?;";
        String selectSQL = "SELECT * "
                         + "FROM [GlossaryDataBase].[dbo].[glossary_entry] "
                         + "JOIN [GlossaryDataBase].[dbo].[definition] "
                         + "ON ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) "
                         + "JOIN [GlossaryDataBase].[dbo].[user] "
                         + "ON ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) "
                         + "WHERE UPPER([GlossaryDataBase].[dbo].[definition].glossary_entry) LIKE ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

//        String selectSQL2 = "SELECT * from [GlossaryDataBase].[dbo].[definition] join [GlossaryDataBase].[dbo].[user] on ([GlossaryDataBase].[dbo].[definition].made_by=[GlossaryDataBase].[dbo].[user].user_id) where glossary_entry = ?;";
//
//        PreparedStatement ps2 = null;
//        ResultSet rs2 = null;
        
        ArrayList<GlossaryEntry> terms = new ArrayList<>();
        GlossaryEntry ge =null;
        Definition definition;
        //ArrayList<Definition> definitionlist= new ArrayList<>();

        String username = null;
        String glossaryTerm = "";
        Date sqlDate = null;
        String content = null;
        int definition_id;
        String citation;
        String user_id;
        User user;
        
        String comparedTerm="";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, searchPattern);
            rs = ps.executeQuery();
            DefinitionList definitionList=null;
            while (rs.next()) {
                glossaryTerm = (rs.getString("glossary_entry"));
                if(!comparedTerm.equals(glossaryTerm))
                {
                    if(!comparedTerm.equals("")) {terms.add(ge);}
                    comparedTerm=glossaryTerm;
                    ge=new GlossaryEntry();
                    ge.setTerm(glossaryTerm);
                    definitionList = ge.getDefinitionList();
                }
                definition = new Definition();
                content = rs.getString("definition");
                citation = rs.getString("citation");
                user = new User();
                username = rs.getString("name");
                user_id=rs.getString("user_id");
                user.setID(user_id);
                user.setName(username);
                
                definition.setCitation(citation);
                definition.setContent(content);
                definition.setTerm(glossaryTerm);
                definition.setWrittenBy(user);
                definitionList.add(definition);
            }
            terms.add(ge);
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
}
