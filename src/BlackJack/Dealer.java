package BlackJack;

/**
 *
 * @author Jordan
 */
public class Dealer extends Player
{
    Shoe shoe;
    public Dealer(String n, int d)
    {
        super(n);
        shoe = new Shoe(d);
    }
    
    public boolean isAt17()
    {
        return hand.getValue() >= 17;
    }
    
    public void start()
    {
        //Start the game HERE
    }
    
    public Card draw()
    {
        Card c = shoe.getShoe().remove(0);
        shoe.getShoe().add(c);
        return(c);
    }
}
