package BlackJack;

public class BlackJackDeck extends Deck
{
    public BlackJackDeck()
    {
        super();
    }

    public BlackJackDeck(Deck d)
    {
        super(d);
    }

    @Override
    protected void setUpDeck()
    {
        String rk = "";
        int v = 0;
        for(int i = 1; i <=13; i++)
        {
            if(i == 1)
            {
                rk = "Ace";
                v = 11;
            }
            else if(i == 2)
            {
                rk = "Two";
                v = 2;
            }
            else if(i == 3)
            {
                rk = "Three";
                v = 3;
            }
            else if(i == 4)
            {
                rk = "Four";
                v = 4;
            }
            else if(i == 5)
            {
                rk = "Five";
                v = 5;
            }
            else if(i == 6)
            {
                rk = "Six";
                v = 6;
            }
            else if(i == 7)
            {
                rk = "Seven";
                v = 7;
            }
            else if(i == 8)
            {
                rk = "Eight";
                v = 8;
            }
            else if(i == 9)
            {
                rk = "Nine";
                v = 9;
            }
            else if(i == 10)
            {
                rk = "Ten";
                v = 10;
            }
            else if(i == 11)
            {
                rk = "Jack";
                v = 10;
            }
            else if(i == 12)
            {
                rk = "Queen";
                v = 10;
            }
            else if(i == 13)
            {
                rk = "King";
                v = 10;
            }

            for(int j = 1; j <= 4; j++)
            {
                String s = "";

                if(j == 1)
                {
                    s = "Spades";
                }
                else if(j == 2)
                {
                    s = "Clubs";
                }
                else if(j == 3)
                {
                    s = "Hearts";
                }
                else if(j == 4)
                {
                    s = "Diamonds";
                }

                deck.add(new Card(rk, s, v));
            }
        }
    }
}
