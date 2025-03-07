package string_and_pattern_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem Statement
 * Finds the first character that does not repeat anywhere in the input string
 * If all characters are repeated, return 0
 * Given “apple”, the answer is “a”
 * Given “racecars”, the answer is “e"
 * Signature :
 * char findFirst(String input){}
 * Test Cases
 * Input: apple
 * Output: a
 * Input – xxyyzz
 * Output - 0
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "xxyyzz";
        System.out.println(findFirst(input));
    }

    private static char findFirst(String input) {
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '0';
    }

}
