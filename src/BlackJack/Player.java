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
public class Player 
{
    //PROTECTED FTW
    protected String name;
    protected double bet;
    protected Hand hand;
    
    /**
     * Default Constructor. Takes in a String for the name
     * @param n The name of the player
     */
    public Player(String n)
    {
        name = n;
        bet = 0.0;
        hand = new Hand();
    }
    
    /**
     * A clone constructor that copies the instance variables
     * @param p The player to be cloned
     */
    public Player(Player p)
    {
        name = p.name;
        bet = p.bet;
        hand = p.hand;
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
    
}
