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
    private int decks;
    
    /**
     * Constructs a shoe with the number of decks in the shoe
     * @param numDecks The number of full decks to be included in the shoe
     */
    public Shoe(int numDecks)
    {
        shoe = new ArrayList<>();
        
        decks = numDecks;
        initCards(decks);
        
        
        for(int i = 0; i < 10; i++)
        {
            shuffle();
        }
    }

    /**
     * Constructs a Shoe with the default amount of decks (3)
     */
    public Shoe()
    {
        shoe = new ArrayList<>();

        for(int i = 0; i < 3; i++)
        {
            addDeckCards(new BlackJackDeck().getDeck());
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
     * Sets up all the Cards in the Shoe with the given amount of decks
     * @param decks The amount of decks to include
     */
    public void initCards(int decks)
    {
        for(int i = 0; i < decks; i++)
        {
            addDeckCards(new BlackJackDeck().getDeck());
        }
    }

    /**
     * Adds decks to the shoe
     * @param d The deck to be added
     */
    private void addDeckCards(ArrayList<Card> d)
    {
        for(Card c : d)
        {
            shoe.add(c);
        }
    }
    
    /**
     * Completely clears the Shoe, then randomly repopulates it
     */
    public void reDoCards()
    {
        shoe.clear();
        initCards(decks);
        
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
     * Shuffles the Shoe using a realistic shuffling algorithm
     */
    public void shuffle()
    {
         List<Card> h1 = shoe.subList(0, shoe.size() / 2),
                 //split the shoe into 2 halves
                 h2 = shoe.subList(shoe.size() / 2, 
                 shoe.size()), temp = new ArrayList<>();

         Random r = new Random();
         
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
         shoe = (ArrayList<Card>)temp;
         
    }
    
    /**
     * A basic toString
     * @return Every card in the shoe
     */
    public String toString()
    {
        String str = "";
        
        for(int i = 0; i < shoe.size(); i++)
        {
            str += shoe.get(i);
        }
        
        return str;
    }
}
