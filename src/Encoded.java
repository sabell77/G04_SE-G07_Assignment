import java.util.Objects;

/**
 * Class: Encoded
 * Purpose: Handles the core encryption logic and input validation.
 */
public class Encoded {
    private String inputText;
    private int charCount;
    private String resultText;
    // Secret groupID hardcoded [cite: 19, 20, 42]
    private final String groupID = "G08/NC-G18"; 

    public Encoded() {
        this.inputText = "";
    }

    public Encoded(String inputText) {
        this.inputText = inputText;
    }

    // // Contributed by: [Member 1 Name]
    public boolean checkStringValidity(String inputText) {
        // Only alphanumeric (lowercase) and spaces [cite: 17, 23]
        return inputText.matches("^[a-z0-9\\s]*$");
    }

    // // Contributed by: [Member 1 Name]
    public int countCharacters(String inputText) {
        // Count non-space characters [cite: 26, 44]
        return inputText.replace(" ", "").length();
    }

    // // Contributed by: [Member 2 Name]
    public int generateshift() {
        // Must be between 1 and 10 based on groupID hashCode [cite: 27, 28]
        int hash = Math.abs(groupID.hashCode());
        return (hash % 10) + 1; 
    }

    // // Contributed by: [Member 2 Name]
    public String applyCipher(String inputText, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (char c : inputText.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Formula: (c - 'a' + finalShift) % 26 + 'a' [cite: 32, 35]
                result.append((char) ((c - 'a' + shift) % 26 + 'a'));
            } else if (Character.isDigit(c)) {
                // Formula: (c - '0' + finalShift) % 10 + '0' [cite: 34, 36]
                result.append((char) ((c - '0' + shift) % 10 + '0'));
            } else {
                // Spaces remain unchanged [cite: 37]
                result.append(c);
            }
        }
        return result.toString();
    }
}
