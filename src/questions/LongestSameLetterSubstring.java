package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */
public class LongestSameLetterSubstring {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(longestLength(s, k));
    }

    public static int longestLength(String str, int k) {
        if (str.isBlank()) {
            return -1;
        }

        int maxCount = 0, maxLength = 0;
        int left = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            hm.put(rightChar, hm.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, hm.get(rightChar));

            int windowSize = right - left + 1;
            if (windowSize - maxCount > k) {
                char leftChar = str.charAt(left);
                hm.put(leftChar, hm.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
}
