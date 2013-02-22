package BlackJack;

import javax.swing.*;
import java.awt.*;

public class BlackJackHand extends Hand
{
    public void add(Card c)
    {
        hand.add(c);

        //special ace case
        for(int i = 0; i < numAces(); i++)
        {
            //is there an ace in the hand?
            if(containsAce() && //only if it will bust you :)
                    isBust())
            {
                //Is the value of the ace 11? Hope not
                for(int j = 0; j < numAces(); j++)
                {
                    if(indexOf11Ace() != -1
                            && isBust())
                    {
                        hand.get(indexOf11Ace()).setAce(true);
                    }
                }
            }
        }
    }

    public int getValue()
    {
        int value = 0;
        for(Card c : hand)
        {
            value += c.getValue();
        }

        return value;
    }

    public boolean isBust()
    {
        return getValue() > 21;
    }

    public int numAces()
    {
        int count = 0;

        for(Card c : hand)
        {
            if(c.isAce())
            {
                count++;
            }
        }
        return count;
    }

    public boolean containsAce()
    {
        for(Card c : hand)
        {
            if(c.isAce())
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Tells if the hand totals 21
     * @return True if hand totals 21
     */
    public boolean is21()
    {
        return getValue() == 21;
    }

    /**
     * Tells whether or not the hand is a BlackJack (a 2 card 21 (Ace and Face))
     * @return If the hand is a BlackJack
     */
    public boolean isBlackJack()
    {
        return numCards() == 2 && getValue() == 21;
    }

    /**
     * Returns the index of the card with the given name
     * @return The index of the element. -1 if not present
     */
    private int indexOf11Ace()
    {
        for(Card c : hand)
        {
            if(c.isAce() && c.getValue() == 11)
            {
                return hand.indexOf(c);
            }
        }

        return -1;
    }

    /**
     * Tells whether or not the hand is a 5 card charlie (5 card hand that
     * isn't busted)
     * @return True if the hand has 5 Cards and isn't busted yet
     */
    public boolean isFiveCardCharlie()
    {
        return !isBust() && numCards() == 5;
    }

    public JPanel updateCards()
    {
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());

        c.gridx = 0;

        for(int i = 0; i < hand.size(); i++)
        {
            panel.add(new JLabel(hand.get(i).getImage()), c);
            c.gridx++;
        }

        return panel;
    }
}
