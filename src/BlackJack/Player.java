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
    protected String name;
    protected double bet;
    protected Hand hand;
    
    public Player(String n)
    {
        name = n;
        bet = 0.0;
        hand = new Hand();
    }
    
    public Player(Player p)
    {
        name = p.name;
        bet = p.bet;
        hand = p.hand;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHandValue()
    {
        return hand.getValue();
    }
    
    public boolean isBust()
    {
        return hand.isBust();
    }
    
    public void hit(ArrayList<Card> d)
    {
        Card c = d.get(d.size() - 1);
        //Object pass by reference OP
        d.remove(c);
        
        hand.addCard(c);
    }
    
}
