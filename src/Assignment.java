import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: Assignment
 * Purpose: Main entry point and GUI implementation using Java Swing. [cite: 49, 62]
 */
public class Assignment {
    public static void main(String[] args) {
        // // Contributed by: [Member 3 Name]
        JFrame frame = new JFrame("String Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Standard close operation [cite: 18]
        frame.setSize(450, 500);
        frame.setLayout(new FlowLayout());

        // --- Add the Custom Logo Panel ---
        LogoPanel customLogo = new LogoPanel();
        frame.add(customLogo); // This will appear at the top
        // ---------------------------------

        // UI Components [cite: 50, 51, 52]
        JTextField inputField = new JTextField(25);
        JButton encodeButton = new JButton("Encode");
        JTextArea displayArea = new JTextArea(10, 35);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEtchedBorder());

        frame.add(new JLabel("Enter string (lowercase & numbers):"));
        frame.add(inputField);
        frame.add(encodeButton);
        frame.add(new JScrollPane(displayArea));

        // // Contributed by: [Member 4 Name]
        // Shared ActionListener to handle both button clicks and Enter key presses
        ActionListener encoderTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                Encoded encoder = new Encoded(text);

                // 1. Validate input using Encoded class 
                if (encoder.checkStringValidity(text)) {
                    // 2. Process encoding steps [cite: 26, 27, 29, 30]
                    int nonSpaceCount = encoder.countCharacters(text);
                    int gShift = encoder.generateshift();
                    int finalShift = gShift + nonSpaceCount;
                    String result = encoder.applyCipher(text, finalShift);

                    // 3. Display results (Hidden groupID and groupShift) [cite: 52, 53]
                    displayArea.setText("Non-space characters: " + nonSpaceCount + "\n" +
                                      "Final Shift: " + finalShift + "\n" +
                                      "Encoded Result: " + result + "\n\n" +
                                      "Encoding completed successfully.");
                } else {
                    // 4. Error handling for invalid characters [cite: 18]
                    JOptionPane.showMessageDialog(frame, 
                        "Invalid Input! Please use only lowercase letters (a-z), digits (0-9), and spaces.", 
                        "Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        // Attach the logic to the button
        encodeButton.addActionListener(encoderTask);
        
        // Attach the logic to the text field (Triggers on 'Enter')
        inputField.addActionListener(encoderTask);

        frame.setVisible(true);
    }
}