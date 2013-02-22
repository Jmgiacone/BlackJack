package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the Deck Class
 * 1/26/12
 * @author Jordan Giacone
 */
public abstract class Deck
{
    protected ArrayList<Card> deck;

    protected abstract void setUpDeck();
    /**
     * A clone constructor for Deck. Copies the instance vars from d
     * @param d The Deck of which to clone
     */
    protected Deck(Deck d)
    {
        deck = new ArrayList<>();
    }
    
    /**
     * A "no args" constructor. The default constructor for Deck. 
     * Initialized all values to default
     */
    protected Deck()
    {
        deck = new ArrayList<>();
        setUpDeck();
    }

    
    /**
     * Gets the Card at the given index
     * @param index The index of which to find the card
     * @return The found card
     */
    public Card getCard(int index)
    {
        return deck.get(index);
    }
    
    /**
     * Gets the top Card
     * @return The top Card of the Deck
     */
    public Card getTopCard()
    {
        return deck.get(0);
    }
    /**
     * This method returns a reference to the ArrayList of cards in Deck
     * @return The ArrayList<Card> deck
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    /**
     * Simulates real shuffling of a deck. The deck will be randomized after
     * a call to this method
     */
    public void shuffle()
    {
        Random r = new Random();
        List<Card> h1 = deck.subList(0, deck.size() / 2),
                 //split the deck into 2 halves
                 h2 = deck.subList(deck.size() / 2, 
                 deck.size()), temp = new ArrayList<>();
         
         int num = 0, index = 0;
         
         for(int count = 0; count < h1.size();)
         {
             if(count > h1.size() - 4)
             {
                 num = h1.size() - count;
             }
             else
             {
                 //Generates an arbitrary number of cards to take off
                 //the two halves
                num = r.nextInt(3) + 1;
             }
             
             index += num - 1;
             for(int j = num; j > 0; j--)
             {
                 temp.add(h1.get(index));
                 temp.add(h2.get(index));
                 
                 if(j == 1)
                 {
                     //Do nothing
                 }
                 else
                 {
                    index--;
                 }
                 count++;
             }
             index = count;
         }
         deck = (ArrayList<Card>)temp;
    }
    
    /**
     * A helper method that sets the entire contents of the ArrayList to null
     * @param x The ArrayList to be "nullified"
     */
    private void nullify(ArrayList<Card> x)
    {
        if(x.isEmpty())
        {
            x.ensureCapacity(52);
            
            while(x.size() != 52)
            {
                x.add(null);
            }
        }
    }
    
    /**
     * A basic toString
     * @return The status of all 52 cards
     */
    @Override
    public String toString()
    {
        String s = "";
        for(int i = 0; i < deck.size(); i++)
        {
            s += deck.get(i).toString();
        }
        
        return s;
    }
}
