/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jordan
 */
public class BlackJackGui extends JFrame
{
    private Person svetty, jordan;
    private JTextField betField; 
    private JPanel topPanel, bottomPanel;
    private JLabel nameLabel, moneyLabel, betLabel;
    private JPanel[] panels;
    private JButton hit, stand, doubleDown, playAgain, betButton;
    
    public BlackJackGui()
    {
        double playerMoney = Double.parseDouble(
                JOptionPane.showInputDialog(
                "How much money did you walk in with?"));
        jordan = new Player(JOptionPane.
                showInputDialog(
                "Hey! Welcome to my casino. What's your name?"), 
                playerMoney);
        svetty = new Dealer("Svetty", 5, (Player)jordan);
        //add(buttons.get(0), BorderLayout.NORTH);
        betField = new JTextField();
        initButtons();
        initPanels();
        initLabels();
        addPieces();
                
    }
    
    private void addPieces()
    {
        add(nameLabel, BorderLayout.NORTH);
        add(moneyLabel, BorderLayout.NORTH);
        add(betLabel, BorderLayout.NORTH);
        add(betField, BorderLayout.NORTH);
        add(betButton, BorderLayout.NORTH);
        
        add(hit, BorderLayout.SOUTH);
        add(stand, BorderLayout.SOUTH);
        add(doubleDown, BorderLayout.SOUTH);
        
    }
    private void initPanels()
    {
        panels = new JPanel[10];
        
        for(int i = 0; i < panels.length; i++)
        {
            panels[i] = new JPanel();
        }
    }
    
    private void initLabels()
    {
        nameLabel = new JLabel("Player: ");
        moneyLabel = new JLabel("Current Cash: ");
    }
    private void initButtons()
    {
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        doubleDown = new JButton("Double Down");
        playAgain = new JButton("Again?");
        playAgain.setEnabled(false);
        betButton = new JButton("Bet!");
    }
}
