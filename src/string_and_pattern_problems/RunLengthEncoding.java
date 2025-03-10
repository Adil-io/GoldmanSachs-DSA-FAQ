package string_and_pattern_problems;

/**
 * Problem Statement
 * For a string input the function returns output encoded as follows:
 * "a" -> "a1"
 * "aa" -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * Signature :
 * String rle(String input) {}
 * Test Case:
 * Input : aaabbbaad
 * Output: a3b3a2d1
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        String input = "aaabbbaad";
        System.out.println(rle(input));
    }

    private static String rle(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;
        for (int r = 1; r <= input.length(); r++) {
            if (r == input.length() || input.charAt(r) != input.charAt(r - 1)) {
                encoded.append(input.charAt(r - 1)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return encoded.toString();
    }

}
