/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jordan
 */
public class BlackJackApplet extends JApplet 
{
    Person q = new Player("Jordan", 1000), 
            d = new Dealer("Svetty", 5, (Player)q);
    
    Player p = (Player)q;
    
    private JPanel textFieldPanel, buttonPanel; 
    private JButton hit, stand, doubleDown, playAgain, betButton, insurance;
    private JTextField betField;
    private JLabel moneyLabel, nameLabel, betLabel;
    

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() 
    {
        betField = new JTextField("");
        textFieldPanel = new JPanel(new GridLayout(1, 6));
        buttonPanel = new JPanel(new GridLayout(1,3));
        p.hit(new Card("Ace", "Spades", 11));
        p.hit(new Card("Ace", "Spades", 11));
        p.hit(new Card("Ace", "Spades", 11));
        p.hit(new Card("Ace", "Spades", 11));
        p.hit(new Card("Ace", "Spades", 11));
        p.hit(new Card("Ace", "Spades", 11));
        initLabels();
        initButtons();
        initPanels();
        
        addPieces();
    }
    
    private void addPieces()
    {
        add(textFieldPanel, BorderLayout.NORTH);
        
        add(p.updateCards(), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    private void initPanels()
    {
        buttonPanel.add(hit);
        buttonPanel.add(stand);
        buttonPanel.add(doubleDown);
        buttonPanel.add(insurance);
        
        textFieldPanel.add(nameLabel);
        textFieldPanel.add(betLabel);
        textFieldPanel.add(betField);
        textFieldPanel.add(betButton);
        textFieldPanel.add(moneyLabel);
    }
    
    private void initLabels()
    {
        nameLabel = new JLabel("Player: "+p.getName());
        moneyLabel = new JLabel("Current Cash: "+ 1000);
        betLabel = new JLabel("Current Bet: ");
    }
    private void initButtons()
    {
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        doubleDown = new JButton("Double Down");
        playAgain = new JButton("Again?");
        playAgain.setEnabled(false);
        betButton = new JButton("Bet!");
        insurance = new JButton("Insurance");
        insurance.setEnabled(false);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
