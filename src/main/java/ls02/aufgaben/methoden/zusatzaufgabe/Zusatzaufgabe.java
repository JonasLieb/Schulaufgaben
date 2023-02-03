package ls02.aufgaben.methoden.zusatzaufgabe;

/**
 * Diese Zusatzaufgabe stammt aus der PowerPoint-Präsentation.
 *
 * @author Jonas Lieben
 */
public class Zusatzaufgabe {

    public static void main(String[] args) {
        int key = 5;
        String t = "Ich bin ein Text";
        String encoded = encodeCaesar(t, key);
        String decoded = decodeCaesar(encoded, key);
        System.out.println("Text: " + t + "\nEncoded: " + encoded + "\nDecoded: " + decoded);
    }

    public static String encodeCaesar(String textToEncode, int offset) {
        char[] input = textToEncode.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : input) {
            output.append(getEncodedCaesarChar(c, offset));
        }
        return output.toString();
    }

    public static String decodeCaesar(String textToDecode, int offset) {
        char[] input = textToDecode.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : input) {
            output.append(getDecodedCaesarChar(c, offset));
        }
        return output.toString();
    }

    private static char getEncodedCaesarChar(char c, int num) {
        return (char) (c + num);
    }

    private static char getDecodedCaesarChar(char c, int num) {
        return (char) (c - num);
    }
}
