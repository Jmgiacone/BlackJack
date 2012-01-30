package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This is the Shoe class. A Shoe is 2 or more Decks of cards
 * 1/27/12
 * @author Jordan Giacone
 */
public class Shoe 
{
    private ArrayList<Card> shoe;
    private Random r;
    
    /**
     * Constructs a shoe with the number of decks in the shoe
     * @param numDecks The number of full decks to be included in the shoe
     */
    public Shoe(int numDecks)
    {
        shoe = new ArrayList<>();
        r = new Random();
        
        for(int i = 0; i < numDecks; i++)
        {
            addDeckCards(new Deck().getDeck());
        }
    }
    
    /**
     * Constructs a Shoe with the default amount of decks (3)
     */
    public Shoe()
    {
        shoe = new ArrayList<>();
        r = new Random();
        
        for(int i = 0; i < 3; i++)
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
        r = new Random();
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
    
    /**
     * Shuffles the shoe
     */
    public void Shuffle()
    {
        //Split the deck, then take 1 or 2 cards from each half, then repeat 
        //with rand num 1-3 each pass
        
        List<Card> h1, h2 = new ArrayList<>();
        
        h1 = shoe.subList(0, shoe.size() / 2);
        h2 = shoe.subList(shoe.size() / 2, shoe.size() - 1);
        
        int numCards = 0;
        for(int i = 0; true; i++)
        {
            numCards = r.nextInt(3) + 1;
            
            h1.
        }
//        int num;
//        for(int i = shoe.size(); i > 0; i--)
//        {
//            num = r.nextInt(i);
//            shuffling.add(cards.get(num));
//            cards.remove(num);
//        }
//        
//        nullify(cards);
//        Collections.copy(cards, shuffling);
//        shuffling.clear();
    }
}
