import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("String Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600); // Height increased for vertical stack
        
        // Using a vertical BoxLayout to stack items top-to-bottom
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250));

        // 1. Logo (Top)
        LogoPanel customLogo = new LogoPanel();
        customLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //2. Input Section Panel (Horizontal)
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // MATCH INPUT PANEL COLOR
        inputPanel.setBackground(new Color(245, 245, 255));
    
    
        JLabel label = new JLabel("Enter string:");
        label.setForeground(new Color(75, 0, 130)); // Darker purple text for contrast
        label.setFont(new Font("Arial", Font.BOLD, 12));

        RoundField inputField = new RoundField(20, 20); // 20 columns, 20px corner radius
        inputField.setBackground(Color.WHITE);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        inputPanel.add(label);
        inputPanel.add(inputField);
        

        RoundButton encodeButton = new RoundButton("Encode");
        encodeButton.setBackground(new Color(106, 13, 173)); // Cute Sky Blue
        encodeButton.setForeground(Color.WHITE);
        encodeButton.setPreferredSize(new Dimension(100, 30)); // Makes it a nice pill shape
        inputPanel.add(encodeButton);

        // 3. Result Section (Bottom)
        JTextArea displayArea = new JTextArea(10, 35);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createTitledBorder("Encoder Output"));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // --- Shared Logic ---
        ActionListener encoderTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                Encoded encoder = new Encoded(text);
                if (encoder.checkStringValidity(text)) {
                    int nonSpaceCount = encoder.countCharacters(text);
                    int gShift = encoder.generateshift();
                    int finalShift = gShift + nonSpaceCount;
                    String result = encoder.applyCipher(text, finalShift);

                    displayArea.setText("Non-space characters: " + nonSpaceCount + "\n" +
                                      "Final Shift: " + finalShift + "\n" +
                                      "Encoded Result: " + result);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Input! Use lowercase & spaces.");
                }
            }
        };

        encodeButton.addActionListener(encoderTask);
        inputField.addActionListener(encoderTask);

        // Add everything to the main vertical panel
        mainPanel.add(customLogo);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space
        mainPanel.add(scrollPane);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}