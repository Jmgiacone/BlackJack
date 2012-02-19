/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jordan
 */
public class Person 
{
    protected String name;
    protected Hand hand;
    
    public Person(String n)
    {
        name = n;
        hand = new Hand();
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
     * Gets the value of the hand
     * @return The value of the hand
     */
    public int getHandValue()
    {
        return hand.getValue();
    }
    
    /**
     * Tells if the player has a busted hand
     * @return If the player is bust
     */
    public boolean isBust()
    {
        return hand.isBust();
    }
    
    /**
     * Adds a card to the hand 
     * @param c The card to be added
     */
    public void hit(Card c)
    {
        hand.addCard(c);
        hand.getValue();
    }
    
    public void addCard(Card c)
    {
        hand.addCard(c);
    }
    
    /**
     * Gives the number of cardsin the hand
     * @return The number of cards in the hand
     */
    public int getNumCards()
    {
        return hand.numCards();
    }
    
    public ArrayList<Card> getHand()
    {
        return hand.getHand();
    }
    public boolean hasBlackJack()
    {
        return hand.isBlackJack();
    }
    
    public boolean hasFiveCardCharlie()
    {
        return hand.isFiveCardCharlie();
    }
    public void clearHand()
    {
        hand.clearHand();
    }
    
    public JPanel getCards()
    {
        return hand.updateCards();
    }
    
}
