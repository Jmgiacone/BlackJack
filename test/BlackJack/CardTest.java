/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit Testing Class for the Card class.
 * 1/26/12
 * @author Jordan Giacone
 */
public class CardTest {
    
    public CardTest() {
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
     * Test of setAce method, of class Card.
     */
    @Test
    public void testSetAce() {
        System.out.println("setAce");
        boolean toOne = false;
        Card instance = new Card("Ace", "Spades", 11, false);
        instance.setAce(true);
         
        assertTrue(instance.getValue() == 1);
        instance.setAce(false);
        assertFalse(instance.getValue() == 1);
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        Card instance = new Card("Ace", "Spades", 11, false), 
                b = new Card("Jack", "Spades", 10, false);
        assertEquals("Ace", instance.getRank());
        assertNotSame("King", b.getRank());
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new Card("Two", "Spades", 2, false), 
                b = new Card("Five", "Hearts", 5, false);
        String expResult = "";
        String result = instance.getSuit();
        assertEquals("Spades", instance.getSuit());
        assertNotSame("Joker", b.getSuit());
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new Card("Ace", "Hearts", 11, false);
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(11, instance.getValue());
        instance.setAce(true);
        assertEquals(1, instance.getValue());
    }

    /**
     * Test of isAce method, of class Card.
     */
    @Test
    public void testIsAce() {
        System.out.println("isAce");
        Card instance = new Card("Ace", "Spades", 11, false),
                b = new Card("King" , "Hearts", 10, false);
        boolean expResult = false;
        boolean result = instance.isAce();
        assertTrue(instance.isAce());
        assertFalse(b.isAce());
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card("Ace", "Spades", 11, false);
        assertTrue(instance.toString().equalsIgnoreCase("Ace of Spades(11)"));
    }

    /**
     * Test of isVisibile method, of class Card.
     */
    @Test
    public void testIsVisible() {
        System.out.println("isVisible");
        Card instance = new Card();
        assertTrue(instance.isVisible());
        instance.setVisibility(false);
        assertFalse(instance.isVisible());
    }

    /**
     * Test of setVisibility method, of class Card.
     */
    @Test
    public void testSetVisibility() {
        System.out.println("setVisibility");
        Card instance = new Card();
        instance.setVisibility(false);
        assertFalse(instance.isVisible());
    }
}
