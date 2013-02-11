package BlackJack;

/**
 * The Person class which has subclasses Dealer and Player(Thanks to Danny Davis)
 * @author Jordan Giacone
 */
public class Person 
{
    private final String NAME;
    private Hand hand;
    
    /**
     * Main constructor for a Person
     * @param n Their name
     */
    public Person(String n)
    {
        NAME = n;
        hand = new Hand();
    }
    
    
    /**
     * Returns the name of the Player
     * @return The name of the Player
     */
    public String getName()
    {
        return NAME;
    }
    
    protected void setHand(Hand h)
    {
        hand = new Hand();
        
        for(Card c : h.getHand())
        {
            hand.add(c);
        }
    }
    
    /**
     * Returns the primary hand of the player
     * @return Their primary Hand in the form of an ArrayList
     */
    public Hand getHand()
    {
        return hand;
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
        hand.add(c);
        hand.getValue();
    }
    
    /**
     * Adds a Card to the hand
     * @param c The card to add
     */
    public void add(Card c)
    {
        hand.add(c);
    }
    
    /**
     * Gives the number of cardsin the primaryHand
     * @return The number of cards in the hand
     */
    public int getNumCards()
    {
        return hand.numCards();
    }
    
    /**
     * Does the person have a BlackJack?
     * @return If they have a blackjack
     */
    public boolean hasBlackJack()
    {
        return hand.isBlackJack();
    }
    
    /**
     * Do they have a 5 Card Charlie?
     * @return If they have a 5 Card Charlie
     */
    public boolean hasFiveCardCharlie()
    {
        return hand.isFiveCardCharlie();
    }
    
    /**
     * Clears the hand of the Person
     */
    public void clearHand()
    {
        hand.clear();
    }
}