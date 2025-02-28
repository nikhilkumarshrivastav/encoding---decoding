import java.util.Scanner;

public class assignment2 {
    
    // Method to encode text using a shift cipher
    public static String encode(String text, int shift) {
        StringBuilder encoded = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) { // Check if character is a letter
                char base = Character.isUpperCase(c) ? 'A' : 'a'; // Determine base for upper/lower case
                encoded.append((char) ((c - base + shift) % 26 + base)); // Apply shift and wrap around
            } else {
                encoded.append(c); // Keep non-alphabetic characters unchanged
            }
        }
        
        return encoded.toString();
    }
    
    // Method to decode text by reversing the shift
    public static String decode(String text, int shift) {
        return encode(text, 26 - shift % 26); // Decoding is equivalent to encoding with (26 - shift)
    }
    
    // Method to display the user menu
    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Encode a message");
        System.out.println("2. Decode a message");
        System.out.println("3. Exit");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            displayMenu(); // Show menu options
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter text to encode: ");
                    String textToEncode = scanner.nextLine();
                    System.out.print("Enter shift value: ");
                    int shiftEncode = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Encoded: " + encode(textToEncode, shiftEncode));
                    break;
                case 2:
                    System.out.print("Enter text to decode: ");
                    String textToDecode = scanner.nextLine();
                    System.out.print("Enter shift value: ");
                    int shiftDecode = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Decoded: " + decode(textToDecode, shiftDecode));
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3); // Repeat until user chooses to exit
        
        scanner.close(); // Close scanner to prevent resource leak
    }
}
