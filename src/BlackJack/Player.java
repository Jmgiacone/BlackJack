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
public class Player extends Person
{
    //private FTW
    
    private double bet, money, insuranceBet;
    private boolean insurance;
    
    /**
     * Default Constructor. Takes in a String for the name
     * @param n The name of the player
     */
    public Player(String n, double m)
    {
        super(n);
        bet = 0.0;
        insuranceBet = 0.0;
        money = m;
        insurance = false;
        hand = new Hand();
    }
    
    /**
     * A clone constructor that copies the instance variables
     * @param p The player to be cloned
     */
    public Player(Player p)
    {
        super(p.name);
        money = p.money;
        name = p.name;
        bet = p.bet;
        insurance = p.insurance;
    }
    
    public void lose()
    {
        bet = 0;
    }
    public ArrayList<Card> split1()
    {
        return (ArrayList)hand.getHand().subList(0, 0);
    }
    
    public ArrayList<Card> split2()
    {
        return (ArrayList)hand.getHand().subList(1, 1);
    }
    public void winInsurance()
    {
        money += 2 *insuranceBet;
        insurance = false;
    }
    public void insurance(double aBet)
    {
        //Insurance pays 2:1
        insuranceBet = aBet;
    }
    public void doubleDown()
    {
        //If dealer has ace
        money -= bet;
        bet *= 2;
    }
    
    /**
     * Returns how much money the player has
     * @return the amount of money that the player has left
     */
    public double getMoney()
    {
        return money;
    }
    
    public boolean hasInsurance()
    {
        return insurance;
    }
    public void win()
    {
        if(insurance)
        {
            
        }
        else if(hand.isBlackJack())
        {
            money += bet * 2.5;
        }
        else
        {
            money += bet * 2;
        }
        bet = 0;
        insurance = false;
    }
    
    /**
     * 
     * @param b 
     */
    public void bet(double b)
    {
        bet = b;
        money -= bet;
    }
    
    public void push()
    {
        money += bet;
        bet = 0;
    }
    public String toString()
    {
        return name+ "Money: " +money+ "Cards:\n" + hand;
    }
    
    public double getBet()
    {
        return bet;
    }
    
    public JPanel updateCards()
    {
        return hand.updateCards();
    }
}
