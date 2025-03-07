package string_and_pattern_problems;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem Statement
 * Given a string of letters and a dictionary, the function longestWord should
 * find the longest word or words in the dictionary that can be made from the letters
 * Input: letters = "oet", dictionary = {"to","toe","toes"}
 * Output: {"toe"}
 * Only lowercase letters will occur in the dictionary and the letters
 * The length of letters will be between 1 and 10 characters
 * The solution should work well for a dictionary of over 100,000 words
 * Signature- Set<String> longestWord(String letters, Dictionary dictionary) {}
 * Test Cases
 * Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});
 * Input: toe
 * Output: toe
 * Input – oetdg
 * Output- "doe", "toe", "dog", "god"
 */
public class LongestWord {

    public record Dictionary(String[] words) {
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new String[]{"to", "toe", "toes", "ot", "doe", "dog", "god", "dogs", "book", "banana"});
        String letters = "oetdg";
        System.out.println(longestWord(letters, dictionary));
    }

    private static Set<String> longestWord(String letters, Dictionary dictionary) {
        int maxLength = 0;
        Set<String> longestWords = new LinkedHashSet<>();
        for (String str : dictionary.words) {
            if (canForm(letters, str)) {
                int length = str.length();
                if (length > maxLength) {
                    maxLength = length;
                    longestWords.clear();
                    longestWords.add(str);
                } else if (length == maxLength) {
                    longestWords.add(str);
                }
            }
        }
        return longestWords;
    }

    private static boolean canForm(String letters, String word) {
        List<Character> wordCharList = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            wordCharList.add(ch);
        }

        for (char ch : letters.toCharArray()) {
            int i = wordCharList.indexOf(ch);
            if (i >= 0) {
                wordCharList.remove(i);
            }
        }

        return wordCharList.isEmpty();
    }

}
