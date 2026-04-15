/**
 * Class: Encoded
 * Purpose: Handles validation, character counting, and the cipher algorithm.
 */
public class Encoded {
    private int charCount;
    private String resultText;
    
    // Secret groupID must be hardcoded and not visible at runtime [cite: 19, 20, 42]
    private final String groupID = "G08/NC-G18"; 

    // Default Constructor 
    public Encoded() {
    }

    // Parameterized Constructor 
    public Encoded(String inputText) {
    }

    // Contributed by: [Member 1 Name] [cite: 59]
    public boolean checkStringValidity(String input) {
        // Accepts only lowercase letters and spaces [cite: 17, 23]
        return input != null && input.matches("^[a-z0-9\\s]*$");
    }

    // Contributed by: [Member 1 Name] [cite: 59]
    public int countCharacters(String input) {
        // Counts non-space characters [cite: 26]
        if (input == null) return 0;
        this.charCount = input.replace(" ", "").length();
        return this.charCount;
    }

    // Contributed by: [Member 2 Name] [cite: 59]
    public int generateshift() {
        // groupShift derived from hashCode between 1 and 10 [cite: 27, 28]
        int hash = Math.abs(groupID.hashCode());
        return (hash % 10) + 1; 
    }

    // Contributed by: [Member 2 Name] [cite: 59]
    public String applyCipher(String input, int finalShift) {
        StringBuilder result = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Formula: (c - 'a' + finalShift) % 26 + 'a' [cite: 31, 35]
                result.append((char) ((c - 'a' + finalShift) % 26 + 'a'));
            } else if (Character.isDigit(c)) {
                // Formula: (c - '0' + finalShift) % 10 + '0' [cite: 33, 36]
                result.append((char) ((c - '0' + finalShift) % 10 + '0'));
            } else {
                // Spaces remain unchanged [cite: 37]
                result.append(c);
            }
        }
        this.resultText = result.toString();
        return this.resultText;
    }
}