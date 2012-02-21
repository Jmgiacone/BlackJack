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
    protected Hand hand, primaryHand;
    private ArrayList<Hand> splits;
    private int splitNum;
    
    
    public Person(String n)
    {
        splits = new ArrayList<>();
        setSplits();
        name = n;
        splitNum = 0;
        hand = new Hand();
        primaryHand = hand;
    }
    
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
    
    public ArrayList<Card> getPrimaryHand()
    {
        return primaryHand.getHand();
    }
    
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
    
    public boolean hasBlackJack()
    {
        return primaryHand.isBlackJack();
    }
    
    public boolean hasFiveCardCharlie()
    {
        return primaryHand.isFiveCardCharlie();
    }
    public void clearHand()
    {
        primaryHand.clearHand();
    }
    
    
}
