package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This is the Deck Class
 * 1/26/12
 * @author Jordan Giacone
 */
public class Deck 
{
    private ArrayList<Card> cards, shuffling, deckList;
    private Random r;
    
    /**
     * A clone constructor for Deck. Copies the instance vars from d
     * @param d The Deck of which to clone
     */
    public Deck(Deck d)
    {
        cards = new ArrayList<>(52);
        deckList = d.getDeck();
        shuffling = new ArrayList<>();
        r = new Random();
        for(int i = 0; i < deckList.size(); i++)
        {
            cards.add(deckList.get(i));
        }
    }
    
    /**
     * A "no args" constructor. The default constructor for Deck. 
     * Initialized all values to default
     */
    public Deck()
    {
        cards = new ArrayList<>(52);
        shuffling = new ArrayList<>();
        r = new Random();
        //Parameterized with 52 for readability sake
        setCards();
    }
    
    /**
     * A helper method containing the algorithm for initializing the cards
     */
    private void setCards()
    {
        String rk = "";
        int v = 0;
        for(int i = 1; i <=13; i++)
        {
            if(i == 1)
            {
                rk = "Ace";
                v = 11;
            }
            else if(i == 2)
            {
                rk = "Two";  
                v = 2;
            }
            else if(i == 3)
            {
                rk = "Three";
                v = 3;
            }
            else if(i == 4)
            {
                rk = "Four";
                v = 4;
            }
            else if(i == 5)
            {
                rk = "Five";
                v = 5;
            }
            else if(i == 6)
            {
                rk = "Six";
                v = 6;
            }
            else if(i == 7)
            {
                rk = "Seven";
                v = 7;
            }
            else if(i == 8)
            {
                rk = "Eight";
                v = 8;
            }
            else if(i == 9)
            {
                rk = "Nine";
                v = 9;
            }
            else if(i == 10)
            {
                rk = "Ten";
                v = 10;
            }
            else if(i == 11)
            {
                rk = "Jack";
                v = 10;
            }
            else if(i == 12)
            {
                rk = "Queen";
                v = 10;
            }
            else if(i == 13)
            {
                rk = "King";
                v = 10;
            }
        
            for(int j = 1; j <= 4; j++)
            {
                String s = "";

                if(j == 1)
                {
                    s = "Spades";
                }
                else if(j == 2)
                {
                    s = "Clubs";
                }
                else if(j == 3)
                {
                    s = "Hearts";
                }
                else if(j == 4)
                {
                    s = "Diamonds";
                }
                
                cards.add(new Card(rk, s, v, true));
            }
        }
    }
    
    /**
     * This method returns a reference to the ArrayList of cards in Deck
     * @return The ArrayList<Card> deck
     */
    public ArrayList<Card> getDeck()
    {
        return cards;
    }
    
    /**
     * Simulates real shuffling of a deck. The deck will be randomized after
     * a call to this method
     */
    public void shuffle()
    {
        //Will probably write a better shuffle algorithm later
        int num;
        for(int i = cards.size(); i > 0; i--)
        {
            num = r.nextInt(i);
            shuffling.add(cards.get(num));
            cards.remove(num);
        }
        
        nullify(cards);
        Collections.copy(cards, shuffling);
        shuffling.clear();
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
        else
        {
            //no nullification
        }
    }
    
    /**
     * A basic toString
     * @return The status of all 52 cards
     */
    public String toString()
    {
        String s = "";
        for(int i = 0; i < cards.size(); i++)
        {
            s += cards.get(i).toString() + "\n";
        }
        
        return s;
    }
}
