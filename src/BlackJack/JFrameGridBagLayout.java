/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JComboBox;

/**
 *
 * @author player
 */
public class JFrameGridBagLayout extends JFrame
{
    private JFrame choice = new JFrame(), load = new JFrame();;
    private Dealer dealer;
    private Player player;
    private JPanel textFieldPanel, buttonPanel,middlePanel; 
    private JButton hit, stand, doubleDown, start, betButton, insurance, 
            split, nextRound, save;
    private JComboBox dropDown = new JComboBox(new File("saves").listFiles());
    private JTextField betField;
    private JLabel moneyLabel, nameLabel, betLabel;
    private boolean firstTime, splitting, lastSplit, firstBet, asksInsurance, spanish;
    private double money;
    private int numDecks;
    
    private class newGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            choice.setVisible(false);
            choice.setSize(0,0);
            newGame();
        }
    }
    
    private class SaveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                save();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    private class loadListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            load.setVisible(false);
            load.setSize(0,0);
            load();
        }
    }
    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            deal();
        }
    }
    private class HitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hit();
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
    
    private class LoadFileListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                loadFile((File)dropDown.getSelectedItem());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
    private class BetButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            bet();
        }
    }
    private class AgainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            playAgain();
        }
    }
    private class StandListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            stand();
        }
    }
    
    private class DoubleDownListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doubleDown();
        }
    }
    
    private class InsuranceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            insurance();
        }
    }
    private class SplitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            split();
        }
    }
    public JFrameGridBagLayout()
    {
        asksInsurance = false;
        firstTime = true;
        splitting = false;
        lastSplit = false;
        firstBet = true;
        newOrLoadBox();
    }
    
    private void initPlayer()
    {
        String lang = JOptionPane.showInputDialog("Would you like to play in Spanish or English?");
        
        if(lang.equalsIgnoreCase("Spanish") || lang.equalsIgnoreCase("Espanol"))
        {
            spanish = true;
        }
        else if(lang.equalsIgnoreCase("English"))
        {
            spanish = false;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "That's not a language...");
            spanish = false;
            initPlayer();
        }
        
        String name;
        if(!spanish)
        {
            name = JOptionPane.
                    showInputDialog(
                    "Hey! Welcome to the Giacone Casino. What's your name?");

            if(name.equalsIgnoreCase("Tim Choh"))
            {
                JOptionPane.showMessageDialog(null, "Sorry, we don't serve Tim Chohs' here");
                System.exit(0);
            }
            try
            {
                money = Double.parseDouble(
                    JOptionPane.showInputDialog(
                    "Hey "+name+"! How much money do you have on you?"));
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Not a real number!");
                initPlayer();
            }

            if(money <= 0)
            {
                JOptionPane.showMessageDialog(null, "If you don't have any money, then get out");
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

            if(numDecks <= 0)
            {
                JOptionPane.showMessageDialog(null, "There has to be at least one deck");
                initPlayer();
            }
        }
        else
        {
            name = JOptionPane.
                    showInputDialog(
                    "!Hola! Bienvenidos al Casino de Jorge 'El Jefe' Giacone."
                    + "?Como te llamas?");

            if(name.equalsIgnoreCase("Tim Choh"))
            {
                JOptionPane.showMessageDialog(null, "Lo siento, no podemos servirle porque su nombre es Tim Choh. "
                        + "Hasta luego!");
                System.exit(0);
            }
            try
            {
                money = Double.parseDouble(
                    JOptionPane.showInputDialog(
                    "Hola "+name+"! Cuanto dinero tienes?"));
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "No es un numero real");
                initPlayer();
            }

            if(money <= 0)
            {
                JOptionPane.showMessageDialog(null, "Si no tengas dinero, salgas");
                initPlayer();
            }
            try
            {
                numDecks = Integer.parseInt(
                    JOptionPane.showInputDialog(
                    "Cuantas 'decks' de tarjetas quieres?"));
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "No es un numero real");
                initPlayer();
            }

            if(numDecks <= 0)
            {
                JOptionPane.showMessageDialog(null, "Necisita estar un 'deck'");
                initPlayer();
            }
        }
        
        player = new Player(name, money); 
        dealer = new Dealer("Svetty", numDecks, player);
    }
    private void initLabels()
    {
        if(spanish)
        {
            moneyLabel = new JLabel("Su Dinero: $"+player.getMoney());
            nameLabel = new JLabel("Nombre: "+player.getName());
            betLabel = new JLabel("Bet: "+player.getBet());
        }
        else
        {
            moneyLabel = new JLabel("Current Bankroll: $"+player.getMoney());
            nameLabel = new JLabel("Name: "+player.getName());
            betLabel = new JLabel("Bet: "+player.getBet());
        }
    }
    private void initPanels()
    {
        buttonPanel = new JPanel(new GridLayout(1, 8, 1, 0));
        textFieldPanel = new JPanel(new GridLayout(1, 5, 1, 0));
        middlePanel = new JPanel(new GridBagLayout());
            
    }
    
    private double betCheck(String aBet)
    {
        try
        {
            double bet = Double.parseDouble(aBet);

            if(bet > 0)
            {
                if(asksInsurance)
                {
                    if(bet <= player.getBet() / 2)
                    {
                        asksInsurance = false;
                        return bet;
                    }
                }
                else
                {
                    if(bet <= player.getMoney())
                    {
                        return bet;
                    }
                }
                
                if(bet > player.getMoney())//Tried to bet more than they had
                {
                    JOptionPane.showMessageDialog(null, "Please bet "
                            + "anything less than your current bankroll");
                    betField.setText("");
                    firstBet = false;
                    bet();
                }
            }
            else //Tried to bet 0 or negative
            {
                JOptionPane.showMessageDialog(null, "Please bet a positive "
                        + "amount of money");
                betField.setText("");
                firstBet = false;
                bet();
            }
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "That's not a real bet!");
            betField.setText("");
            firstBet = false;
            bet();
        }
        return -1;
    }
    private void resetMoneyLabels()
    {
        betLabel.setText("Bet: $"+player.getBet());
        moneyLabel.setText("Current Bankroll: $"+player.getMoney());
    }
    private void initButtons()
    {
        if(spanish)
        {
            start = new JButton("Recibir las tarjetas");
            hit = new JButton("Pega");
            stand = new JButton("Levanta");
            doubleDown = new JButton("Debajo Doble");
            betButton = new JButton("Bet!");
            insurance = new JButton("Insurancia");
            split = new JButton("Split");
            nextRound = new JButton("Juego Nuevo");
            save = new JButton("Salvo");
        }
        else
        {
            start = new JButton("Deal Cards");
            hit = new JButton("Hit");
            stand = new JButton("Stand");
            doubleDown = new JButton("Double Down");
            betButton = new JButton("Bet!");
            insurance = new JButton("Insurance");
            split = new JButton("Split");
            nextRound = new JButton("Next Round");
            save = new JButton("save");
        }
        
        start.addActionListener(new StartListener());
        start.setEnabled(false);
        hit.addActionListener(new HitListener());
        hit.setEnabled(false);
        stand.addActionListener(new StandListener());
        stand.setEnabled(false);
        doubleDown.setEnabled(false);
        doubleDown.addActionListener(new DoubleDownListener());
        betButton.addActionListener(new BetButtonListener());
        insurance.addActionListener(new InsuranceListener());
        insurance.setEnabled(false);
        split.setEnabled(false);
        split.addActionListener(new SplitListener());
        nextRound.setEnabled(false);
        nextRound.addActionListener(new AgainListener());
        save.setEnabled(false);
        save.addActionListener(new SaveListener());
    }
    public /*private*/ void dealerHand()
    {
        if(dealer.hasBlackJack())
        {
            
        }
        else
        {
            while(!dealer.isHard17() && dealer.getNumCards() < 5)
            {
                dealer.hit(dealer.draw());
            }
        }
        dealer.getHand().get(1).setVisibility(true);
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
    
    private void setGamePlayButtons(boolean set)
    {
        hit.setEnabled(set);
        stand.setEnabled(set);
        doubleDown.setEnabled(set);
        split.setEnabled(set);
        insurance.setEnabled(set);
                
    }
    
    private void playAgain()
    {
        if(player.getMoney() > 0)
        {
            save.setEnabled(false);
            nextRound.setEnabled(false);
            hit.setEnabled(false);
            stand.setEnabled(false);
            doubleDown.setEnabled(false);
            split.setEnabled(false);
            insurance.setEnabled(false);
            betButton.setEnabled(true);
        }
        else if(player.getMoney() == 0)
        {
            if(spanish)
            {
                JOptionPane.showMessageDialog(null, "No tienes dinero, y no "
                        + "te serviran. Hasta luego!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Since you have no money, "
                        + "you're no longer welcome. Have a nice life!");
            }
            System.exit(0);
        }
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
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert_big.png")), c);
                middlePanel.setBackground(new Color(0,100,0));
                add(middlePanel, BorderLayout.CENTER);
                firstTime = false;
            }
            else//Reset to green table before pressing Next Round
            {
                middlePanel.removeAll();
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert_big.png")), c);
                middlePanel.validate();
                setSize(getWidth(), getHeight() + 1);
                setSize(getWidth(), getHeight());
            }
        }
        else
        {
            if(splitting)
            {
                middlePanel.removeAll();
                c.gridwidth = 5;
                middlePanel.add(dealer.getCards(), c);

                c.gridy = 1; 
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert_big.png")), c);
                c.gridy = 2;
                middlePanel.add(player.getPrimaryCards(), c);
                middlePanel.validate();
                setSize(getWidth(), getHeight() + 1);
                setSize(getWidth(), getHeight());
            }
            else
            {
                middlePanel.removeAll();
                c.gridwidth = 5;
                middlePanel.add(dealer.getCards(), c);

                c.gridy = 1; 
                middlePanel.add(new JLabel(new ImageIcon("images/150x215/tableAdvert_big.png")), c);
                c.gridy = 2;
                middlePanel.add(player.getPrimaryCards(), c);
                middlePanel.validate();
            }
        }
        
    }
    
    public void hit()
    {
        player.hit(dealer.draw());
        doubleDown.setEnabled(canDoubleDown());
        if(splitting)
        {
            split.setEnabled(canSplit());
            doubleDown.setEnabled(canDoubleDown());
        }
        
        setUpMiddle();

        if(player.hasFiveCardCharlie() || player.hasBlackJack() || player.isBust())
        {
            JOptionPane.showMessageDialog(null,results());
            resetMoneyLabels();
            if(splitting)
            {
                if(lastSplit)
                {
                    setGamePlayButtons(false);
                    cleanUp();
                    nextRound.setEnabled(true);
                }
                else
                {
                    secondSplitBet();
                }
            }
            else
            {
                setGamePlayButtons(false);
                save.setEnabled(true);
                cleanUp();
            }
            setUpMiddle();
            nextRound.setEnabled(true);
        }
    }
    public void stand()
    {
        dealerHand();
        setUpMiddle();
        JOptionPane.showMessageDialog(null,results());
        resetMoneyLabels();

        if(splitting)
        {
            if(lastSplit)
            {
                setGamePlayButtons(false);
                cleanUp();
                nextRound.setEnabled(true);
            }
            else
            {
                player.clearHand();
                if(player.getBet() == 0)
                {
                    double bet = -1;

                    while(player.getBet() == 0)
                    {
                        if(spanish)
                        {
                           try
                            {
                                bet = Double.parseDouble(JOptionPane.
                                        showInputDialog("Pon su dinero aqui por favor"));
                            }
                            catch(NumberFormatException ex)
                            {
                                JOptionPane.showMessageDialog(null, "No es un numero");
                            }

                            if(bet > player.getMoney())
                            {
                                JOptionPane.showMessageDialog(null, "Paga lo que puedes por favor");
                            }
                            else if(bet <= 0)
                            {
                                JOptionPane.showMessageDialog(null, "Quiero 'bets' que estan arriba de zero");
                            }
                            else
                            {
                               player.bet(bet);
                            } 
                        }
                        else
                        {
                            try
                            {
                                bet = Double.parseDouble(JOptionPane.
                                        showInputDialog("Please enter your second split bet"));
                            }
                            catch(NumberFormatException ex)
                            {
                                JOptionPane.showMessageDialog(null, "That's not a number");
                            }

                            if(bet > player.getMoney())
                            {
                                JOptionPane.showMessageDialog(null, "Bet what you're able to");
                            }
                            else if(bet <= 0)
                            {
                                JOptionPane.showMessageDialog(null, "Only positve bets please");
                            }
                            else
                            {
                               player.bet(bet);
                            }
                        }
                    }
                }
                resetMoneyLabels();
                player.split2();
                if(spanish)
                {
                    JOptionPane.showMessageDialog(null, "Este es split dos");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "This is split 2");
                }
                lastSplit = true;
                setGamePlayButtons(false);
                nextRound.setEnabled(true);
            }
        }
        else
        {
            cleanUp();
            setGamePlayButtons(false);
            save.setEnabled(true);
            nextRound.setEnabled(true);
        }
        setUpMiddle();
    }
    public void doubleDown()
    {
        //Double bet
        //One more card, then forced stand
        player.doubleDown();
        resetMoneyLabels();
        player.hit(dealer.draw());
        setUpMiddle();
        dealerHand();
        setUpMiddle();
        JOptionPane.showMessageDialog(null, results());
        
        if(splitting)
        {
            if(lastSplit)
            {
                setGamePlayButtons(false);
                cleanUp();
                nextRound.setEnabled(true);
            }
            else
            {
                secondSplitBet();
            }
        }
        else
        {
            setGamePlayButtons(false);
            resetMoneyLabels();
            nextRound.setEnabled(true);
            save.setEnabled(true);
            cleanUp();
        }
        setUpMiddle();
    }
    public void split()
    {
        //Primary hands?
        splitting = true;
        if(spanish)
        {
            JOptionPane.showMessageDialog(null, "Este es split uno");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "This is split 1");
        }
        player.split1();
        setUpMiddle();
        split.setEnabled(false);
        canSplit();
    }
    public void deal()
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
    public void insurance()
    {
        asksInsurance = true;   
        double bet = 0;

        while(bet <= 0)
        {
            if(spanish)
            {
                bet = betCheck(JOptionPane.showInputDialog(
                         "Pon su Bet de insurencia (no mas que $"
                         +player.getBet() / 2+")"));
            }
            else
            {
            
                bet = betCheck(JOptionPane.showInputDialog(
                         "Enter your Insurance Bet(no more than"
                         +player.getBet() / 2+")"));
            }
        }
        player.insurance(bet);
        
        resetMoneyLabels();
        insurance.setEnabled(false);
    }
    public void bet()
    {
        double maybeBet = 0;
        if(betField.getText().equalsIgnoreCase(""))
        {
            if(firstBet)
            {
                if(spanish)
                {
                    JOptionPane.showMessageDialog(null, "Por favor, pon su bet primera");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter a bet first");
                }
            }
        }
        else
        {
            maybeBet = betCheck(betField.getText());
            
            if(maybeBet > 0)
            {
                player.bet(maybeBet);
                resetMoneyLabels();
                start.setEnabled(true);
                betField.setText("");
                betButton.setEnabled(false);
            }
        }
    }
    public String results()
    {
        if(spanish)
        {
            if(player.hasInsurance() && dealer.hasBlackJack())
            {
                player.winInsurance();
                return "Congratulaciones! Ganaste su propio de insurancia";
            }

            if(player.hasBlackJack() && dealer.hasBlackJack())
            {
                player.lose();
                return "El dealer gana porque uds. tienen un 'blackjack'";
            }
            else if(player.hasBlackJack())
            {
                player.win();
                return player.name + " tiene un Blackjack";
            }
            else if(dealer.hasBlackJack())
            {
                player.lose();
                return "El dealer tiene blackjack";
            }
            else if(player.hasFiveCardCharlie() && dealer.hasFiveCardCharlie())
            {
                player.lose();
                return "Uds. tienen un Charlie de 5 tarjetas, el dealer gana";
            }
            else if(player.hasFiveCardCharlie())
            {
                player.win();
                return player.name + " tiene un Charlie de 5 tarjetas, tu ganas";
            }
            else if(dealer.hasFiveCardCharlie())
            {
                player.lose();
                return "El Dealer tiene un Charlie de 5 tarjetas, "
                        + "el gana";
            }
            else if(player.isBust() && dealer.isBust())
            {
                player.push();
                return "Uds. son 'bust' y nadie gana o pierde";
            }
            else if(player.isBust())
            {
                //Dealer wins
                player.lose();
                return "Lo siento, "+player.getName()+". su mano es 'bust'. Tu pierdes";
            }
            else if(dealer.isBust())
            {
                player.win();
                return "La mano del Dealer es un 'bust', "+player.name+" gana";
            }
            else if(player.getHandValue() > dealer.getHandValue())
            {
                player.win();
                return player.getName()+" con "+player.getHandValue()+", "
                        + "es mas que "+dealer.getHandValue()+" del dealer";
            }
            else if(player.getHandValue() < dealer.getHandValue())
            {
                //player loses :(
                player.lose();
                return "Lo siento, "+player.getName()+" pero tu "+player.getHandValue()
                        +" no es mas que el "+dealer.getHandValue()+" del Dealer";
            }
            else if(player.getHandValue() == dealer.getHandValue())
            {
                //push
                player.lose();
                return "Las dos manos son iguales, el dealer gana";
            }
        }
        else
        {
            if(player.hasInsurance() && dealer.hasBlackJack())
            {
                player.winInsurance();
                return "Congratulations, you won your Insurance bet!";
            }

            if(player.hasBlackJack() && dealer.hasBlackJack())
            {
                player.lose();
                return "Both parties have a BlackJack, the dealer breaks all ties, "
                        + "so you lose";
            }
            else if(player.hasBlackJack())
            {
                player.win();
                return player.name + " has a BlackJack, they automatically win";
            }
            else if(dealer.hasBlackJack())
            {
                player.lose();
                return "The dealer has a BlackJack, they automatically win";
            }
            else if(player.hasFiveCardCharlie() && dealer.hasFiveCardCharlie())
            {
                player.lose();
                return "Both parties have a Five Card Charlie, the dealer breaks "
                        + "all ties, so you lose";
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
                return "The Dealer has a Five Card Charlie, "
                        + "they automatically win";
            }
            else if(player.isBust() && dealer.isBust())
            {
                player.push();
                return "Both parties busted, the round is a push";
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
                player.lose();
                return "Both hands are equal, the dealer breaks all ties, "
                        + "so you lose";
            }
        }
        return "Exception not coded for\n" + dealer.getHand() + 
                "\n"+player.getPrimaryHand();
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
        buttonPanel.add(nextRound);
        buttonPanel.add(save);
        
        add(textFieldPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public /*private*/ void setCards()
    {
        //Cards dealt as player,dealer,player,dealer
        
        //Edited for a split every time
        player.hit(/*new Card("Ace", "Spades", 11)*/dealer.draw());
        dealer.hit(/*new Card("Ace", "Spades", 11)*/dealer.draw());
        player.hit(/*new Card("Ace", "Spades", 11)*/dealer.draw());
        dealer.hit(dealer.draw());
        
        dealer.getHand().get(1).setVisibility(false);
        dealer.getHand().get(1).setTable(false);
    }
    private boolean canDoubleDown()
    {
        return player.getNumCards() == 2 && player.getMoney() >= 
                player.getBet();
    }
    
    private boolean canSplit()
    {
        return player.getNumCards() == 2 && 
                player.getPrimaryHand().get(0).getRank().equalsIgnoreCase
                (player.getPrimaryHand().get(1).getRank()) 
                && player.getMoney() > 0;
    }
    
    private boolean canGetInsurance()
    {
        return dealer.upCardIsAce();
    }
    
    private void secondSplitBet()
    {
        player.clearHand();
        //JOptionPane.showInputDialog("Please enter your second bet");

        double aBet = 0;

        while(aBet <= 0)
        {
            aBet = betCheck(JOptionPane.showInputDialog(
                    "Pon su bet segundo aqui"));
        }

        player.bet(aBet);
        resetMoneyLabels();
        player.split2();
        JOptionPane.showMessageDialog(null, "Es split dos");
        lastSplit = true;
    }
    
    private void newOrLoadBox()
    {
        JButton newGame = new JButton("New Game!"), load = new JButton("Load Saved Player");
        load.setEnabled(areSavedPlayers());
        choice.setLayout(new BorderLayout());
        choice.setTitle("What to do?");
        JPanel background = new JPanel();
        newGame.addActionListener(new newGameListener());
        load.addActionListener(new loadListener());
        background.add(newGame);
        background.add(load);
        choice.add(background, BorderLayout.SOUTH);
        choice.setSize(300, 100);
        choice.setVisible(true);
    }
    
    private void load()
    {
        JButton ok = new JButton("Ok!");
        ok.addActionListener(new LoadFileListener());
        load.setLayout(new BorderLayout());
        
        load.add(dropDown, BorderLayout.NORTH);
        load.add(ok, BorderLayout.SOUTH);
        
        load.setVisible(true);
        load.setSize(400, 400);
        
        
        
    }
    
    private void loadFile(File f) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(f);
        
        String[] vars = new String[3];
        int i = 0;
        while(scanner.hasNextLine())
        {
            vars[i] = scanner.nextLine();
            i++;
        }
        
        player = new Player(vars[0], Double.parseDouble(vars[1]));
        dealer = new Dealer("Svetty", 5, player);
        spanish = Boolean.getBoolean(vars[2]);
        initComponents();
        addComponents();
        setUpMiddle();
        
        setUpGameFrame();
        if(spanish)
        {
            JOptionPane.showMessageDialog(null, "Hola "+player.getName()+"!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Welcome back "+player.getName()+"!");
        }
    }
    private void save() throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(new File("saves/"+player.getName()+".txt"));
        
        out.println(player.getName());
        out.println(player.getMoney());
        out.print(spanish);
        out.close();
        
        JOptionPane.showMessageDialog(null, "Your game has been saved");
        save.setEnabled(false);
    }
    private void newGame()
    {
        initPlayer();
        
        initComponents();
        addComponents();
        setUpMiddle();
        
        setUpGameFrame();
    }
    
    private boolean areSavedPlayers()
    {
        return !(new File("saves").listFiles() == null);
    }
    
    private void setUpGameFrame()
    {
        setTitle("Jordan Giacone BlackJack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000, 900);
    }
}
