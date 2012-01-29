package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This is the Shoe class
 * 1/27/12
 * @author Jordan Giacone
 */
public class Shoe 
{
    private ArrayList<Card> shoe;
    
    /**
     * Constructs a shoe with the number of decks in the shoe
     * @param numDecks The number of full decks to be included in the shoe
     */
    public Shoe(int numDecks)
    {
        shoe = new ArrayList<>();
        
        for(int i = 0; i < numDecks; i++)
        {
            addDeckCards(new Deck().getDeck());
        }
    }
    
    /**
     * A clone constructor
     * @param s The shoe to be cloned
     */
    public Shoe(Shoe s)
    {
        shoe = new ArrayList<>(s.shoe.size());
        Collections.copy(shoe, s.shoe);
    }
    
    /**
     * Adds decks to the shoe
     * @param d The deck to be added
     */
    private void addDeckCards(ArrayList<Card> d)
    {
        for(int i = 0; i < d.size(); i++)
        {
            shoe.add(d.get(i));
        }
    }
    
    /**
     * A get method for the ArrayList<Card> called shoe
     * @return Shoe
     */
    public ArrayList<Card> getShoe()
    {
        return shoe;
    }
}
