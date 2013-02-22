package BlackJack;

public abstract class Player extends Person
{
    protected int money;
    protected Hand hand;

    protected Player(String n, int m)
    {
        super(n);
        money = m;
    }




}
