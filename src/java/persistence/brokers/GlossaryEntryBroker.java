package persistence.brokers;

import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
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

        GlossaryEntry ge = (GlossaryEntry) object;
//        boolean check = true;

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
        //ResultSet rs = null;

        try {
            //ps = connection.prepareStatement(selectSQL);
            //rs = ps.executeQuery();

            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, ge.getTerm());
            ps.setTimestamp(2, new Timestamp(ge.getDateCreated().getTime()));
            ps.setString(3, ge.getCreatedBy().getName());
            int result = ps.executeUpdate();
            if (result > 0) {
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot insert users", ex);

        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return 0;
        //return 1;
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

//        try{ 
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
//        } finally {
//            try {
//                rs.close();
//                ps.close();
//            } catch (SQLException ex) {
//            }
//            pool.freeConnection(connection);
//        }
//        
//        
//        return (List<Object>) list;
        return null;
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
        ArrayList<GlossaryEntry> terms = new ArrayList<GlossaryEntry>();
        GlossaryEntry ge = null;
        Definition definition;
        //ArrayList<Definition> definitionlist= new ArrayList<>();

        String username = null;
        String glossaryTerm = "";
        String content = null;
        int definition_id;
        String citation;
        String user_id;
        User user;
        java.util.Date definitionDateCreated;
        Timestamp definitionDateCreatedDB;
        String dictionaryContent;
        String dictionaryCitation;
        String definitionStatus;
        String comparedTerm = "";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, searchPattern);
            rs = ps.executeQuery();
            DefinitionList definitionList = null;
            while (rs.next()) {
                glossaryTerm = rs.getString("glossary_entry");
                if (!comparedTerm.equals(glossaryTerm)) {
                    if (!comparedTerm.equals("")) {
                        terms.add(ge);
                    }
                    comparedTerm = glossaryTerm;
                    ge = new GlossaryEntry();
                    ge.setTerm(glossaryTerm);
                    definitionList = ge.getDefinitionList();
                }
                definition = new Definition();
                content = rs.getString("definition");
                citation = rs.getString("citation");
                user = new User();
                username = rs.getString("name");
                user_id = rs.getString("user_id");

                user.setID(user_id);
                user.setName(username);
                definitionDateCreatedDB = rs.getTimestamp("date_created");
                definitionDateCreated = new java.util.Date(definitionDateCreatedDB.getTime());

                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                definitionStatus = rs.getString("status");
                definition.setDictionaryContent(dictionaryContent);
                definition.setDictionaryCitation(dictionaryCitation);
                definition.setCitation(citation);
                definition.setContent(content);
                definition.setTerm(glossaryTerm);
                definition.setWrittenBy(user);
                definition.setDateCreated(definitionDateCreated);
                definition.setStatus(definitionStatus);
                definitionList.add(definition);
            }
            if (ge != null) {
                terms.add(ge);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return terms;
    }

    public List<GlossaryEntry> getByUser(String userID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectQuery = "SELECT * "
                + "FROM [GlossaryDataBase].[dbo].[glossary_entry] "
                + "JOIN [GlossaryDataBase].[dbo].[definition] "
                + "ON ([GlossaryDataBase].[dbo].[definition].glossary_entry=[GlossaryDataBase].[dbo].[glossary_entry].glossary_entry) "
                + "WHERE [GlossaryDataBase].[dbo].[definition].made_by = ?;";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<GlossaryEntry> terms = new ArrayList<GlossaryEntry>();
        GlossaryEntry ge = null;
        Definition definition;

        String glossaryTerm = "";
        String content = null;
        int definition_id;
        String citation;
        String dictionaryContent;
        String dictionaryCitation;
        String definitionStatus;
        User user;

        String comparedTerm = "";

        try {
            ps = connection.prepareStatement(selectQuery);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            DefinitionList definitionList = null;
            while (rs.next()) {
                glossaryTerm = rs.getString("glossary_entry");
                ge = new GlossaryEntry();
                ge.setTerm(glossaryTerm);
                definitionList = ge.getDefinitionList();

                definition = new Definition();
                content = rs.getString("definition");
                citation = rs.getString("citation");
                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                definitionStatus = rs.getString("status");
                user = new User();
                user.setID(userID);

                definition.setCitation(citation);
                definition.setContent(content);
                definition.setDictionaryContent(dictionaryContent);
                definition.setDictionaryCitation(dictionaryCitation);
                definition.setStatus(definitionStatus);
                definition.setTerm(glossaryTerm);
                definition.setWrittenBy(user);
                definitionList.add(definition);
            }
            if (ge != null) {
                terms.add(ge);
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
        return terms;
    }

    public ArrayList<GlossaryEntry> getByAlpha(String letter) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String searchPattern = (letter + "%").toUpperCase();
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
        ArrayList<GlossaryEntry> terms = new ArrayList<GlossaryEntry>();
        GlossaryEntry ge = null;
        Definition definition;
        //ArrayList<Definition> definitionlist= new ArrayList<>();

        String username = null;
        String glossaryTerm ="";
        String content = null;
        int definition_id;
        String citation;
        String user_id;
        User user;
        java.util.Date definitionDateCreated;
        Timestamp definitionDateCreatedDB;
        String dictionaryContent;
        String dictionaryCitation;
        String definitionStatus;
        String comparedTerm = "";

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, searchPattern);
            rs = ps.executeQuery();
            DefinitionList definitionList = null;
            while (rs.next()) {
                glossaryTerm = rs.getString("glossary_entry");
                if (!comparedTerm.equals(glossaryTerm)) {
                    if (!comparedTerm.equals("")) {
                        terms.add(ge);
                    }
                    comparedTerm = glossaryTerm;
                    ge = new GlossaryEntry();
                    ge.setTerm(glossaryTerm);
                    definitionList = ge.getDefinitionList();
                }
                definition = new Definition();
                content = rs.getString("definition");
                citation = rs.getString("citation");
                user = new User();
                username = rs.getString("name");
                user_id = rs.getString("user_id");

                user.setID(user_id);
                user.setName(username);
                definitionDateCreatedDB = rs.getTimestamp("date_created");
                definitionDateCreated = new java.util.Date(definitionDateCreatedDB.getTime());

                dictionaryContent = rs.getString("dictionary_definition");
                dictionaryCitation = rs.getString("dictionary_citation");
                definitionStatus = rs.getString("status");
                definition.setDictionaryContent(dictionaryContent);
                definition.setDictionaryCitation(dictionaryCitation);
                definition.setCitation(citation);
                definition.setContent(content);
                definition.setTerm(glossaryTerm);
                definition.setWrittenBy(user);
                definition.setDateCreated(definitionDateCreated);
                definition.setStatus(definitionStatus);
                definitionList.add(definition);
            }
            if (ge != null) {
                terms.add(ge);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GlossaryEntryBroker.class.getName()).log(Level.SEVERE, "Cannot read users", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
        return terms;
    }
}
