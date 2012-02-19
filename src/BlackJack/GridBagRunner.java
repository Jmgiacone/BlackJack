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
public class GridBagRunner 
{
    public static void main(String[] args)
    {
        
        JFrameGridBagLayout j = new JFrameGridBagLayout();

        j.setTitle("Jordan Giacone BlackJack");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.setSize(800, 700);
    }
}