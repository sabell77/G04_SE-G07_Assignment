import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class: Assignment
 * Purpose: Entry point of the program; handles the GUI.
 */
public class Assignment {
    public static void main(String[] args) {
        // // Contributed by: [Member 3 Name]
        JFrame frame = new JFrame("String Encoder");
        frame.setDefaultCloseOperation(JFrame.EXIT_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // UI Components [cite: 50, 51, 52]
        JTextField inputField = new JTextField(20);
        JButton encodeButton = new JButton("Encode");
        JTextArea displayArea = new JTextArea(8, 30);
        displayArea.setEditable(false);

        frame.add(new JLabel("Enter string to encode:"));
        frame.add(inputField);
        frame.add(encodeButton);
        frame.add(new JScrollPane(displayArea));

        // // Contributed by: [Member 4 Name]
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                Encoded encoder = new Encoded();

                if (encoder.checkStringValidity(input)) {
                    int charCount = encoder.countCharacters(input);
                    int groupShift = encoder.generateshift();
                    int finalShift = groupShift + charCount; // [cite: 30, 46]
                    
                    String result = encoder.applyCipher(input, finalShift);

                    displayArea.setText("Non-space characters: " + charCount + "\n" +
                                      "Final Shift: " + finalShift + "\n" +
                                      "Result: " + result + "\n\n" +
                                      "Encoding completed successfully."); // [cite: 52, 53]
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Input! Use lowercase and spaces only.", "Error", JOptionPane.ERROR_MESSAGE); // [cite: 18]
                }
            }
        });

        frame.setVisible(true);
    }
}
