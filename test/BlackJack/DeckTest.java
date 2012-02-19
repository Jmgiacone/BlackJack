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
public class DeckTest {
    
    public DeckTest() {
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
     * Test of toString method, of class Deck.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Deck instance = new Deck();
        String expResult = "Incorrect toString";
        String result = instance.toString();
        System.out.append(result);
        assertNotSame(expResult, result);
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        Deck instance = new Deck();
        Deck old = new Deck(instance);
        instance.shuffle();
        assertNotSame(instance.getDeck().get(0), old.getDeck().get(0));
        assertNotSame(instance.getDeck().get(6), old.getDeck().get(6));
        assertNotSame(instance.getDeck().get(51), old.getDeck().get(51));
        assertNotSame(instance.getDeck().get(22), old.getDeck().get(22));
        assertNotSame(instance.getDeck().get(46), old.getDeck().get(46));
    }

    /**
     * Test of getDeck method, of class Deck.
     */
    @Test
    public void testGetDeck() {
        System.out.println("getDeck");
        Deck instance = new Deck();
        ArrayList expResult = null;
        ArrayList result = instance.getDeck();
        assertEquals(52, result.size());
        assertEquals(result.get(50).toString(), 
                new Deck().getDeck().get(50).toString());
    }

    /**
     * Test of getCard method, of class Deck.
     */
    @Test
    public void testGetCard_int() {
        System.out.println("getCard");
        int index = 0;
        Deck instance = new Deck();
        Card expResult = null;
        Card result = instance.getCard(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCard method, of class Deck.
     */
    @Test
    public void testGetCard_0args() {
        System.out.println("getCard");
        Deck instance = new Deck();
        Card expResult = null;
        Card result = instance.getCard();
        assertEquals(expResult, result);;
    }
}
