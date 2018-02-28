/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.brokers;

import business.domainClasses.Course;
import business.domainClasses.Definition;
import business.domainClasses.DefinitionList;
import business.domainClasses.GlossaryEntry;
import business.domainClasses.User;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 715583
 */
public class DefinitionBrokerTest {
    
    public DefinitionBrokerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getByID method, of class DefinitionBroker.
     */
    @Test
    public void testGetByID() {
        System.out.println("getByID");
        int did = 1;
        DefinitionBroker instance = new DefinitionBroker();
       // Definition expResult = null;
        Definition result = instance.getByID(did);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        if(result!=null)
        {
            System.out.println("defnition:"+result.toString());
            assertTrue(true);
        }
        else
        {
            assertTrue(false);
        }
    }

    /**
     * Test of getByCourse method, of class DefinitionBroker.
     */
    @Test
    public void testGetByCourse() {
        System.out.println("getByCourse");
        Course course = null;
        DefinitionBroker instance = new DefinitionBroker();
        List<Definition> expResult = null;
        List<Definition> result = instance.getByCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByUser method, of class DefinitionBroker.
     */
    @Test
    public void testGetByUser() {
        System.out.println("getByUser");
        User user = null;
        DefinitionBroker instance = new DefinitionBroker();
        List<Definition> expResult = null;
        List<Definition> result = instance.getByUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByGlossaryEntry method, of class DefinitionBroker.
     */
    @Test
    public void testGetByGlossaryEntry() {
        System.out.println("getByGlossaryEntry");
        GlossaryEntry glossary = null;
        DefinitionBroker instance = new DefinitionBroker();
        DefinitionList expResult = null;
        DefinitionList result = instance.getByGlossaryEntry(glossary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DefinitionBroker.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Object object = null;
        DefinitionBroker instance = new DefinitionBroker();
        int expResult = 0;
        int result = instance.delete(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DefinitionBroker.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object object = null;
        DefinitionBroker instance = new DefinitionBroker();
        int expResult = 0;
        int result = instance.update(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class DefinitionBroker.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        DefinitionBroker instance = new DefinitionBroker();
        List<Object> expResult = null;
        List<Object> result = instance.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class DefinitionBroker.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Object object = null;
        DefinitionBroker instance = new DefinitionBroker();
        int expResult = 0;
        int result = instance.insert(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
