/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

/**
 *
 * @author Jordan
 */
public class Dealer extends Player
{
    Shoe s;
    public Dealer(String n)
    {
        super(n);
        s = new Shoe(3);//Change me to user input later
    }
    
    public boolean isAt17()
    {
        return hand.getValue() >= 17;
    }
    
    public void start()
    {
        //Start the game HERE
    }
}
