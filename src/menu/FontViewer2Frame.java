package menu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
   This frame has a menu with commands to change the font 
   of a text sample.
*/
public class FontViewer2Frame extends JFrame
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;
   
   private JLabel sampleField;
   private String facename;
   private int fontstyle;
   private int fontsize;

   /**
      Constructs the frame.
   */
   public FontViewer2Frame()
   {  
      // Construct text sample     
      sampleField = new JLabel("Big Java");
      add(sampleField, BorderLayout.CENTER);

      // Construct menu      
      JMenuBar menuBar = new JMenuBar();     
      setJMenuBar(menuBar);
      menuBar.add(createFileMenu());
      menuBar.add(createFontMenu());

      facename = "Serif";
      fontsize = 24;
      fontstyle = Font.PLAIN;

      setSampleFont();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   /**
      Creates the File menu.
      @return the menu
   */
   public JMenu createFileMenu()
   {
      JMenu menu = new JMenu("File");
      menu.add(createFileExitItem());
      return menu;
   }

   /**
      Creates the File->Exit menu item and sets its action listener.
      @return the menu item
   */
   public JMenuItem createFileExitItem()
   {
      JMenuItem item = new JMenuItem("Exit");      
      class MenuItemListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            System.exit(0);
         }
      }      
      ActionListener listener = new MenuItemListener();
      item.addActionListener(listener);
      return item;
   }

   /**
      Creates the Font submenu.
      @return the menu
   */
   public JMenu createFontMenu()
   {
      JMenu menu = new JMenu("Font");
      menu.add(createFaceMenu());
      menu.add(createSizeMenu());
      menu.add(createStyleMenu());
      return menu;
   }  

   /**
      Creates the Face submenu.
      @return the menu
   */
   public JMenu createFaceMenu()
   {
      JMenu menu = new JMenu("Face");
      menu.add(createFaceItem("Serif"));
      menu.add(createFaceItem("SansSerif"));
      menu.add(createFaceItem("Monospaced"));
      return menu;
   }  

   /**
      Creates the Size submenu.
      @return the menu
   */
   public JMenu createSizeMenu()
   {
      JMenu menu = new JMenu("Size");
      menu.add(createSizeItem("Smaller", -1));
      menu.add(createSizeItem("Larger", 1));
      return menu;
   }  

   /**
      Creates the Style submenu.
      @return the menu
   */
   public JMenu createStyleMenu()
   {
      JMenu menu = new JMenu("Style");
      menu.add(createStyleItem("Plain", Font.PLAIN));
      menu.add(createStyleItem("Bold", Font.BOLD));
      menu.add(createStyleItem("Italic", Font.ITALIC));
      menu.add(createStyleItem("Bold Italic", Font.BOLD 
            + Font.ITALIC));
      return menu;
   }  

   /**
      Creates a menu item to change the font face and set its action listener.
      @param name the name of the font face
      @return the menu item
   */
   public JMenuItem createFaceItem(final String name)
   {
      JMenuItem item = new JMenuItem(name);      
      class MenuItemListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            facename = name;
            setSampleFont();
         }
      }      
      ActionListener listener = new MenuItemListener();
      item.addActionListener(listener);
      return item;
   }

   /**
      Creates a menu item to change the font size
      and set its action listener.
      @param name the name of the menu item
      @param ds the amount by which to change the size
      @return the menu item
   */
   public JMenuItem createSizeItem(String name, final int ds)
   {
      JMenuItem item = new JMenuItem(name);      
      class MenuItemListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            fontsize = fontsize + ds;
            setSampleFont();
         }
      }      
      ActionListener listener = new MenuItemListener();
      item.addActionListener(listener);
      return item;
   }

   /**
      Creates a menu item to change the font style
      and set its action listener.
      @param name the name of the menu item
      @param style the new font style
      @return the menu item
   */
   public JMenuItem createStyleItem(String name, final int style)
   {
      JMenuItem item = new JMenuItem(name);      
      class MenuItemListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            fontstyle = style;
            setSampleFont();
         }
      }      
      ActionListener listener = new MenuItemListener();
      item.addActionListener(listener);
      return item;
   }

   /**
      Sets the font of the text sample.
   */
   public void setSampleFont()
   { 
      Font f = new Font(facename, fontstyle, fontsize);
      sampleField.setFont(f);
      sampleField.repaint();
   }
}


