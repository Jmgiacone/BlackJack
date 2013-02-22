package BlackJack;

public abstract class Person
{
    private final String NAME;

    protected Person(final String n)
    {
        NAME = n;
    }

    public final String getName()
    {
        return NAME;
    }
}
