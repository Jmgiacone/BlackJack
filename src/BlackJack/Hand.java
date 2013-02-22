package BlackJack;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Hand is an ArrayList<Card> represent which Cards are currently held by
 * the player
 * @author Jordan Giacone
 */
public abstract class Hand
{
    protected ArrayList<Card> hand;

    public abstract JPanel updateCards();
    public abstract void add(Card c);
    public abstract int getValue();



    /**
     * Constructs an empty ArrayList to hold the taken in cards
     */
    public Hand()
    {
        hand = new ArrayList<>();
    }
    
    /**
     * A clone constructor that clones a hand passed in
     * @param h The hand to be cloned 
     */
    public Hand(Hand h)
    {
        hand = h.hand;
    }
    
    /**
     * Clears the hand of any data whatsoever
     */
    public void clear()
    {
        hand.clear();
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
     * Returns the amount of cardage in the hand
     * @return Size of the ArrayList
     */
    public int numCards()
    {
        return hand.size();
    }

    /**
     * Returns a JPanel populated with the Cards in the Hand
     * @return A JPanel that has all the Cards in the Hand
     */

    
    /**
     * A basic toString
     * @return A String representation of the instance variables in the class
     */
    @Override
    public String toString()
    {
        String s = "";
        
        for(int i = 0; i < hand.size(); i++)
        {
            s += hand.get(i) + "\n";
        }
        return s;
    }
}
