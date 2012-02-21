

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import javax.swing.JPanel;
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
        Dealer dealer = new Dealer("", 5,new Player("", 111));
        
        dealer.hit(new Card("ACe", "Spades", 11));
        dealer.hit(new Card("ACe", "Spades", 11));
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

    /**
     * Test of getHand method, of class Dealer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        Dealer instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCards method, of class Dealer.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Dealer instance = null;
        JPanel expResult = null;
        JPanel result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHard17 method, of class Dealer.
     */
    @Test
    public void testIsHard17() {
        System.out.println("isHard17");
        Dealer instance = null;
        boolean expResult = false;
        boolean result = instance.isHard17();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
