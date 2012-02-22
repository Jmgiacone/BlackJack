package BlackJack;

import java.util.ArrayList;

/**
 * The Person class which has subclasses Dealer and Player(Thanks to Danny Davis)
 * @author Jordan Giacone
 */
public class Person 
{
    protected String name;
    protected Hand hand, primaryHand;
    private ArrayList<Hand> splits;
    private int splitNum;
    
    /**
     * Main constructor for a Person
     * @param n Their name
     */
    public Person(String n)
    {
        splits = new ArrayList<>();
        setSplits();
        name = n;
        splitNum = 0;
        hand = new Hand();
        primaryHand = hand;
    }
    
    /**
     * Sets up the ArrayList<Hand> that is splits
     */
    private void setSplits()
    {
        for(int i = 0; i < 16; i++)
        {
            splits.add(new Hand());
        }
    }
    /**
     * Returns the name of the Player
     * @return The name of the Player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets up the first split for the person
     */
    public void split1()
    {
        primaryHand = splits.get(splitNum);
        splitNum++;
        Card c = hand.getHand().get(0);
        
        if(c.isAce() && c.getValue() == 1)
        {
            c.setAce(false);
        }
        primaryHand.addCard(c);
    }
    
    /**
     * Returns the primary hand of the player
     * @return Their primary Hand in the form of an ArrayList
     */
    public ArrayList<Card> getPrimaryHand()
    {
        return primaryHand.getHand();
    }
    
    /**
     * Sets up the 2nd split for the player
     */
    public void split2()
    {
        primaryHand = splits.get(splitNum);
        splitNum++;
        Card c = hand.getHand().get(1);
        
        if(c.isAce() && c.getValue() == 1)
        {
            c.setAce(false);
        }
        primaryHand.addCard(c);
    }
    /**
     * Gets the value of the hand
     * @return The value of the hand
     */
    public int getHandValue()
    {
        return primaryHand.getValue();
    }
    
    /**
     * Tells if the player has a busted hand
     * @return If the player is bust
     */
    public boolean isBust()
    {
        return primaryHand.isBust();
    }
    
    /**
     * Adds a card to the hand 
     * @param c The card to be added
     */
    public void hit(Card c)
    {
        primaryHand.addCard(c);
        primaryHand.getValue();
    }
    
    /**
     * Adds a Card to the hand
     * @param c The card to add
     */
    public void addCard(Card c)
    {
        primaryHand.addCard(c);
    }
    
    /**
     * Gives the number of cardsin the primaryHand
     * @return The number of cards in the hand
     */
    public int getNumCards()
    {
        return primaryHand.numCards();
    }
    
    /**
     * Does the person have a BlackJack?
     * @return If they have a blackjack
     */
    public boolean hasBlackJack()
    {
        return primaryHand.isBlackJack();
    }
    
    /**
     * Do they have a 5 Card Charlie?
     * @return If they have a 5 Card Charlie
     */
    public boolean hasFiveCardCharlie()
    {
        return primaryHand.isFiveCardCharlie();
    }
    
    /**
     * Clears the hand of the Person
     */
    public void clearHand()
    {
        primaryHand.clearHand();
    }
}