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
        Person instance = new Person("Jordan");
        assertEquals("Jordan", instance.getName());
    }

    

    

    

    /**
     * Test of getHandValue method, of class Person.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        Person instance = new Person("Jordan");
        
        instance.addCard(new Card("ACe", "Spades", 11));
        instance.addCard(new Card("ten", "spades", 10));
        assertEquals(21, instance.getHandValue());
    }

    /**
     * Test of isBust method, of class Person.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        Person instance = new Person("jordan");
        
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card("jkl", "kjl", 10));
        }
        assertTrue(instance.isBust());
    }

    /**
     * Test of addCard method, of class Person.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = new Card("jkl", "kjl", 10);
        Person instance = new Person("Jordan");
        instance.addCard(c);
        
        assertTrue(instance.getHandValue() == 10);
    }

    /**
     * Test of getNumCards method, of class Person.
     */
    @Test
    public void testGetNumCards() {
        System.out.println("getNumCards");
        Person instance = new Person("Jordan");
        instance.addCard(new Card("jkl", "kjl", 10));
        int expResult = 0;
        int result = instance.getNumCards();
        assertTrue(result == 1);
        
        
    }

    /**
     * Test of hasBlackJack method, of class Person.
     */
    @Test
    public void testHasBlackJack() {
        System.out.println("hasBlackJack");
        Person instance = new Person("JL");
        instance.addCard(new Card("Ace", "kjl", 11));
        instance.addCard(new Card("jkl", "kjl", 10));
        boolean expResult = false;
        boolean result = instance.hasBlackJack();
        assertTrue(result);
    }

    /**
     * Test of hasFiveCardCharlie method, of class Person.
     */
    @Test
    public void testHasFiveCardCharlie() {
        System.out.println("hasFiveCardCharlie");
        Person instance = new Person("");
        boolean expResult = false;
        
        
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card("Ace", "kjl", 11));
        }
        
        boolean result = instance.hasFiveCardCharlie();
        assertTrue(result);
    }

    /**
     * Test of clearHand method, of class Person.
     */
    @Test
    public void testClearHand() {
        System.out.println("clearHand");
        Person instance = new Person("");
        
        instance.addCard(new Card("Ace", "spades", 11));
        instance.clearHand();
        
        assertTrue(instance.getHandValue() == 0);
    }
}
