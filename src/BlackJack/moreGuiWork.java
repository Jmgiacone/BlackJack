/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import org.w3c.dom.events.EventListener;

/**
 *
 * @author Jordan
 */
public class moreGuiWork extends JFrame
{
    JButton showName;
    JLabel hello;
    JTextField text;
    JPanel background;
    String name;
    
    class TextFieldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            name = text.getText();
            JOptionPane.showMessageDialog(null, name);
        }
    }
    public moreGuiWork()
    {
        showName = new JButton("Display name");
        name = "";
        hello = new JLabel("Enter your name: ");
        text = new JTextField("Name, please");
        background = new JPanel();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUp();
    }
    
    private void setUp()
    {
        showName.addActionListener(new TextFieldListener());
        
        background.add(hello);
        background.add(text);
        background.add(showName);
        add(background);
    }
}
