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
public class GuiWorkTest {
    
    public GuiWorkTest() {
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
     * Test of initButtons method, of class GuiWork.
     */
    @Test
    public void testInitButtons() {
        System.out.println("initButtons");
        GuiWork instance = new GuiWork();
        instance.initButtons();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
