/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author player
 */
public class JFrameGridBagLayout extends JFrame
{
    private Dealer dealer;
    private Player player;
    private JPanel textFieldPanel, buttonPanel,middlePanel; 
    private JButton hit, stand, doubleDown, start, betButton, insurance, 
            split, playAgain;
    private JTextField betField;
    private JLabel moneyLabel, nameLabel, betLabel;
    private boolean firstTime;

    
    /*while(!done)
        {
            setCards();
                
            if(hasAceShowing())
            {
                
                
            }
            else if(player.hasBlackJack() && hasBlackJack())
            {
                //Push
            }
            else if(player.hasBlackJack() || hasBlackJack())
            {
                //Skip to results method
            }
            else
            {
                playerHand();
                dealerHand();
            }
            
            results();
            cleanUp();
            done = isDone();
        }*/
    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            setCards();
            setUpMiddle();

            start.setEnabled(false);
            hit.setEnabled(true);
            stand.setEnabled(true);
            doubleDown.setEnabled((canDoubleDown()));
            split.setEnabled(canSplit());
            insurance.setEnabled(canGetInsurance());
        }
    }
    private class KeyAdapter implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
                betButton.doClick();
            }
        }
            
        public void keyReleased(KeyEvent e)
        {
            
        }
        public void keyTyped(KeyEvent e)
        {
            
        }
    }
    private class HitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            player.hit(dealer.draw());
            setUpMiddle();
            
            if(player.hasFiveCardCharlie() || player.hasBlackJack() || player.isBust())
            {
                hit.setEnabled(false);
                stand.setEnabled(false);
                doubleDown.setEnabled(false);
                split.setEnabled(false);
                insurance.setEnabled(false);
                JOptionPane.showMessageDialog(null,results());
                resetMoneyLabels();
                cleanUp();
                setUpMiddle();
                
            }
        }
    }
    
    private class BetButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(betField.getText().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a bet first");
            }
            else
            {
                try
                {
                    double bet = Double.parseDouble(betField.getText());

                    if(bet > 0)
                    {
                        if(bet <= player.getMoney())
                        {
                            player.bet(bet);
                        }
                        else//Tried to bet more than they had
                        {
                            JOptionPane.showMessageDialog(null, "Please bet "
                                    + "anything less than your current bankroll");
                            betField.setText("");
                        }
                    }
                    else //Tried to bet 0 or negative
                    {
                        JOptionPane.showMessageDialog(null, "Please bet a positive "
                                + "amount of money");
                        betField.setText("");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "That's not a real bet!");
                    betField.setText("");
                }
                if(player.getBet() != 0)
                {
                    resetMoneyLabels();
                    start.setEnabled(true);
                    betField.setText("");
                    betButton.setEnabled(false);
                }
            }
        }
    }
    private class AgainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
            playAgain.setEnabled(false);
            hit.setEnabled(false);
            stand.setEnabled(false);
            doubleDown.setEnabled(false);
            split.setEnabled(false);
            insurance.setEnabled(false);
            betButton.setEnabled(true);
        }
    }
    private class StandListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            dealerHand();
            dealer.getHand().get(1).setVisibility(true);
            setUpMiddle();
            JOptionPane.showMessageDialog(null,results());
            resetMoneyLabels();
            cleanUp();
            setUpMiddle();
        }
    }
    public JFrameGridBagLayout()
    {
        firstTime = true;
        initPlayer();
        initComponents();
        addComponents();
        setUpMiddle();
    }
    
    private void initPlayer()
    {
        String name = JOptionPane.
                showInputDialog(
                "Hey! Welcome to the Giacone Casino. What's your name?");
        double money = 0.0;
        int numDecks = 0;
        try
        {
            money = Double.parseDouble(
                JOptionPane.showInputDialog(
                "Hey "+name+"! How much money did you have on you?"));
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Not a real number!");
            initPlayer();
        }
        
        try
        {
            numDecks = Integer.parseInt(
                JOptionPane.showInputDialog(
                "How many decks would you like me to incorporate into the shoe?"));
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Not a real number!");
            initPlayer();
        }
        player = new Player(name, money); 
        dealer = new Dealer("Svetty", numDecks, player);
    }
    private void initLabels()
    {
        moneyLabel = new JLabel("Current Bankroll: $"+player.getMoney());
        nameLabel = new JLabel("Name: "+player.getName());
        betLabel = new JLabel("Bet: "+player.getBet());
    }
    private void initPanels()
    {
        buttonPanel = new JPanel(new GridLayout(1, 8, 1, 0));
        textFieldPanel = new JPanel(new GridLayout(1, 5, 1, 0));
        middlePanel = new JPanel(new GridBagLayout());
            
    }
    private void resetMoneyLabels()
    {
        betLabel.setText("Bet: $"+player.getBet());
        moneyLabel.setText("Current Bankroll: $"+player.getMoney());
    }
    private void initButtons()
    {
        start = new JButton("Start Game");
        start.addActionListener(new StartListener());
        start.setEnabled(false);
        hit = new JButton("Hit");
        hit.addActionListener(new HitListener());
        hit.setEnabled(false);
        stand = new JButton("Stand");
        stand.addActionListener(new StandListener());
        stand.setEnabled(false);
        doubleDown = new JButton("Double Down");
        doubleDown.setEnabled(false);
        betButton = new JButton("Bet!");
        betButton.addActionListener(new BetButtonListener());
        insurance = new JButton("Insurance");
        insurance.setEnabled(false);
        split = new JButton("Split");
        split.setEnabled(false);
        playAgain = new JButton("Play Again");
        playAgain.setEnabled(false);
        playAgain.addActionListener(new AgainListener());
    }
    public /*private*/ void dealerHand()
    {
        while(dealer.isBelowHard17())
        {
            dealer.hit(dealer.draw());
        }
    }
    public /*private*/ void cleanUp()
    {
        dealer.clearHand();
        player.clearHand();
        
        if(dealer.getShoe().size() <= 20)
        {
            dealer.reDoCards();
        }
    }
    private void initComponents()
    {
        initPanels();
        initButtons();
        initLabels();
        
        betField = new JTextField("");
        betField.addKeyListener(new KeyAdapter());
    }
    
    private void setUpMiddle()
    {
        
        GridBagConstraints c = new GridBagConstraints();

        if(player.getNumCards() == 0)
        {
            if(firstTime)
            {
                c.gridwidth = 5;
                c.gridy = 1; 
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert.png")), c);
                middlePanel.setBackground(new Color(0,100,0));
                add(middlePanel, BorderLayout.CENTER);
                firstTime = false;
            }
            else//Reset to green table before pressing play again
            {
                middlePanel.removeAll();
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert.png")), c);
                middlePanel.validate();
                setSize(800, 701);
                setSize(800, 700);
            }
                
            
        }
        else
        {
            middlePanel.removeAll();
            c.gridwidth = 5;
            middlePanel.add(dealer.getCards(), c);

            c.gridy = 1; 
            middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert.png")), c);
            c.gridy = 2;
            middlePanel.add(player.getCards(), c);
            middlePanel.validate();
        }
        
    }
    
    public String results()
    {
        hit.setEnabled(false);
        stand.setEnabled(false);
        doubleDown.setEnabled(false);
        split.setEnabled(false);
        insurance.setEnabled(false);
        playAgain.setEnabled(true);
        if(player.hasInsurance() && dealer.hasBlackJack())
        {
            player.winInsurance();
            return "Congratulations, you won your Insurance bet!";
        }
        
        if(player.hasBlackJack())
        {
            player.win();
            return player.name + " has a BlackJack, they automatically win";
        }
        else if(dealer.hasBlackJack())
        {
            player.lose();
            return "The dealer has a BlackJack, they automatically win";
        }
        else if(player.hasFiveCardCharlie())
        {
            player.win();
            return player.name + " has a Five Card Charlie, they automatically "
                    + "win";
        }
        else if(dealer.hasFiveCardCharlie())
        {
            player.lose();
            return dealer.getName() + " the Dealer has a Five Card Charlie, "
                    + "they automatically win";
        }
        else if(player.isBust())
        {
            //Dealer wins
            player.lose();
            return "Sorry, "+player.getName()+". Your hand is a bust. "
                    + "The dealer wins";
        }
        else if(dealer.isBust())
        {
            player.win();
            return "The Dealer's hand is a bust, "+player.name+" wins the round";
        }
        else if(player.getHandValue() > dealer.getHandValue())
        {
            player.win();
            return player.getName()+" with "+player.getHandValue()+", "
                    + "beats the Dealers "+dealer.getHandValue();
        }
        else if(player.getHandValue() < dealer.getHandValue())
        {
            //player loses :(
            player.lose();
            return "Sorry, "+player.getName()+" but your "+player.getHandValue()
                    +" wasn't higher than the Dealer's "+dealer.getHandValue();
        }
        else if(player.getHandValue() == dealer.getHandValue())
        {
            //push
            player.push();
            return "This game is a push. Neither side wins and money is returned";
        }
        
        return "Exception not coded for" + dealer.getHand() + player.getHand();
    }
    private void addComponents()
    {
        textFieldPanel.add(nameLabel);
        textFieldPanel.add(moneyLabel);
        textFieldPanel.add(betLabel);
        textFieldPanel.add(betField);
        textFieldPanel.add(betButton);
        
        buttonPanel.add(start);
        buttonPanel.add(hit);
        buttonPanel.add(stand);
        buttonPanel.add(doubleDown);
        buttonPanel.add(insurance);
        buttonPanel.add(split);
        buttonPanel.add(playAgain);
        
        add(textFieldPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public /*private*/ void setCards()
    {
        //Cards dealt as player,dealer,player,dealer
        player.hit(dealer.draw());
        dealer.hit(dealer.draw());
        player.hit(dealer.draw());
        dealer.hit(dealer.draw());
        
        dealer.getHand().get(1).setVisibility(false);
        dealer.getHand().get(1).setTable(false);
        
        
        
    }
    private boolean canDoubleDown()
    {
        return player.getNumCards() == 2;
    }
    
    private boolean canSplit()
    {
        return player.getHand().get(0).getRank().
                equalsIgnoreCase(player.getHand().get(1).getRank()) 
                && player.getNumCards() == 2;
    }
    
    private boolean canGetInsurance()
    {
        return dealer.upCardIsAce();
    }
}
