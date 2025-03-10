package string_and_pattern_problems;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Problem Statement
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * write a function findMissingLetters, which takes a String "sentence",
 * and returns all the letters it is missing (which prevent it from
 * being a pangram). You should ignore the case of the letters in sentence,
 * and your return should be all lower case letters, in alphabetical order.
 * you should also ignore all non US-ASCII characters.
 * Signature:
 * String findMissingLetters(String sentence) {}
 * Test Cases:
 * Input: The slow purple oryx meanders past the quiescent canine
 * Output: bfgjkvz
 */
public class Pangram {

    public static void main(String[] args) {
        String sentence = "The slow purple oryx meanders past the quiescent canine";
        System.out.println(findMissingLetters(sentence));  // Expected: bfgjkvz
    }

    private static String findMissingLetters(String sentence) {
        Set<Character> alphaSet = getAlphabetsSet();
        for (char ch : sentence.toCharArray()) {
            char lowerChar = Character.toLowerCase(ch);
            if (lowerChar >= 'a' && lowerChar <= 'z') {
                alphaSet.remove(lowerChar);
            }
        }
        StringBuilder missingLetters = new StringBuilder();
        alphaSet.forEach(missingLetters::append);
        return missingLetters.toString();
    }

    private static Set<Character> getAlphabetsSet() {
        Set<Character> alphaSet = new LinkedHashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphaSet.add(ch);
        }
        return alphaSet;
    }

}
