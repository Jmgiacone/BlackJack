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
        assertEquals(expResult, result);
    }

    /**
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = new Card("King", "Spades", 10, true);
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
        instance.addCard(new Card("King", "Hearts", 10, true));
        instance.addCard((new Card("Ace", "Clubs", 11, true)));
        assertEquals(21, instance.getValue());
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
        
        instance.addCard(new Card("King", "Hearts", 10, true));
        instance.addCard((new Card("Ace", "Clubs", 11, true)));
        assertEquals(false, instance.isBust());
    }
}
