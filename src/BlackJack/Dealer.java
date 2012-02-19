package BlackJack;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jordan
 */
public class Dealer extends Person
{
    private Shoe shoe;
    private Player player;
    private boolean done;
    ArrayList<Hand> splitHands;
    
    /**
     * 
     * @param n
     * @param d 
     */
    public Dealer(String n, int d, Player p)
    {
        super(n);
        hand = new Hand();
        player = p;
        shoe = new Shoe(d);
        done = false;
        splitHands = new ArrayList<>();
        
    }
    
    public Dealer(Dealer d)
    {
        super(d.name);
        hand = d.hand;
        shoe = d.shoe;
        player = d.player;
        done = false;
        splitHands = d.splitHands;
    }
    public boolean isAt17()
    {
        return hand.getValue() >= 17;
    }
    
    public void start()
    {
        //Start the game HERE
        try
        {
            int s = Integer.parseInt(
                    JOptionPane.showInputDialog("How much to bet?"));
            
            if(s <= 0)
            {
                JOptionPane.showMessageDialog(null,"Bet is required");
                start();
            }
            player.bet(s);
            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Invalid number, try again");
            start();
        }
        
        while(!done)
        {
            setCards();
                
            if(hasAceShowing())
            {
                
                
            }
            else if(player.hasBlackJack() && hasBlackJack())
            {
                //Push
            }
            else if(player.hasBlackJack() || hasBlackJack())
            {
                //Skip to results method
            }
            else
            {
                playerHand();
                dealerHand();
            }
            
            results();
            cleanUp();
            done = isDone();
        }
    }
    
    public void askInsurance()
    {
        if(JOptionPane.showInputDialog("Would you like insurance?")
                        .equalsIgnoreCase("Yes"))
        {
            boolean b = false;
            while(!b)
            {
                try
                {
                    player.insurance(Integer.parseInt(
                            JOptionPane.showInputDialog(
                            "How much to bet on insurance")));
                    b = true;

                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(null,"Invalid number, "
                            + "try again");
                }
            }
        }
    }
    public boolean hasAceShowing()
    {
        if(getNumCards() == 0)
        {
            return false;
        }
        return hand.getHand().get(0).isAce();
    }
    public String results()
    {
        if(player.hasInsurance() && hasBlackJack())
        {
            player.winInsurance();
            return "Congratulations, you won your Insurance bet!";
        }
        
        if(player.hasBlackJack())
        {
            player.win();
            return player.name + " has a BlackJack, they automatically win "
                    + "$"+ player.getBet() * 1.5;
        }
        else if(hasBlackJack())
        {
            return name + " the dealer has a BlackJack, they automatically win";
        }
        else if(player.hasFiveCardCharlie())
        {
            player.win();
            return player.name + "has a Five Card Charlie, they automatically "
                    + "win $"+ player.getBet();
        }
        else if(hasFiveCardCharlie())
        {
            return name + " the dealer has a Five Card Charlie, "
                    + "they automatically win";
        }
        else if(player.isBust())
        {
            //Dealer wins
            return "Dealer wins because player is bust";
        }
        else if(isBust())
        {
            player.win();
            return "Dealer has bust, "+player.name+" wins the round";
        }
        else if(player.getHandValue() > getHandValue())
        {
            player.win();
        }
        else if(player.getHandValue() < getHandValue())
        {
            //player loses :(
            return "Dealer wins";
        }
        else if(player.getHandValue() == getHandValue())
        {
            //push
            return "This game is a push. Neither side wins";
        }
        
        
        return "Exception not coded for" + hand + player.getHand();
    }
    
    public Card draw()
    {
        return getShoe().remove(0);
    }
    
    public ArrayList<Card> getShoe()
    {
        return shoe.getShoe();
    }
    
    public /*private*/ void playerHand()
    {
        boolean done = false;
        String s = "";
        while(player.getHandValue() < 21 || !done)
        {
            s = JOptionPane.showInputDialog("Hit, Split, or Stay?");
            //Hit or stay?
            if(s.equalsIgnoreCase("Hit"))
            {
                player.hit(draw());
            }
            else if(s.equalsIgnoreCase("Stay"))
            {
                done = true;
            }
            else if(s.equalsIgnoreCase("Split"))
            {
                if(player.getNumCards() == 2 && 
                        player.getHand().
                        get(0).
                        getRank().
                        equalsIgnoreCase
                        (player.getHand().
                        get(1).
                        getRank()))
                {
                   //player.split(); 
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid answer");
                playerHand();
            }
        }
    }
    
    public /*private*/ void dealerHand()
    {
        while(getHandValue() < 17)
        {
            hit(draw());
        }
    }
    
    public boolean hasSoftAce()
    {
        for(Card c : hand.getHand())
        {
            if(c.isAce() && c.getValue() == 11)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isBelowHard17()
    {
        return getHandValue() <= 17 && !hasSoftAce();
    }
    public /*private*/ boolean isDone()
    {
        return JOptionPane.showInputDialog("Would you like to play again?")
                .equalsIgnoreCase("Yes");
    }
    
    public void reDoCards()
    {
        shoe.reDoCards();
    }
    public /*private*/ void cleanUp()
    {
        clearHand();
        player.clearHand();
        
        if(shoe.getShoe().size() <= 20)
        {
            shoe.reDoCards();
        }
    }
    public /*private*/ void setCards()
    {
        //Cards dealt as player,dealer,player,dealer
        player.addCard(shoe.getShoe().get(0));
        hand.addCard(shoe.getShoe().get(1));
        player.addCard(shoe.getShoe().get(2));
        hand.addCard(shoe.getShoe().get(3));
        
        for(int i = 0; i < 4; i++)
        {
            shoe.getShoe().remove(i);
        }
        hand.getHand().get(1).setVisibility(false);
        
    }
    public boolean upCardIsAce()
    {
        if(getNumCards() != 2)
        {
            return false;
        }
        
        if(hand.getHand().get(0).isAce() && hand.getHand().get(0).isVisible())
        {
            return true;
        }
        else if(hand.getHand().get(1).isAce() && hand.getHand().get(1).isVisible())
        {
            return false;
        }
        
        return false;
    }
}
