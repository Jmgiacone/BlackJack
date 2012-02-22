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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This is the GUI class that runs the entire game. It utilizes a GridBagLayout 
 *  manager to make the board.
 * 2/21/12
 * @author Jordan Giacone
 */
public class BlackJackGUI extends JFrame
{
    private JFrame choice, load, newGame;
    private Dealer dealer;
    private Player player;
    private JPanel textFieldPanel, buttonPanel,middlePanel; 
    private JButton hit, stand, doubleDown, start, betButton, insurance, split, 
            nextRound, save;
    private JRadioButton eng, span;
    private JComboBox dropDown;
    private JTextField betField,name,  moneyField;
    private JLabel moneyLabel, nameLabel, betLabel;
    private boolean firstTime, splitting, lastSplit, firstBet, asksInsurance, 
            spanish;
    
    /**
     * The listener that listens for the ok button on the new game window
     */
    private class NewGameOkListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            newGame.setVisible(false);
            newGame.setSize(0, 0);
            setNewPlayer();
        }
    }
    /**
     * The listener that listens for the new game button on the new or load window
     */
    private class newGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            choice.setVisible(false);
            choice.setSize(0,0);
            newGame();
        }
    }
    
    /**
     * The listener that listens for the save button during play
     */
    private class SaveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try 
            {
                save();
            } 
            catch (FileNotFoundException ex) 
            {
                ex.printStackTrace();//Netbeans forced this here, it's ugly 
                //and useless because it still throws the error
            }
        }
    }
    /**
     * the listener that listens for the load button on the new or load screen
     */
    private class loadListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            load.setVisible(false);
            load.setSize(0,0);
            load();
        }
    }
    /**
     * The listener that listens for the start button on the main game window
     */
    private class StartListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            deal();
        }
    }
    /**
     * The listener that listens for the hit button on the main game window
     */
    private class HitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            hit();
        }
    }
    
    /**
     * The listener that listens for the enter key buing pushed in the bet text field
     * on the main game window
     */
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
            //Needs to be here
        }
        public void keyTyped(KeyEvent e)
        {
            //Needs to be here
        }
    }
    
    /**
     * The listener that listens for the load a file button on the new game window
     */
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
    
    /**
     * The listener that listens for the bet button on the main game window
     */
    private class BetButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            bet();
        }
    }
    
    /**
     * The listener that listens for the play again button on the main game window
     */
    private class AgainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            playAgain();
        }
    }
    
    /**
     * The listener that listens for the stand button on the main game window
     */
    private class StandListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            stand();
        }
    }
    
    /**
     * The listener that listens for the double down button on the main game window
     */
    private class DoubleDownListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            doubleDown();
        }
    }
    
    /**
     * The listener that listens for the insurance button on the main game window
     */
    private class InsuranceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            insurance();
        }
    }
    
    /**
     * The listener that listens for the split button on the main game window
     */
    private class SplitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            split();
        }
    }
    
    /**
     * The main constructor that sets up a lot if initial variables as well as
     * bringing up the 2 smaller gui boxes.
     */
    public BlackJackGUI()
    {
        initFrames();
        initFields();
        initRadioButtons();
        dropDown = new JComboBox(new File("saves").listFiles());
        asksInsurance = false;
        firstTime = true;
        splitting = false;
        lastSplit = false;
        firstBet = true;
        newOrLoadBox();
    }
    
    /**
     * Sets up the labels in spanish or english depending.
     */
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
    
    /**
     * Initializes the panels.
     */
    private void initPanels()
    {
        buttonPanel = new JPanel(new GridLayout(1, 8, 1, 0));
        textFieldPanel = new JPanel(new GridLayout(1, 5, 1, 0));
        middlePanel = new JPanel(new GridBagLayout());
            
    }
    
    /**
     * Checks to make sure that the bet coming in is valid
     * @param aBet The bet to be checked
     * @return The legit bet or -1
     */
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
                    if(spanish)
                    {
                        JOptionPane.showMessageDialog(null, "Por favor, da"
                                + "menos de su dinero");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please bet "
                                + "anything less than your current bankroll");
                    }
                    betField.setText("");
                    firstBet = false;
                    bet();
                }
            }
            else //Tried to bet 0 or negative
            {
                if(spanish)
                {
                    JOptionPane.showMessageDialog(null, "Por favor, pon"
                            + "dinero positiva");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please bet a positive "
                            + "amount of money");
                }
                betField.setText("");
                firstBet = false;
                bet();
            }
        }
        catch(NumberFormatException ex)
        {
            if(spanish)
            {
                JOptionPane.showMessageDialog(null, "No es real!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "That's not a real bet!");
            }
            betField.setText("");
            firstBet = false;
            bet();
        }
        return -1;
    }
    
    /**
     * Resets the BankRoll and Bet labels to reflect current cash
     */
    private void resetMoneyLabels()
    {
        if(spanish)
        {
            betLabel.setText("Bet: $"+player.getBet());
            moneyLabel.setText("Su Dinero: $"+player.getMoney());
        }
        else
        {
            betLabel.setText("Bet: $"+player.getBet());
            moneyLabel.setText("Current Bankroll: $"+player.getMoney());
        }
    }
    
    /**
     * Initializes the buttons for the game
     */
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
            save = new JButton("Save");
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
    
    private void initRadioButtons()
    {
        eng = new JRadioButton("English");
        span = new JRadioButton("Spanish");
        
    }
    /**
     * Handles the dealers hand. Dealer hits until hard 17, blackJack, or 
     * 5 Card Charlie
     */
    public void dealerHand()
    {
        if(dealer.hasBlackJack())
        {
            //Skip dealer AI
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
    
    /**
     * Resets the player and dealer hands and makes sure the shoe is full
     */
    public  void cleanUp()
    {
        dealer.clearHand();
        player.clearHand();
        
        if(dealer.getShoe().size() <= 20)
        {
            dealer.reDoCards();
        }
    }
    
    /**
     * Calls the initPanels and initLables methods. 
     */
    private void initComponents()
    {
        initButtons();
        initPanels();
        initLabels();
    }
    
    /**
     * Initializes the text fields for use in various GUI's
     */
    private void initFields()
    {
        //The 20 spaces are me being lazy and not wanting to bind the new
        //player GUI to a LayoutManager.
        name = new JTextField("                    ");
        moneyField = new JTextField("                    ");
        betField = new JTextField("");
        betField.addKeyListener(new KeyAdapter());
    }
    
    /**
     * Initializes the JFrames to be used before the main game
     */
    private void initFrames()
    {
        choice = new JFrame();
        load = new JFrame();
        newGame = new JFrame();
    }
    
    /**
     * Sets the gameplay buttons(hit,stand,DD,split, insurance) to the param
     * set
     * @param set To set whether or not to have the buttons enabled
     */
    private void setGamePlayButtons(boolean set)
    {
        hit.setEnabled(set);
        stand.setEnabled(set);
        doubleDown.setEnabled(set);
        split.setEnabled(set);
        insurance.setEnabled(set);
    }
    
    /**
     * The method called from the PlayAgainListener. Sets everything except the
     * betting mechanism to false
     */
    private void playAgain()
    {
        if(player.getMoney() > 0)
        {
            save.setEnabled(false);
            nextRound.setEnabled(false);
            setGamePlayButtons(false);
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
    
    /**
     * Sets up the cards/middle splash on the board
     */
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
            else//Reset to green table with middle picture before pressing Next Round
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
                
                //Making sure that images don't accidentally stack on top of each other
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
    
    /**
     * Gives the player another card from the dealers shoe
     */
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
    
    /**
     * The player chooses to stand.
     */
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
                setGamePlayButtons(true);
                nextRound.setEnabled(false);
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
    
    /**
     * Double Down: The player is so confident that their next card is going to 
     * get them close to 21, that they double their bet, take one more card, 
     * and are forced to stand.
     * @precondition Players money must be at least the value of their bet
     */
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
    
    /**
     * When a player has 2 of the same card at the beginning of the round.
     */
    public void split()
    {
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
    
    /**
     * Sets up the game initially
     */
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
    
    /**
     * Insurance: If the dealers upcard is an Ace, the player can place a side 
     * bet of up to 1/2 of their original bet. The player then plays out the 
     * round, and if the dealer has a blackjack, they player wins the insurance
     *  bet 2:1
     */
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
    
    /**
     * Sets the bet for the player
     */
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
    
    /**
     * Goes through all the possible scenarios for winning/losing the game
     * @return The result of the hand
     */
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
    
    /**
     * Adds major components to panels and frames and such
     */
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
    
    /**
     * Initially deals out the cards to the dealer and player
     */
    public  void setCards()
    {
        //Cards dealt as player,dealer,player,dealer
        
        player.hit(dealer.draw());
        dealer.hit(dealer.draw());
        player.hit(dealer.draw());
        dealer.hit(dealer.draw());
        
        dealer.getHand().get(1).setVisibility(false);
        dealer.getHand().get(1).setTable(false);
    }
    
    /**
     * Determines whether or not the player can split
     * @return whether or not the player can split
     */
    private boolean canDoubleDown()
    {
        return player.getNumCards() == 2 && player.getMoney() >= 
                player.getBet();
    }
    
    /**
     * Determines if the player can split their hand
     * @return If the player can or can't split their hand
     */
    private boolean canSplit()
    {
        //Very large and chain ^_^
        return player.getNumCards() == 2 && 
                player.getPrimaryHand().get(0).getRank().equalsIgnoreCase
                (player.getPrimaryHand().get(1).getRank()) 
                && player.getMoney() > 0;
    }
    
    /**
     * Determines if the player can get insurance
     * @return If the player is allowed to get insurance
     */
    private boolean canGetInsurance()
    {
        return dealer.upCardIsAce();
    }
    
    /**
     * Sets up the scenario for the second bet of a split
     */
    private void secondSplitBet()
    {
        player.clearHand();
        
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
    
    /**
     * Brings up a GUI asking if the player would like to start anew or load
     * a saved game
     */
    private void newOrLoadBox()
    {
        JButton newGame = new JButton("New Game!"), 
                load = new JButton("Load Saved Player");
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
    
    /**
     * Brings up a window prompting the location of a player data file
     */
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
    
    /**
     * Actually reads the saved file and sets up a player based on that
     * @param f The file to be read
     * @throws FileNotFoundException If the file doesn't exist
     */
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
        
        if(vars[2].equalsIgnoreCase("true"))
        {
            spanish = true;
        }
        else
        {
            spanish = false;
        }
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
    
    /**
     * Saves the current player to a text file titles with their name
     * @throws FileNotFoundException Not sure why this is here, i'm creating 
     * the directory
     */
    private void save() throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(new File("saves/"+player.getName()+".txt"));
        
        out.println(player.getName());
        out.println(player.getMoney());
        out.print(spanish);
        out.close();
        
        if(spanish)
        {
            JOptionPane.showMessageDialog(null, "Tu juego hubiera estado salvo");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Your game has been saved");
        }
        save.setEnabled(false);
    }
    
    /**
     * Brings up a window prompting for the instance variables of a new game
     */
    private void newGame()
    {
        newGame.setLayout(new BorderLayout());
        
        JButton ok = new JButton("Ok");
        ok.addActionListener(new NewGameOkListener());
        JPanel choices = new JPanel();
        JLabel newNameLabel = new JLabel("Your name"), 
        newMoneyLabel = new JLabel("How much money you have: $"),
        spanishLabel = new JLabel("Spanish or english?");
        ButtonGroup group = new ButtonGroup(); 
        group.add(span);
        group.add(eng);
        
        choices.add(newNameLabel);
        choices.add(name);
        choices.add(newMoneyLabel);
        choices.add(moneyField);
        choices.add(spanishLabel);
        choices.add(span);
        choices.add(eng);
        
        newGame.add(ok, BorderLayout.SOUTH);
        newGame.add(choices, BorderLayout.CENTER);
        newGame.setVisible(true);
        newGame.setSize(300, 300);
    }
    
    /**
     * Tells whether or not there are player saved in the certain directory
     * @return whether or not there are player saved in the certain directory
     */
    private boolean areSavedPlayers()
    {
        return !(new File("saves").listFiles() == null);
    }
    
    /**
     * Sets up the actual frame for the game
     */
    private void setUpGameFrame()
    {
        setTitle("Jordan Giacone BlackJack");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1200, 850);
    }
    
    /**
     * Constructs a new player based on the input from NewGame
     */
    private void setNewPlayer()
    {
        double cash = -9099;//I just randomly hit the keyboard and produced this gem
        try
        {
            cash = Double.parseDouble(moneyField.getText());
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Not a real number");
            newGame();
        }
        if(cash <= 0)
        {
            JOptionPane.showMessageDialog(null, "Bet must be positive");
            newGame();
        }
        else
        {
            String myName = name.getText();
            myName = myName.trim();
            player = new Player(myName , cash);
            dealer = new Dealer("Svetty", 5, player);
            if(span.isSelected())
            {
                spanish = true;
            }
            else if(eng.isSelected())
            {
                spanish = false;
            }
            initComponents();
            addComponents();
            setUpMiddle();
        
            setUpGameFrame();
        }
    }
}