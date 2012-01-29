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
public class ShoeTest {
    
    public ShoeTest() {
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
     * Test of getShoe method, of class Shoe.
     */
    @Test
    public void testGetShoe() {
        System.out.println("getShoe");
        int numDecks = 3;
        Shoe instance = new Shoe(numDecks);
        ArrayList expResult = null;
        ArrayList result = instance.getShoe();
        assertEquals(result.size(), numDecks * 52);
        assertNotSame(result.size(), 52);
    }
}
