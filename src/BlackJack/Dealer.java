package BlackJack;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    public ArrayList<Card> getHand()
    {
        return primaryHand.getHand();
    }
    public boolean hasAceShowing()
    {
        if(getNumCards() == 0)
        {
            return false;
        }
        return primaryHand.getHand().get(0).isAce();
    }
    
    public JPanel getCards()
    {
        return primaryHand.updateCards();
    }
    
    public Card draw()
    {
        return getShoe().remove(0);
    }
    
    public ArrayList<Card> getShoe()
    {
        return shoe.getShoe();
    }
    
    public boolean hasSoftAce()
    {
        for(Card c : primaryHand.getHand())
        {
            if(c.isAce() && c.getValue() == 11)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isHard17()
    {
        return getHandValue() >= 17 && !hasSoftAce();
    }
    
    public void reDoCards()
    {
        shoe.reDoCards();
    }
    public boolean upCardIsAce()
    {
        if(getNumCards() != 2)
        {
            return false;
        }
        
        if(primaryHand.getHand().get(0).isAce() && primaryHand.getHand().get(0).isVisible())
        {
            return true;
        }
        else if(primaryHand.getHand().get(1).isAce() && primaryHand.getHand().get(1).isVisible())
        {
            return false;
        }
        
        return false;
    }
}
