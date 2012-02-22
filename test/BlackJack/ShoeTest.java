package BlackJack;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 2/1/12
 * This is the JUnit testing class for Shoe
 * @author Jordan Giacone
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
        ArrayList result = instance.getShoe();
        assertEquals(result.size(), numDecks * 52);
        assertNotSame(result.size(), 52);
    }

    /**
     * Test of Shuffle method, of class Shoe.
     */
    @Test
    public void testShuffle() {
        System.out.println("Shuffle");
        Shoe instance = new Shoe(5), old = new Shoe(5);
        System.out.println("\nBefore Shuffle" +instance);
        
        //Five x ten shuffles
        for(int i = 0; i < 50; i++)
        {
            instance.shuffle();
        }
        
        assertEquals(instance.getShoe().size(), 
                old.getShoe().size());
        
        //Checks to make sure that every element of both ArrayLists is in a
        //different index
        for(int i = 0; i <  instance.getShoe().size(); i++)
        {
            assertNotSame(instance.getShoe().get(i), 
                    old.getShoe().get(i));
        }
        System.out.println("\nAfter Shuffling"+instance +"\nWhole Shoe shuffled");
    }

    /**
     * Test of toString method, of class Shoe.
     */
    @Test
    public void testToString() 
    {
        System.out.println("toString");
        Shoe instance = new Shoe();
        String expResult = "";
        String result = instance.toString();
        System.out.println(result);
    }

    
}
