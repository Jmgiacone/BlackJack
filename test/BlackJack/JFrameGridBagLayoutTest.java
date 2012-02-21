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
 *
 * @author Jordan
 */
public class JFrameGridBagLayoutTest {
    
    public JFrameGridBagLayoutTest() {
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
     * Test of dealerHand method, of class JFrameGridBagLayout.
     */
    @Test
    public void testDealerHand() {
        System.out.println("dealerHand");
        JFrameGridBagLayout instance = new JFrameGridBagLayout();
        instance.dealerHand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cleanUp method, of class JFrameGridBagLayout.
     */
    @Test
    public void testCleanUp() {
        System.out.println("cleanUp");
        JFrameGridBagLayout instance = new JFrameGridBagLayout();
        instance.cleanUp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of results method, of class JFrameGridBagLayout.
     */
    @Test
    public void testResults() {
        System.out.println("results");
        JFrameGridBagLayout instance = new JFrameGridBagLayout();
        String expResult = "";
        String result = instance.results();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCards method, of class JFrameGridBagLayout.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        JFrameGridBagLayout instance = new JFrameGridBagLayout();
        instance.setCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
