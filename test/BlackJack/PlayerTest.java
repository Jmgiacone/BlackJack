/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import javax.swing.JPanel;
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

    

    
}
