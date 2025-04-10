import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {
    private JLabel messageLabel;

    public TrafficLight(){
        setTitle("Traffic Light Stimulator");
        setSize(400,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(messageLabel);

        JRadioButton redButton = new JRadioButton("Red");
        JRadioButton yellowButton = new JRadioButton("Yellow");
        JRadioButton greenButton = new JRadioButton("Green");
        
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        add(redButton);
        add(yellowButton);
        add(greenButton);

        redButton.addActionListener(e -> updateMessage("Stop", Color.RED));
        yellowButton.addActionListener(e -> updateMessage("Ready", Color.YELLOW));
        greenButton.addActionListener(e -> updateMessage("Go", Color.GREEN));

        setVisible(true);
    }

    public void updateMessage(String message, Color color){
        messageLabel.setText(message);
        messageLabel.setForeground(color);
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}
