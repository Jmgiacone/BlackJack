/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class Hand 
{
    private int value;
    private ArrayList<Card> hand;
    
    /**
     * Constructs an empty ArrayList to hold the taken in cards
     */
    public Hand()
    {
        value = 0;
        hand = new ArrayList<>();
    }
    
    /**
     * A clone constructor that clones a hand passed in
     * @param h The hand to be cloned 
     */
    public Hand(Hand h)
    {
        value = h.value;
        hand = h.hand;
    }
    
    /**
     * Straight up returns the ArrayList
     * @return The ArrayList<Card> hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    /**
     * Adds Card c to the hand
     * @param c Card to be added
     */
    public void addCard(Card c)
    {
        hand.add(c);
        
        //special ace case
        for(int i = 0; i < numAces(); i++)
        {
            //is there an ace in the hand?
            if(containsAce() && //only if it will bust you :)
                    isBust()) 
            {
                   //Is the value of the ace 11? Hope not
                   for(int j = 0; j < numAces(); j++)
                   {
                       if(indexOf11Ace() != -1
                               && isBust())
                       {
                           hand.get(indexOf11Ace()).setAce(true);
                       }
                   }
             }
        }
        getValue();
    }
    
    /**
     * Adds up the values of all cards and returns total
     * @return The value of the hand
     */
    public int getValue()
    {
        value = 0;
        for(Card c : hand)
        {
            value += c.getValue();
        }
        
        return value;
    }
    
    /**
     * Returns the amount of cardage in the hand
     * @return Size of the ArrayList
     */
    public int numCards()
    {
        return hand.size();
    }
    
    /**
     * Tells if the player is bust or not
     * @return True if the hand is over 21 with all aces being set to one
     */
    public boolean isBust()
    {
        return getValue() > 21;
    }
    
    /**
     * Tells how many aces are in the hand
     * @return The amount of aces in the hand
     */
    public int numAces()
    {
        int count = 0;
        
        for(Card c : hand)
        {
            if(c.isAce())
            {
                count++;
            }
        }
        return count;
    }
    /**
     * Tells if the hand totals 21
     * @return True if hand totals 21
     */
    public boolean is21()
    {
        return getValue() == 21;
    }
    
    /**
     * Tells whether or not the hand is a BlackJack (a 2 card 21 (Ace and Face))
     * @return If the hand is a BlackJack
     */
    public boolean isBlackJack()
    {
        return numCards() == 2 && is21();
    }
    
    /**
     * Tells whether or not the hand contains an ace
     * @return True if the hand contains an ace
     */
    public boolean containsAce()
    {
        for(Card c : hand)
        {
            if(c.isAce())
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the index of the card with the given name
     * @param name The name to be searched for
     * @return The index of the element. -1 if not present
     */
    private int indexOf11Ace()
    {
        for(Card c : hand)
        {
            if(c.isAce() && c.getValue() == 11)
            {
                return hand.indexOf(c);
            }
        }
        return -1;
    }
    
    /**
     * Tells whether or not the hand is a 5 card charlie (5 card hand that isn't
     * busted)
     * @return True if the hand has 5 Cards and isn't busted yet 
     */
    public boolean isFiveCardCharlie()
    {
        return !isBust() && numCards() >= 5;
    }
}
