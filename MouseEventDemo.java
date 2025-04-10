import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends JFrame{
    private  JLabel label;

    public MouseEventDemo(){
        setTitle("Mouse Event Demo");
        setSize(400,400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                label.setText("Mouse Clicked");
            }

            public void mouseEntered(MouseEvent e){
                label.setText("Mouse Entered");
            }
            public void mouseExited(MouseEvent e){
                label.setText("Mouse Exited");
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}
