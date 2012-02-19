/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jordan
 */
public class GuiWork extends JFrame
{
    Random r;
    private JPanel background;
    private JButton a,b,c;
    
   
    
    class Button1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            b.setEnabled(true);
            a.setEnabled(false);
            
        }
    }
    
    class Button2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            c.setEnabled(true);
            
        }
    }
    
    class Button3Listerner implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            background.setBackground(new Color(r.nextInt(256), 
                    r.nextInt(256), r.nextInt(256)));
            a.setEnabled(true);
            b.setEnabled(false);
            c.setEnabled(false);
        }
    }
    
    public GuiWork()
    {
        r = new Random();
        background  = new JPanel();
        a = new JButton("Button 1");
        b = new JButton("Button 2");
        c = new JButton("Button 3");
        
        b.setEnabled(false);
        c.setEnabled(false);
        
        initButtons();
        add(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void initButtons()
    {
        background.add(a);
        background.add(b);
        background.add(c);
        
        a.addActionListener(new Button1Listener());
        b.addActionListener(new Button2Listener());
        c.addActionListener(new Button3Listerner());
        
        
    }
}
