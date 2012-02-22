package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the Deck Class
 * 1/26/12
 * @author Jordan Giacone
 */
public class Deck 
{
    private ArrayList<Card> deck, deckList;
    private Random r;
    
    /**
     * A clone constructor for Deck. Copies the instance vars from d
     * @param d The Deck of which to clone
     */
    public Deck(Deck d)
    {
        deck = new ArrayList<>(52);
        deckList = d.getDeck();
        r = new Random();
        
        for(int i = 0; i < deckList.size(); i++)
        {
            deck.add(deckList.get(i));
        }
    }
    
    /**
     * A "no args" constructor. The default constructor for Deck. 
     * Initialized all values to default
     */
    public Deck()
    {
        deck = new ArrayList<>(52);
        r = new Random();
        //Parameterized with 52 for readability sake
        setdeck();
    }
    
    /**
     * A helper method containing the algorithm for initializing the cards
     */
    private void setdeck()
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
                
                deck.add(new Card(rk, s, v));
            }
        }
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
    public Card getCard()
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
//        //Will probably write a better shuffle algorithm later
//        int num;
//        for(int i = deck.size(); i > 0; i--)
//        {
//            num = r.nextInt(i);
//            shuffling.add(deck.get(num));
//            deck.remove(num);
//        }
//        
//        nullify(deck);
//        Collections.copy(deck, shuffling);
//        shuffling.clear();
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
        for(int i = 0; i < deck.size(); i++)
        {
            s += deck.get(i).toString();
        }
        
        return s;
    }
}
