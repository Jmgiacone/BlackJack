/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class PersonTest {
    
    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split1 method, of class Person.
     */
    @Test
    public void testSplit1() {
        System.out.println("split1");
        Person instance = null;
        instance.split1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrimaryHand method, of class Person.
     */
    @Test
    public void testGetPrimaryHand() {
        System.out.println("getPrimaryHand");
        Person instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getPrimaryHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split2 method, of class Person.
     */
    @Test
    public void testSplit2() {
        System.out.println("split2");
        Person instance = null;
        instance.split2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHandValue method, of class Person.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        Person instance = null;
        int expResult = 0;
        int result = instance.getHandValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBust method, of class Person.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        Person instance = null;
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Person.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Card c = null;
        Person instance = null;
        instance.hit(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCard method, of class Person.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = null;
        Person instance = null;
        instance.addCard(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCards method, of class Person.
     */
    @Test
    public void testGetNumCards() {
        System.out.println("getNumCards");
        Person instance = null;
        int expResult = 0;
        int result = instance.getNumCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasBlackJack method, of class Person.
     */
    @Test
    public void testHasBlackJack() {
        System.out.println("hasBlackJack");
        Person instance = null;
        boolean expResult = false;
        boolean result = instance.hasBlackJack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasFiveCardCharlie method, of class Person.
     */
    @Test
    public void testHasFiveCardCharlie() {
        System.out.println("hasFiveCardCharlie");
        Person instance = null;
        boolean expResult = false;
        boolean result = instance.hasFiveCardCharlie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearHand method, of class Person.
     */
    @Test
    public void testClearHand() {
        System.out.println("clearHand");
        Person instance = null;
        instance.clearHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
