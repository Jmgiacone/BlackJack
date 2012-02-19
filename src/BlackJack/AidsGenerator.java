/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Jordan
 */
public class AidsGenerator extends JFrame
{
    private static int TEXT_AREA_ROW = 10, TEXT_AREA_COLUMN = 30, 
            TEXT_FIELD_COLUMN = 15;
    private JButton go, clear;
    private JLabel textLabel;
    private JTextField textField;
    private JTextArea display;
    private JPanel input;
    private ArrayList<String> aids, notAids;
    
    private class KeyAdapter implements KeyListener
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            go.doClick();
        }
            
        public void keyReleased(KeyEvent e)
        {
            
        }
        public void keyTyped(KeyEvent e)
        {
            
        }
    }
    
    
    private class clearButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            display.setText("");
        }
    }
    private class goButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            display.append(tellIfAids(textField.getText()) + "\n");
            textField.setText("");
        }
    }
    public AidsGenerator()
    {
        aids = new ArrayList<>();
        notAids = new ArrayList<>();
        setUpAids();
        go = new JButton("Does this person have aids?");
        clear = new JButton("Clear Display");
        textLabel = new JLabel("Enter an aids name:");
        textField = new JTextField(TEXT_FIELD_COLUMN);
        textField.addKeyListener(new KeyAdapter());
        display = new JTextArea(TEXT_AREA_ROW, TEXT_AREA_COLUMN);
        display.setEditable(false);
        input = new JPanel();
        
        clear.addActionListener(new clearButtonListener());
        go.addActionListener(new goButtonListener());
        input.add(textLabel);
        input.add(textField);
        input.add(go);
        input.add(clear);
        JScrollPane scroll = new JScrollPane(display);
        input.add(scroll);
        add(input);
    }
    
    private String tellIfAids(String n)
    {
        if(notAids.contains(n))
        {
            return n + " doesn't have aids";
        }
        else if(aids.contains(n))
        {
            return n + " 100% has aids";
        }
        else
        {
            Random r = new Random();
            return n + " isn't in the database, "
                    + "but they have "+(r.nextInt(100) + 1)+"% aids";
            //return "Not in database ("+n+")";
        }
    }
    private void setUpAids()
    {
        aids.add("Nolan");
        aids.add("Spencer");
        aids.add("Tim Choh");
        aids.add("Danny Davis");
        aids.add("Tim Angeles");
        aids.add("Steven");
        notAids.add("Svetty");
        notAids.add("Svetlik");
        notAids.add("Jordan");
        notAids.add("Barry");
        notAids.add("Martin");
        notAids.add("Heichman");
        notAids.add("Sam");
        notAids.add("Alan");
        notAids.add("Nooch");
        notAids.add("Heil Kyle");
        notAids.add("Mein Fuhrer");
        notAids.add("Kyle");
        notAids.add("Bonucci");
        notAids.add("Mom");
        notAids.add("Dad");
        notAids.add("Boo");
        notAids.add("Huskus");
        notAids.add("Claudia");
        notAids.add("Mike");
        notAids.add("Debbi");
        notAids.add("Boo");
        notAids.add("G");
        
        
    }
    
}
