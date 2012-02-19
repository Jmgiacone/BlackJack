/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player("Jordan", 1000);
        assertEquals("Jordan", instance.getName());
        assertNotSame("Svetty", instance.getName());
    }

    /**
     * Test of getHandValue method, of class Player.
     */
    @Test
    public void testGetHandValue() {
        System.out.println("getHandValue");
        Player instance = new Player("Jordan", 1000);
        instance.hit(new Card("Ace", "jkl", 11));
        instance.hit(new Card("King", "jkl", 10));
        
        assertEquals(21, instance.getHandValue());
        instance.hit(new Card("Ace", "jkl", 11));
        assertEquals(12, instance.getHandValue());
    }

    /**
     * Test of isBust method, of class Player.
     */
    @Test
    public void testIsBust() {
        System.out.println("isBust");
        Player instance = new Player("Jordan", 1000);
        
        instance.hit(new Card("Ace", "jkl", 11));
        instance.hit(new Card("King", "jkl", 10));
        instance.hit(new Card("Ace", "jkl", 11));
        
        assertFalse(instance.isBust());
        instance.hit(new Card("King", "jkl", 10));
        assertTrue(instance.isBust());
    }

    /**
     * Test of hit method, of class Player.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Player instance = new Player("jordna", 2000);
        instance.hit(new Card("King", "jkl", 10));
        
        assertTrue(instance.getNumCards() == 1);
    }

    /**
     * Test of getMoney method, of class Player.
     */
    @Test
    public void testGetMoney() {
        System.out.println("getMoney");
        Player instance = new Player("Jordan", 1000);
        assertEquals(1000, instance.getMoney(), 0.0);
    }

    /**
     * Test of addCard method, of class Player.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card c = null;
        Player instance = null;
        instance.addCard(c);
       
        
    }

    /**
     * Test of win method, of class Player.
     */
    @Test
    public void testWin() {
        System.out.println("win");
        boolean blackJack = false;
        Player instance = null;
        instance.win();
       
        
    }

    /**
     * Test of getNumCards method, of class Player.
     */
    @Test
    public void testGetNumCards() {
        System.out.println("getNumCards");
        Player instance = null;
        int expResult = 0;
        int result = instance.getNumCards();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of bet method, of class Player.
     */
    @Test
    public void testBet() {
        System.out.println("bet");
        int b = 0;
        Player instance = null;
        instance.bet(b);
       
        
    }

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Player instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getHand();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of hasBlackJack method, of class Player.
     */
    @Test
    public void testHasBlackJack() {
        System.out.println("hasBlackJack");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.hasBlackJack();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of split method, of class Player.
     */
    @Test
    public void testSplit() {
        System.out.println("split");
        Player instance = null;
       
        
    }

    /**
     * Test of insurance method, of class Player.
     */
    @Test
    public void testInsurance() {
        System.out.println("insurance");
        Player instance = null;
        instance.insurance(5);
       
        
    }

    /**
     * Test of doubleDown method, of class Player.
     */
    @Test
    public void testDoubleDown() {
        System.out.println("doubleDown");
        Player instance = null;
        instance.doubleDown();
       
        
    }

    /**
     * Test of clearHand method, of class Player.
     */
    @Test
    public void testClearHand() {
        System.out.println("clearHand");
        Player instance = null;
        instance.clearHand();
       
        
    }

    /**
     * Test of hasFiveCardCharlie method, of class Player.
     */
    @Test
    public void testHasFiveCardCharlie() {
        System.out.println("hasFiveCardCharlie");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.hasFiveCardCharlie();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
       
        
    }
}
