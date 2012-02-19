/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import javax.swing.JFrame;

/**
 *
 * @author Jordan
 */
public class AidsRunner 
{
    public static void main(String[] args)
    {
        AidsGenerator a = new AidsGenerator();
        
        a.setTitle("Jordan's Aids Generator");
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(400, 300);
    }
    
}
