package questions;

/**
 * Problem Statement
 * For a string input the function returns output encoded as follows:
 * "a1" -> "a"
 * "a2" -> "aa"
 * "a2b3" -> "aabbb"
 * "a2b3a2" -> "aabbbaa"
 * Signature :
 * String runLengthDecoding(String input) {}
 * Test Case:
 * Input : a3b3a2d1
 * Output: aaabbbaad
 */
public class RunLengthDecoding {

    public static void main(String[] args) {
        String input = "a3b3a2d1";
        System.out.println(runLengthDecoding(input));
    }

    public static String runLengthDecoding(String str) {
        StringBuilder decodedString = new StringBuilder();
        int left = 0;
        int right = 1;
        while (right < str.length()) {
            StringBuilder sb = new StringBuilder();
            while (right < str.length() && Character.isDigit(str.charAt(right))) {
                sb.append(str.charAt(right));
                right++;
            }
            int digit = Integer.parseInt(sb.toString());
            while (digit-- > 0) {
                decodedString.append(str.charAt(left));
            }
            left = right;
            right++;
        }
        return decodedString.toString();
    }

}
