/**
 * Class: Encoded
 * Purpose: Handles validation, character counting, and the cipher algorithm.
 */
public class Encoded {
    private int charCount;
    private String resultText;
    
    // Secret groupID must be hardcoded and not visible at runtime 
    private final String groupID = "G04/SE-G07"; 

    // Default Constructor 
    public Encoded() {
    }

    // Parameterized Constructor 
    public Encoded(String inputText) {
    }

    // Contributed by: Isabella Roselinni
    public boolean checkStringValidity(String input) {
        // Accepts only lowercase letters and spaces 
        return input != null && input.matches("^[a-z0-9\\s]*$");
    }

    // Contributed by: Isabella Roselinni
    public int countCharacters(String input) {
        // Counts non-space characters 
        if (input == null) return 0;
        this.charCount = input.replace(" ", "").length();
        return this.charCount;
    }

    // Contributed by: 
    public int generateshift() {
        // groupShift derived from hashCode between 1 and 10 
        int hash = Math.abs(groupID.hashCode());
        return (hash % 10) + 1; 
    }

    // Contributed by: 
    public String applyCipher(String input, int finalShift) {
        StringBuilder result = new StringBuilder();
        
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Formula: (c - 'a' + finalShift) % 26 + 'a' 
                result.append((char) ((c - 'a' + finalShift) % 26 + 'a'));
            } else if (Character.isDigit(c)) {
                // Formula: (c - '0' + finalShift) % 10 + '0' 
                result.append((char) ((c - '0' + finalShift) % 10 + '0'));
            } else {
                // Spaces remain unchanged 
                result.append(c);
            }
        }
        this.resultText = result.toString();
        return this.resultText;
    }
}
