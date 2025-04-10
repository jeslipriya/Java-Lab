import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficLightDemo extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JButton aiModeButton;
    private LightPanel lightPanel;
    private Timer aiTimer;
    private boolean aiMode = false;

    public TrafficLightDemo() {
        setTitle("🚦 Traffic Light Simulator v2.0");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lightPanel = new LightPanel();
        add(lightPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        aiModeButton = new JButton("🤖 Toggle AI Mode");
        aiModeButton.addActionListener(e -> toggleAIMode());

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(aiModeButton);

        add(buttonPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            lightPanel.setLightColor("RED");
        } else if (e.getSource() == yellowButton) {
            lightPanel.setLightColor("YELLOW");
        } else if (e.getSource() == greenButton) {
            lightPanel.setLightColor("GREEN");
        }
    }

    private void toggleAIMode() {
        aiMode = !aiMode;
        if (aiMode) {
            aiModeButton.setText("🛑 Stop AI Mode");
            aiTimer = new Timer();
            aiTimer.scheduleAtFixedRate(new TimerTask() {
                String[] states = {"RED", "YELLOW", "GREEN"};
                int index = 0;
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        lightPanel.setLightColor(states[index]);
                        index = (index + 1) % states.length;
                    });
                }
            }, 0, 2000); // every 2 seconds
        } else {
            aiTimer.cancel();
            aiModeButton.setText("🤖 Toggle AI Mode");
        }
    }

    class LightPanel extends JPanel {
        private String currentColor = "";

        public void setLightColor(String color) {
            currentColor = color;
            repaint();
            playSound(color);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Background
            g.drawImage(new ImageIcon("assets/background.jpg").getImage(), 0, 0, getWidth(), getHeight(), this);

            g.setColor(Color.BLACK);
            g.fillRect(140, 100, 120, 360);

            drawCircle(g, 160, 120, Color.RED, "RED".equals(currentColor));
            drawCircle(g, 160, 220, Color.YELLOW, "YELLOW".equals(currentColor));
            drawCircle(g, 160, 320, Color.GREEN, "GREEN".equals(currentColor));
        }

        private void drawCircle(Graphics g, int x, int y, Color color, boolean isOn) {
            g.setColor(isOn ? color : color.darker().darker());
            g.fillOval(x, y, 80, 80);
        }

        private void playSound(String color) {
            String file = switch (color) {
                case "RED" -> "assets/siren.wav"; // Be dramatic 😎
                case "YELLOW", "GREEN" -> "assets/beep.wav";
                default -> null;
            };

            if (file != null) {
                try {
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(file));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (Exception ex) {
                    System.out.println("Sound error: " + ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        new TrafficLightDemo();
    }
}
