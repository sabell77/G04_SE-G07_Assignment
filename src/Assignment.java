import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assignment {
    public static void main(String[] args) {
        JFrame frame = new JFrame("String Encoder");
        frame.setSize(500, 600); // Height increased for vertical stack
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Using a vertical BoxLayout to stack items top-to-bottom
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250));

        //Logo (Top)
        LogoPanel customLogo = new LogoPanel();
        customLogo.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Input Section Panel (Horizontal)
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBackground(new Color(230, 230, 250));
    
        JLabel label = new JLabel("Enter string:");
        label.setForeground(new Color(75, 0, 130)); // Darker purple text for contrast
        label.setFont(new Font("Arial", Font.BOLD, 12));

        RoundField inputField = new RoundField(20, 20); // 20 columns, 20px corner radius
        inputField.setBackground(Color.WHITE);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        inputPanel.add(label);
        inputPanel.add(inputField);
        
        RoundButton encodeButton = new RoundButton("Encode");
        encodeButton.setBackground(new Color(106, 13, 173)); 
        encodeButton.setForeground(Color.WHITE);
        encodeButton.setPreferredSize(new Dimension(100, 30)); // Makes it a nice pill shape
        encodeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inputPanel.add(encodeButton);

        //Result Section (Bottom)
        JTextArea displayArea = new JTextArea();
        displayArea.setBackground(new Color(250, 250, 255)); // Matching "Cute" background
        displayArea.setOpaque(false); // Crucial for showing the rounded background
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        //Wrap it in the RoundScrollPane
        // (radius: 30 for smooth corners)
        RoundScrollPane scrollPane = new RoundScrollPane(displayArea, 30);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        // Add to your panel
        mainPanel.add(scrollPane);
    
        // --- Shared Logic ---
            ActionListener encoderTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputField.getText();
                Encoded encoder = new Encoded(text);

                //Contributed by [Member Name]
                displayArea.setBackground(new Color(245, 245, 250)); // Very light grey/blue tint
                displayArea.setForeground(new Color(106, 13, 173));  // Bold Purple text
                displayArea.setFont(new Font("Monospaced", Font.BOLD, 14)); // Monospaced keeps characters aligned
                displayArea.setMargin(new Insets(15, 15, 15, 15));   // Adds "breathable" space inside the box

                if (encoder.checkStringValidity(text)) {
                    int nonSpaceCount = encoder.countCharacters(text);
                    int gShift = encoder.generateshift();
                    int finalShift = gShift + nonSpaceCount;
                    String result = encoder.applyCipher(text, finalShift);

                    String output = String.format("%-20s: %d\n" +
                                                  "%-20s: %d\n" +
                                                  "%-20s: %s",
                                         "Non-space characters", nonSpaceCount,
                                                  "Final Shift         ", finalShift,
                                                  "Encoded Result      ", result
                                                );

                    displayArea.setText(output);

                    // --- SUCCESS DIALOG CODE STARTS HERE ---
                    JDialog successDialog = new JDialog(frame, "Success", true);
                    successDialog.getContentPane().setBackground(Color.WHITE);

                    JPanel successPanel = new JPanel();
                    successPanel.setLayout(new BoxLayout(successPanel, BoxLayout.Y_AXIS));
                    successPanel.setBackground(Color.WHITE);
                    successPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                    // Success Message
                    JLabel successMsg = new JLabel("Encoding completed successfully!");
                    successMsg.setForeground(new Color(106, 13, 173)); // Bold Purple
                    successMsg.setFont(new Font("Arial", Font.BOLD, 14));
                    successMsg.setAlignmentX(Component.CENTER_ALIGNMENT);

                    // Spacer
                    successPanel.add(successMsg);
                    successPanel.add(Box.createRigidArea(new Dimension(0, 15)));

                    // Reuse your RoundButton for the "Great!" or "OK" button
                    RoundButton okBtn = new RoundButton("Great!");
                    okBtn.setBackground(new Color(106, 13, 173));
                    okBtn.setForeground(Color.WHITE);
                    okBtn.setPreferredSize(new Dimension(100, 35));
                    okBtn.setMaximumSize(new Dimension(100, 35));
                    okBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                    okBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    
                    okBtn.addActionListener(ae -> successDialog.dispose());

                    successPanel.add(okBtn);
                    successDialog.add(successPanel);
                    successDialog.pack();
                    successDialog.setLocationRelativeTo(frame);
                    successDialog.setVisible(true);
                    // --- SUCCESS DIALOG CODE ENDS HERE ---                          

                } else {
                        //Create the dialog
                        JDialog errorDialog = new JDialog(frame, "Error", true);
                        errorDialog.getContentPane().setBackground(Color.WHITE);

                        //Create a panel to hold everything vertically
                        JPanel contentPanel = new JPanel();
                        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
                        contentPanel.setBackground(new Color(230, 230, 250));
                        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

                        //The Message Label
                        JLabel msg = new JLabel("Invalid Input! Use lowercase & spaces.");
                        msg.setForeground(new Color(106, 13, 173));
                        msg.setFont(new Font("Arial", Font.BOLD, 14));
                        msg.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment for BoxLayout

                        //A little spacer between text and button
                        contentPanel.add(msg);
                        contentPanel.add(Box.createRigidArea(new Dimension(0, 15)));

                        //The Round OK Button
                        RoundButton okButton = new RoundButton("OK");
                        okButton.setBackground(new Color(106, 13, 173));
                        okButton.setForeground(Color.WHITE);
                        okButton.setPreferredSize(new Dimension(80, 30));
                        okButton.setMaximumSize(new Dimension(80, 30)); // Keeps the button from stretching
                        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));      
                        
                        //Close logic
                        okButton.addActionListener(ae -> errorDialog.dispose());

                        //Final Assembly
                        contentPanel.add(okButton);
                        errorDialog.add(contentPanel);
                                
                        errorDialog.pack();
                        errorDialog.setLocationRelativeTo(frame);
                        errorDialog.setVisible(true);
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
