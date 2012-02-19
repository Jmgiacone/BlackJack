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
public class HandTest {
    
    public HandTest() {
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
     * Test of getHand method, of class Hand.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Hand instance = new Hand();
        ArrayList expResult = null;
        ArrayList result = instance.getHand();
        //assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = new Card("King", "Spades", 10);
        Hand instance = new Hand();
        instance.addCard(c);
        
        assertEquals(instance.getHand().get(0), c);
        instance.addCard(new Card());
        assertTrue(instance.getHand().size() == 2);
    }

    /**
     * Test of getValue method, of class Hand.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Hand instance = new Hand();
        int expResult = 0;
        int result = instance.getValue();
        
        instance.addCard(new Card("King", "Hearts", 10));
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card("Ace", "Hearts", 11));
        }
        
        assertEquals(15, instance.getValue());
    }

    /**
     * Test of isBust method, of class Hand.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        Hand instance = new Hand();
        boolean expResult = false;
        boolean result = instance.isBust();
        
        instance.addCard(new Card("King", "Hearts", 10));
        instance.addCard((new Card("Ace", "Clubs", 11)));
        assertFalse(instance.isBust());
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card("Ace", "Hearts", 11));
        }
        assertFalse(instance.isBust());
        instance.addCard(new Card("King", "jkl", 10));
        assertTrue(instance.isBust());
    }

    /**
     * Test of numCards method, of class Hand.
     */
    @Test
    public void testNumCards() {
        System.out.println("numCards");
        Hand instance = new Hand();
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card());
        }
        
        assertEquals(5, instance.numCards());
    }

    /**
     * Test of numAces method, of class Hand.
     */
    @Test
    public void testNumAces() {
        System.out.println("numAces");
        Hand instance = new Hand();
        instance.addCard(new Card("Ace", "Spadse", 11));
        instance.addCard(new Card("Ace", "Spadse", 11));
        instance.addCard(new Card("Ace", "Spadse", 11));
        assertEquals(3, instance.numAces());
    }

    /**
     * Test of is21 method, of class Hand.
     */
    @Test
    public void testIs21() {
        System.out.println("is21");
        Hand instance = new Hand();
        
        instance.addCard(new Card("King", "Hearts", 10));
        instance.addCard((new Card("Ace", "Clubs", 11)));
        
        assertTrue(instance.is21());
        
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card());
        }
        
        instance.addCard((new Card("five", "jkl", 5)));
        
        assertTrue(instance.is21());
    }

    /**
     * Test of isBlackJack method, of class Hand.
     */
    @Test
    public void testIsBlackJack() {
        System.out.println("isBlackJack");
        Hand instance = new Hand();
        
        assertFalse(instance.isBlackJack());
        instance.addCard(new Card("King", "Hearts", 10));
        instance.addCard((new Card("Ace", "Clubs", 11)));
        assertTrue(instance.isBlackJack());
    }

    /**
     * Test of containsAce method, of class Hand.
     */
    @Test
    public void testContainsAce() {
        System.out.println("containsAce");
        Hand instance = new Hand();
        instance.addCard(new Card());
        assertFalse(instance.containsAce());
        instance.addCard(new Card("Ace", "Spadse", 11));
        assertTrue(instance.containsAce());
    }

    /**
     * Test of isFiveCardCharlie method, of class Hand.
     */
    @Test
    public void testIsFiveCardCharlie() {
        System.out.println("isFiveCardCharlie");
        Hand instance = new Hand();
        instance.addCard(new Card("Five", "kjl", 5));
        
        assertFalse(instance.isFiveCardCharlie());
        
        for(int i = 0; i < 5; i++)
        {
            instance.addCard(new Card("two", "jkl", 2));
        }
        boolean result = instance.isFiveCardCharlie();
        assertTrue(result);
    }
}
