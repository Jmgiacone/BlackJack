package BlackJack;

public class BlackJackPerson extends Person
{
    private BlackJackHand hand;

    public BlackJackPerson(String n)
    {
        super(n);
        hand = new BlackJackHand();
    }

    public int getHandValue()
    {
        return hand.getValue();
    }

    public void addCard(Card c)
    {
        hand.add(c);
    }

    public Hand getHand()
    {
        return hand;
    }

    public void clearHand()
    {
        hand.clear();
    }
    public void hit(Card c)
    {
        hand.add(c);
    }

    public void setHand(Hand h)
    {
        for(Card c : h.getHand())
        {
            hand.add(c);
        }
    }

    public boolean isBust()
    {
        return hand.isBust();
    }

    public boolean hasFiveCardCharlie()
    {
        return hand.isFiveCardCharlie();
    }

    public boolean hasBlackJack()
    {
        return hand.isBlackJack();
    }

    public int getNumCards()
    {
        return hand.numCards();
    }




}
