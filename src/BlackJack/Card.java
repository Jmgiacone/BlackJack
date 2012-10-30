package BlackJack;

import javax.swing.ImageIcon;

/**
 * This is the basis of the entire game, the card class. The most 
 * fundamental unit of play in the entire game. Enjoy :)
 * 1/26/12
 * @author Jordan Giacone
 */
public class Card 
{
    private String rank, suit, faceLocation, backLocation, tableLocation;
    private int value;
    private boolean visible, isTable;
    private ImageIcon face, backing, table;
    
    /**
     * Constructs a card with given rank, suit, and value
     * @param newRank The Rank of the card (Queen, ten, Ace)
     * @param newSuit The suit of the card (Spade, Hearts, Diamonds)
     * @param newValue The value of the card(1,11,10)
     */
    public Card(String newRank, String newSuit, int newValue)
    {
        rank = newRank;
        suit = newSuit;
        value = newValue;
        visible = true;
        isTable = false;
        faceLocation = "images/"+rank+suit+".png";
        backLocation = "images/back-blue-150-3.png";
        tableLocation = "images/tableColor.png";
        backing = new ImageIcon(backLocation);
        table = new ImageIcon(tableLocation);
        face = new ImageIcon(faceLocation);
        
    }
    /**
     * This is the default constructor that constructs default values for a 
     * card, A joker of Narwhals with a value of -1
     */
    public Card()
    {
        rank = "Joker";
        suit = "Narwhals";
        value = -1;
        visible = true;
    }
    /**
     * This is a clone constructor that copies the instance variables of the
     * card object passed in
     * @param c The Card object to be "copied"
     */
    public Card(Card c)
    {
        rank = c.rank;
        suit = c.suit;
        value = c.value;
        visible = c.visible;
    }
    /**
     * Flips the value of the ace. If the param is true, then it flips to one
     * @param toOne The parameter that tells if the ace should be flipped to one
     */
    public void setAce(boolean toOne)
    {
        if(isAce() && toOne)
        {
            value = 1;
        }
        else if(isAce() && !toOne)
        {
            value = 11;
        }
    }
    /**
     * Returns the rank of the card
     * @return A copy of the value of the cards Rank
     */
    public String getRank()
    {
        return rank;
    }
    /**
     * Retruns the suit of the card
     * @return A copy of the value of the Suit
     */
    public String getSuit()
    {
        return suit;
    }
    /**
     * Returns the value of the card
     * @return A copy of the value of the Card 
     */
    public int getValue()
    {
        return value;
    }
    /**
     * Returns a String representation of the instance variables of the Card
     * @return a String representation of the instance variables of the Card
     */
    @Override
    public String toString()
    {
        return rank+" of "+suit+"("+value+")" + "\n";
    }
    /**
     * Returns true if it's an ace
     * @return If the card is or is not an ace
     */
    public boolean isAce()
    {
        return rank.equalsIgnoreCase("Ace");
    }
    
    /**
     * Checks if the card is visble to the plaeyhr
     * @return True if visible, false if not
     */
    public boolean isVisible()
    {
        return visible;
    }
    
    /**
     * Sets the visibility to the parameter v
     * @param v True or false for visibility
     */
    public void setVisibility(boolean v)
    {
        visible = v;
    }
    
    /**
     * Gets the image representing the front or back of the Card
     * @return The image corresponding
     */
    public ImageIcon getImage()
    {
        if(isTable)
        {
            return table;
        }
        else if(visible)
        {
            return face;
        }
        else
        {
            return backing;
        }
    }
    
    /**
     * Sets the variable isTable to true or false. This represents whether or 
     * not the card is colored like the table
     * @param t True or false to be isTable
     */
    public void setTable(boolean t)
    {
        isTable = t;
    }
}
