

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
public class DealerTest {
    
    public DealerTest() {
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
     * Test of isAt17 method, of class Dealer.
     */
    @Test
    public void testIsAt17() {
        System.out.println("isAt17");
        Dealer instance = new Dealer("Dealer", 5, new Player("", 100));
        
        instance.hit(new Card("King", "jkl", 10));
        instance.hit(new Card("Ace", "jkl", 11));
        
        assertTrue(instance.isAt17());
        
        for(int i = 0; i < 5; i++)
        {
            instance.hit(new Card("Ace", "jkl", 11));
            assertFalse(instance.isAt17());
        }
    }

    /**
     * Test of draw method, of class Dealer.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Dealer instance = new Dealer("jkl", 5, new Player("", 1000));
        Card c = instance.draw();
        
        assertTrue(instance.getShoe().get((52 * 5) - 1).equals(c));
        
        
    }

    /**
     * Test of start method, of class Dealer.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Dealer instance = new Dealer("Name", 5, new Player("Jordan", 1000));
        instance.start();
    }

    /**
     * Test of getShoe method, of class Dealer.
     */
    @Test
    public void testGetShoe() {
        System.out.println("getShoe");
        Dealer instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getShoe();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hit method, of class Dealer.
     */
    @Test
    public void testHit() {
        System.out.println("hit");
        Card c = null;
        Dealer instance = null;
        instance.hit(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playerHand method, of class Dealer.
     */
    @Test
    public void testPlayerHand() {
        System.out.println("playerHand");
        Dealer instance = null;
        instance.playerHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dealerHand method, of class Dealer.
     */
    @Test
    public void testDealerHand() {
        System.out.println("dealerHand");
        Dealer instance = null;
        instance.dealerHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDone method, of class Dealer.
     */
    @Test
    public void testIsDone() {
        System.out.println("isDone");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.isDone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCards method, of class Dealer.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        Dealer instance = new Dealer("", 5, new Player("", 1000));
        instance.setCards();
    }

    /**
     * Test of results method, of class Dealer.
     */
    @Test
    public void testResults() {
        System.out.println("results");
        Dealer instance = null;
        instance.results();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanUp method, of class Dealer.
     */
    @Test
    public void testCleanUp() {
        System.out.println("cleanUp");
        Dealer instance = null;
        instance.cleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of askInsurance method, of class Dealer.
     */
    @Test
    public void testAskInsurance() {
        System.out.println("askInsurance");
        Dealer instance = null;
        instance.askInsurance();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAceShowing method, of class Dealer.
     */
    @Test
    public void testHasAceShowing() {
        System.out.println("hasAceShowing");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.hasAceShowing();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasSoftAce method, of class Dealer.
     */
    @Test
    public void testHasSoftAce() {
        System.out.println("hasSoftAce");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.hasSoftAce();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBelowHard17 method, of class Dealer.
     */
    @Test
    public void testIsBelowHard17() {
        System.out.println("isBelowHard17");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.isBelowHard17();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reDoCards method, of class Dealer.
     */
    @Test
    public void testReDoCards() {
        System.out.println("reDoCards");
        Dealer instance = null;
        instance.reDoCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of upCardIsAce method, of class Dealer.
     */
    @Test
    public void testUpCardIsAce() {
        System.out.println("upCardIsAce");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.upCardIsAce();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
