import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
   JTextField display;
   double num1 = 0.0;
   double num2 = 0.0;
   double result = 0.0;
   char operator;

   public Calculator() {
      this.setTitle("Calculator");
      this.setSize(400, 400);
      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(3);
      this.display = new JTextField();
      this.display.setEditable(false);
      this.add(this.display, "North");
      JPanel var1 = new JPanel();
      var1.setLayout(new GridLayout(4, 4));
      String[] var2 = new String[]{"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};
      String[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         JButton var7 = new JButton(var6);
         var7.addActionListener(this);
         var1.add(var7);
      }

      this.add(var1);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = var1.getActionCommand();
      if (var2.charAt(0) >= '0' && var2.charAt(0) <= '9') {
         JTextField var10000 = this.display;
         String var10001 = this.display.getText();
         var10000.setText(var10001 + var2);
      } else if (var2.equals("C")) {
         this.display.setText("");
         this.num1 = this.num2 = this.result = 0.0;
      } else if (var2.equals("=")) {
         this.num2 = Double.parseDouble(this.display.getText());
         switch (this.operator) {
            case '*':
               this.result = this.num1 * this.num2;
               break;
            case '+':
               this.result = this.num1 + this.num2;
            case ',':
            case '.':
            default:
               break;
            case '-':
               this.result = this.num1 - this.num2;
               break;
            case '/':
               if (this.num2 == 0.0) {
                  this.display.setText("Error");
                  return;
               }

               this.result = this.num1 / this.num2;
         }

         this.display.setText(String.valueOf(this.result));
      } else {
         this.num1 = Double.parseDouble(this.display.getText());
         this.operator = var2.charAt(0);
         this.display.setText("");
      }

   }

   public static void main(String[] var0) {
      new Calculator();
   }
}
