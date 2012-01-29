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
    private ArrayList<Card> hand;
    private int value;
    
    /**
     * 
     */
    public Hand()
    {
        hand = new ArrayList<>();
        value = 0;
    }
    
    /**
     * 
     * @param h 
     */
    public Hand(Hand h)
    {
        hand = h.hand;
        value = h.value;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    /**
     * 
     * @param c 
     */
    public void addCard(Card c)
    {
        hand.add(c);
        value += c.getValue();
    }
    
    /**
     * 
     * @return 
     */
    public int getValue()
    {
        return value;
    }
    
    public boolean isBust()
    {
        return value > 21;
    }
}
