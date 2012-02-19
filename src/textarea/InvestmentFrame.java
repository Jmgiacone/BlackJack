package textarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
   A frame that shows the growth of an investment with variable interest.
*/
public class InvestmentFrame extends JFrame
{
   private static final int FRAME_WIDTH = 400;
   private static final int FRAME_HEIGHT = 250;
   
   private static final int AREA_ROWS = 10;
   private static final int AREA_COLUMNS = 30;
   private static final double DEFAULT_RATE = 5;
   private static final double INITIAL_BALANCE = 1000;   
     
   private JLabel rateLabel;
   private JTextField rateField;
   private JButton button;
   private JTextArea resultArea;
   private JPanel panel;
   private BankAccount account;
 
   public InvestmentFrame()
   {  
      account = new BankAccount(INITIAL_BALANCE);
      resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
      resultArea.setEditable(false);
            
      // Use helper methods 
      createTextField();
      createButton();
      createPanel();

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

   private void createTextField()
   {
      rateLabel = new JLabel("Interest Rate: ");

      final int FIELD_WIDTH = 10;
      rateField = new JTextField(FIELD_WIDTH);
      rateField.setText("" + DEFAULT_RATE);
   }
   
   private void createButton()
   {
      button = new JButton("Add Interest");
      
      class AddInterestListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            double rate = Double.parseDouble(rateField.getText());
            double interest = account.getBalance() * rate / 100;
            account.deposit(interest);
            resultArea.append(account.getBalance() + "\n");
         }            
      }
      
      ActionListener listener = new AddInterestListener();
      button.addActionListener(listener);
   }

   private void createPanel()
   {
      panel = new JPanel();
      panel.add(rateLabel);
      panel.add(rateField);
      panel.add(button);
      JScrollPane scrollPane = new JScrollPane(resultArea);
      panel.add(scrollPane);      
      add(panel);
   }
 }
