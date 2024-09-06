import java.util.Scanner;
public class decryption {
    public static void main(String[] args) {
        char[][] square = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'},
        };
        char[] alphabet = {
            'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'K',
            'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z',
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        String word = input.next();
        char[] letters = word.toUpperCase().toCharArray();
        for (int firstLoop = 0; firstLoop < letters.length; ++firstLoop) {
            for (int secondLoop = 0; secondLoop < alphabet.length; ++secondLoop) {
                if (letters[firstLoop] == alphabet[0]) {
                    letters[firstLoop] = alphabet[alphabet.length - 2];
                    break;
                }
                else if (letters[firstLoop] == alphabet[1]) {
                    letters[firstLoop] = alphabet[alphabet.length - 1];
                    break;
                }
                else if (letters[firstLoop] == alphabet[secondLoop]) {
                    letters[firstLoop] = alphabet[secondLoop - 2];
                    break;
                }
            }
        }
//        test 1
//        for (char letter : letters) {
//            System.out.println(letter);
//        }
        String encryptedText = "";
        boolean done;
        for (int firstLoop = 0; firstLoop < letters.length; firstLoop++) {
            done = false;
            for (int secondLoop = 0; secondLoop < square.length; secondLoop++) {
                if (done) {
                    break;
                }
                for (int thirdLoop = 0; thirdLoop < square[secondLoop].length; thirdLoop++) {
                    if (letters[firstLoop] == square[secondLoop][thirdLoop]) {
                        encryptedText += String.format((secondLoop + 1) + "" + (thirdLoop + 1));
                        done = true;
                        if (firstLoop != letters.length)
                            encryptedText += " ";
                        break;
                    }
                }
            }
        }
        System.out.println("Encrypted text: " + encryptedText);
    }
}