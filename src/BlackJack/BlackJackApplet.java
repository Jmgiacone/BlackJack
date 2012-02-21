/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author Jordan
 */
public class BlackJackApplet extends JApplet 
{
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    public void init() 
    {
        add(new JFrameGridBagLayout());
        
        
    }
    
}