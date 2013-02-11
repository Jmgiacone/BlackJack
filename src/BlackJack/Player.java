package BlackJack;

import java.util.ArrayList;
import javax.swing.JPanel;
/**
 * The Player class, inheriting from Person. One of the driving classes of the game
 * @author Jordan Giacone
 */
public class Player extends Person
{
    private double bet, money, insuranceBet;
    private Hand primaryHand;
    private boolean insurance;
    private ArrayList<Hand> splits;
    private int splitNum;
    
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
        primaryHand = getHand();
    }
    
    /**
     * A clone constructor that copies the instance variables
     * @param p The player to be cloned
     */
    public Player(Player p)
    {
        super(p.getName());
        money = p.money;
        bet = p.bet;
        insurance = p.insurance;
    }
    
    public Hand getPrimaryHand()
    {
        return primaryHand;
    }
    /**
     * The player doesn't win their money back and loses the round
     */
    public void lose()
    {
        bet = 0;
    }
    
    /**
     * When the player wins their insurance bet
     */
    public void winInsurance()
    {
        money += 4 * insuranceBet;
        insurance = false;
        bet = 0;
    }
    
    /**
     * Sets up the insurance bet
     * @param aBet The bet to be bet
     */
    public void insurance(double aBet)
    {
        //Insurance pays 2:1
        insuranceBet = aBet;
        money -= insuranceBet;
        insurance = true;
    }
    
    /**
     * When the player doubles their bet and is forced to stand
     */
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
    
    /**
     * Returns if the player currently has insurance
     * @return if the player currently has insurance
     */
    public boolean hasInsurance()
    {
        return insurance;
    }
    
    /**
     * Wins the player their money back. If it's a BlackJack, pays 3:2
     */
    public void win()
    {
        if(getHand().isBlackJack())
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
     * Sets the bet for the player
     * @param b 
     */
    public void bet(double b)
    {
        bet = b;
        money -= bet;
    }
    
    /**
     * Called if the player and dealer have the same getHand()s. Player wins no extra
     * money but doesn't lose any either
     */
    public void push()
    {
        money += bet;
        bet = 0;
    }
    
    /**
     * Just a simple toString
     * @return A String representation of the instance variables of the Player
     */
    @Override
    public String toString()
    {
        return getName() + "Money: " +money+ "Cards:\n" + getHand();
    }
    /**
     * Sets up the first split for the person
     */
    public void split1()
    {
        primaryHand = splits.get(splitNum);
        splitNum++;
        Card c = getHand().getHand().get(0);
        
        if(c.isAce() && c.getValue() == 1)
        {
            c.setAce(false);
        }
        primaryHand.add(c);
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
     * Sets up the 2nd split for the player
     */
    public void split2()
    {
        primaryHand = splits.get(splitNum);
        splitNum++;
        Card c = getHand().getHand().get(1);
        
        if(c.isAce() && c.getValue() == 1)
        {
            c.setAce(false);
        }
        primaryHand.add(c);
    }
    /**
     * Returns the money that the player bet
     * @return The money that they bet
     */
    public double getBet()
    {
        return bet;
    }
    
    /**
     * Returns a JPanel populated with the cards in the getHand()
     * @return a JPanel populated with the cards in the getHand()
     */
    public JPanel getPrimaryCards()
    {
        return primaryHand.updateCards();
    }
}
