package BlackJack;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The Dealer class that helps run player
 * @author Jordan Giacone
 */
public class Dealer extends Person
{
    private Shoe shoe;
    private Player player;
    private boolean done;
    ArrayList<Hand> splitHands;
    
    /**
     * The constructor for dealer
     * @param n Their name
     * @param d Number of decks to incorporate into the shoe
     */
    public Dealer(String n, int d, Player p)
    {
        super(n);
        player = p;
        shoe = new Shoe(d);
        done = false;
        splitHands = new ArrayList<>();
        
    }
    
    /**
     * A clone constructor that takes in another Dealer object
     * @param d The Dealer to be cloned
     */
    public Dealer(Dealer d)
    {
        super(d.getName());
        setHand(d.getHand());
        shoe = d.shoe;
        player = d.player;
        done = false;
        splitHands = d.splitHands;
    }
    
    /**
     * If the dealer has an ace showing
     * @return If there is an ace that is showing
     */
    public boolean hasAceShowing()
    {
        if(getNumCards() == 0)
        {
            return false;
        }
        return getHand().getHand().get(0).isAce();
    }
    
    /**
     * Returns the card in the hand contained in a JPanel. Idea borrowed from 
     * Keith Harris
     * @return a JPanel populated with the cards in the hand
     */
    public JPanel getCards()
    {
        return getHand().updateCards();
    }
    
    /**
     * Returns a card from the shoe
     * @return A card from the shoe
     */
    public Card draw()
    {
        return getShoe().remove(0);
    }
    
    /**
     * Gets the ArrayList that is the shoe
     * @return The ArrayList<Card> contained in the shoe
     */
    public ArrayList<Card> getShoe()
    {
        return shoe.getShoe();
    }
    
    /**
     * Whether or not the dealer has a soft ace
     * @return If they have a soft ace
     */
    public boolean hasSoftAce()
    {
        for(Card c : getHand().getHand())
        {
            if(c.isAce() && c.getValue() == 11)
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * If the dealer is at a hard 17
     * @return If the dealer has a hard 17
     */
    public boolean isHard17()
    {
        return getHandValue() >= 17 && !hasSoftAce();
    }
    
    /**
     * Deletes all cards from the shoe, then randomly repopulates it
     */
    public void reDoCards()
    {
        shoe.reDoCards();
    }
    
    /**
     * If the dealers up card is an ace, returns true
     * @return If the dealers up card is an ace
     */
    public boolean upCardIsAce()
    {
        if(getNumCards() != 2)
        {
            return false;
        }
        
        if(getHand().getHand().get(0).isAce() && getHand().getHand().get(0).isVisible())
        {
            return true;
        }
        else if(getHand().getHand().get(1).isAce() && getHand().getHand().get(1).isVisible())
        {
            return false;
        }
        
        return false;
    }
}
