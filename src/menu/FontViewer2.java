package menu;

import javax.swing.JFrame;

/**
   This program uses a menu to display font effects.
*/
public class FontViewer2
{  
   public static void main(String[] args)
   {  
      JFrame frame = new FontViewer2Frame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);      
   }
}

