package BlackJack;

/**
 * Created with IntelliJ IDEA.
 * User: Jordan
 * Date: 2/18/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dealer extends Person
{
    protected Hand hand;

    protected Dealer(String n)
    {
        super(n);
    }

    public int getHandValue()
    {
        return hand.getValue();
    }

    public void hit(Card c)
    {
        hand.add(c);
    }

    public Hand getHand()
    {
        return hand;
    }

    public int getNumCards()
    {
        return hand.numCards();
    }
}
