package string_and_pattern_problems;

import java.util.Arrays;

/**
 * Problem Statement
 * This method should return an integer array with two elements that correctly identifies the location of the longest
 * uniform substring within the input string. The first element of the array should be the starting index of the longest
 * substring and the second element should be the length.
 * input: “abbbccda" the longest uniform substring is “bbb” (which starts at index 1 and is 3 characters long.
 * Signature :
 * int[] longestUniformSubstring(String input) {}
 * Test Cases –
 * Input : aabbbbbCdAA
 * Output – [2,5]
 */
public class LongestUniformSubstring {

    public static void main(String[] args) {
        String input = "aabbbbbCdAA";
        System.out.println(Arrays.toString(longestUniformSubstring(input)));
        System.out.println(getLongestUniformSubstring(input));
    }

    private static int[] longestUniformSubstring(String input) {
        int[] result = new int[2];
        int l = 0, maxLength = 0;
        for (int r = 1; r <= input.length(); r++) {
            if (r == input.length() || input.charAt(r) != input.charAt(r - 1)) {
                int length = r - l;
                if (length > maxLength) {
                    maxLength = length;
                    result[0] = l;
                    result[1] = maxLength;
                }
                l = r;
            }
        }
        return result;
    }

    private static String getLongestUniformSubstring(String input) {
        int[] indexes = new int[2];
        int l = 0, maxLength = 0;
        for (int r = 1; r <= input.length(); r++) {
            if (r == input.length() || input.charAt(r) != input.charAt(r - 1)) {
                int length = r - l;
                if (length > maxLength) {
                    maxLength = length;
                    indexes[0] = l;
                    indexes[1] = l + maxLength;
                }
                l = r;
            }
        }
        return input.substring(indexes[0], indexes[1]);
    }

}
