package BlackJack;

import javax.swing.ImageIcon;

/**
 * This is the basis of the entire game, the card class. The most 
 * fundamental unit of play in the entire game. Enjoy :)
 * 1/26/12
 * @author Jordan Giacone
 */
public class Card implements Comparable<Card>
{
    private final String RANK, SUIT, FACE_LOCATION, BACK_LOCATION = "images/back-blue-150-3.png",
            TABLE_LOCATION = "images/tableColor.png";
    private final ImageIcon FACE, BACKING = new ImageIcon(BACK_LOCATION), TABLE = new ImageIcon(TABLE_LOCATION);
    private int value;
    private boolean visible, isTable;

    /**
     * Constructs a card with given rank, suit, and value
     * @param newRank The Rank of the card (Queen, ten, Ace)
     * @param newSuit The suit of the card (Spade, Hearts, Diamonds)
     * @param newValue The value of the card(1,11,10)
     */
    public Card(String newRank, String newSuit, int newValue)
    {
        RANK = newRank;
        SUIT = newSuit;
        value = newValue;
        FACE_LOCATION = "images/" + RANK + SUIT + ".png";
        FACE = new ImageIcon(FACE_LOCATION);
        visible = true;
        isTable = false;
        
    }

    /**
     * This is a clone constructor that copies the instance variables of the
     * card object passed in
     * @param c The Card object to be "copied"
     */
    public Card(Card c)
    {
        RANK = c.RANK;
        SUIT = c.SUIT;
        value = c.value;
        visible = c.visible;
        FACE_LOCATION = c.FACE_LOCATION;
        FACE = c.FACE;
    }
    /**
     * Flips the value of the ace. If the param is true, then it flips to one
     * @param toOne The parameter that tells if the ace should be flipped to one
     */
    public void setAce(boolean toOne)
    {
        value = isAce() && toOne ? 1 : 11;
    }
    /**
     * Returns the RANK of the card
     * @return A copy of the value of the cards Rank
     */
    public String getRank()
    {
        return RANK;
    }
    /**
     * Retruns the suit of the card
     * @return A copy of the value of the Suit
     */
    public String getSuit()
    {
        return SUIT;
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
        return RANK + " of " + SUIT + "(" + value + ")" + "\n";
    }
    /**
     * Returns true if it's an ace
     * @return If the card is or is not an ace
     */
    public boolean isAce()
    {
        return RANK.equalsIgnoreCase("Ace");
    }
    
    /**
     * Checks if the card is visible to the player
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
            return TABLE;
        }
        else if(visible)
        {
            return FACE;
        }
        else
        {
            return BACKING;
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

    @Override
    public int compareTo(Card c)
    {
        String s = c.RANK;
        if(s.equalsIgnoreCase("Jack") || s.equalsIgnoreCase("Queen") || s.equalsIgnoreCase("King"))
        {
            switch(s)
            {
                case "Jack":
                    switch(RANK)
                    {
                        case "Jack":
                            return 0;
                        default:
                            return 1;
                    }
                case "Queen":
                    switch (RANK)
                    {
                        case "Queen":
                            return 0;
                        default:
                            return 1;
                    }
                case "King":
                    switch (RANK)
                    {
                        case "King":
                            return 0;
                        default:
                            return 1;
                    }
            }
        }
        return value - c.value;
    }
}
