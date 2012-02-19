/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.applet.Applet;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jordan
 */
public class BlackJackAppletGridBagLayout extends JApplet {

    private JPanel topPanel;
    private GridBagConstraints c;
    public void init() 
    {
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setBackground(Color.green);
        setLayout(new GridBagLayout());
        topPanel = new JPanel();
        c = new GridBagConstraints();
        
        JButton button1 = new JButton("Herp Derp");
        c.gridwidth = 2;
        c.weightx = 500;
        c.gridx = 1;
        c.gridy = 50;
        topPanel.add(button1, c);
        
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 5;
        
        topPanel.add(new JButton("OMG aids"), c);
        
        
        add(topPanel);
        // TODO start asynchronous download of heavy resources
    }
    // TODO overwrite start(), stop() and destroy() methods
    //TUTORIAL: http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
}
