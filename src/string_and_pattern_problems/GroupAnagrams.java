package string_and_pattern_problems;

import java.util.*;

/**
 * Problem Statement:
 * Given a list of words, group them by anagrams
 * Input: List of "cat", "dog", "god"
 * Output: A Set of Sets of anagrams: {{‘cat'}, {‘dog', ‘god'}}
 * Signature : Set<Set<String>> group(List<String> words){}
 * Test Cases –
 * Input : ["cat", "dog", "god"]
 * Output: [["cat"],["dog", "god"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("cat", "dog", "god", "act", "books", "skoob", "hell", "well"));
        System.out.println(groupAnagrams(words));
    }

    private static Set<Set<String>> groupAnagrams(List<String> words) {
        Set<Set<String>> groupedAnagrams = new LinkedHashSet<>();
        for (int i = 0; i < words.size(); i++) {
            String iStr = words.get(i);
            Set<String> anagrams = new LinkedHashSet<>();
            anagrams.add(iStr);

            for (int j = i + 1; j < words.size(); j++) {
                String jStr = words.get(j);
                if (isAnagram(iStr, jStr)) {
                    anagrams.add(jStr);
                    words.remove(jStr);
                }
            }
            groupedAnagrams.add(anagrams);
        }
        return groupedAnagrams;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s2.toCharArray()) {
            if (hm.get(ch) == null) {
                return false;
            }

            hm.computeIfPresent(ch, (k, v) -> v - 1);
            if (hm.get(ch) == 0) {
                hm.remove(ch);
            }
        }
        return hm.isEmpty();
    }

}
