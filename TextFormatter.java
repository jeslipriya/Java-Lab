import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFormatter extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    public TextFormatter(){
        setTitle("Simple Text Formatter");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        textField = new JTextField(15);
        textField.setBounds(50, 30, 300, 30);
        add(textField);

        JButton b = new JButton("Format Button");
        b.setBounds(130, 80, 130, 30);
        add(b);
        textArea = new JTextArea(5,20);
        textArea.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(50, 130, 300, 200);
        add(scroll);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                formatText();
            }
        });

        setVisible(true);
    }

    public void formatText(){
        String text = textField.getText();
        textArea.setText(text);
        textArea.setFont(new Font("Arial",Font.PLAIN,16));
    }
    public static void main(String[] args) {
        new TextFormatter();       
    }
}
