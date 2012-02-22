package BlackJack;

import javax.swing.JPanel;

/**
 * The Player class, inheritng from Person. One of the driving classes of the game
 * @author Jordan Giacone
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
        primaryHand = hand;
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
        if(hand.isBlackJack())
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
     * Called if the player and dealer have the same hands. Player wins no extra
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
    public String toString()
    {
        return name+ "Money: " +money+ "Cards:\n" + hand;
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
     * Returns a JPanel populated with the cards in the hand
     * @return a JPanel populated with the cards in the hand
     */
    public JPanel getPrimaryCards()
    {
        return primaryHand.updateCards();
    }
}
