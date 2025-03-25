package string_and_pattern_problems;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Statement
 * Given two words returns the shortest distance between their two midpoints in number of characters,
 * words can appear multiple times in any order and should be case-insensitive.
 * Signature :
 * public static double shortestDistance(String document, String word1, String word2) {}
 * Test Cases:
 * String Document – “In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements”.
 * shortestDistance( document, "is", "a" ) == 2.5
 */
public class DistanceBetweenStrings {

    public static void main(String[] args) {
        runTestCases();
    }

    private static double shortestDistance_optimized(String document, String word1, String word2) {
        if (document.isBlank() || word1.isBlank() || word2.isBlank()) {
            return -1;
        }

        int pos = 0;
        double m1 = -1;
        double m2 = -1;
        double minDist = Double.MAX_VALUE;
        String[] words = document.split("\\s+");
        for (String word : words) {
            String sanitizeWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if (sanitizeWord.equalsIgnoreCase(word1)) {
                m1 = pos + (word.length() / 2.0);
                if (m2 != -1) {
                    double delta = Math.abs(m2 - m1);
                    minDist = Math.min(minDist, delta);
                }
            } else if (sanitizeWord.equalsIgnoreCase(word2)) {
                m2 = pos + (word.length() / 2.0);
                if (m1 != -1) {
                    double delta = Math.abs(m2 - m1);
                    minDist = Math.min(minDist, delta);
                }
            }
            pos += word.length() + 1;
        }
        return minDist == Double.MAX_VALUE ? -1 : minDist;
    }

    private static double shortestDistance(String document, String word1, String word2) {
        if (document.isBlank() || word1.isBlank() || word2.isBlank()) {
            return -1;
        }

        String[] wordsArray = document.split("\\s+");
        List<Double> wordPos1 = new ArrayList<>();
        List<Double> wordPos2 = new ArrayList<>();
        int pos = 0;
        for (String word : wordsArray) {
            word = word.replaceAll("[^a-zA-Z0-9]", "");
            double midpoint = pos + (word.length() / 2.0);
            if (word1.equalsIgnoreCase(word)) {
                wordPos1.add(midpoint);
            }
            if (word2.equalsIgnoreCase(word)) {
                wordPos2.add(midpoint);
            }
            pos += word.length() + 1;
        }

        if (wordPos1.isEmpty() || wordPos2.isEmpty()) {
            return -1;
        }

        double shortestPos = Double.MAX_VALUE;
        for (double pos1 : wordPos1) {
            for (double pos2 : wordPos2) {
                double delta = Math.abs(pos1 - pos2);
                shortestPos = Math.min(delta, shortestPos);
            }
        }
        return shortestPos;
    }

    private static double shortestDistance_arya(String document, String word1, String word2) {
        // Input validation
        if (document == null || word1 == null || word2 == null ||
                document.isEmpty() || word1.isEmpty() || word2.isEmpty()) {
            throw new IllegalArgumentException("Document and search words cannot be null or empty");
        }

        // Convert to lowercase for case-insensitive matching
        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        // Lists to store midpoints of each word occurrence
        List<Double> word1Positions = new ArrayList<>();
        List<Double> word2Positions = new ArrayList<>();

        // Special case for same words (added)
        boolean sameWord = word1.equals(word2);


        // Split document into words
        String[] words = document.split("\\s+");

        // Track the current position in the document
        int position = 0;

        // Find all occurrences and calculate midpoints
        for (String word : words) {
            String cleanStr = word.replaceAll("[^a-zA-Z0-9]", "");
            // Calculate the midpoint of the current word
            double midpoint = position + (word.length() - 1) / 2.0;
            // Check if this word matches either of our target words
            if (cleanStr.equals(word1)) {
                word1Positions.add(midpoint);
                // If words are the same, also add to second list (added)
                if (sameWord) {
                    word2Positions.add(midpoint);
                }
            } else if (cleanStr.equals(word2)) {
                word2Positions.add(midpoint);
            }
            // Move position forward (word length + 1 for the space)
            position += word.length() + 1;
        }

        // If either word doesn't appear, return -1 or handle as needed
        if (word1Positions.isEmpty() || word2Positions.isEmpty()) {
            return -1;
        }

        // Find minimum distance between any pair of positions
        double minDistance = Double.MAX_VALUE;

        if (sameWord) {
            // For same words, find minimum distance between consecutive occurrences
            if (word1Positions.size() < 2) {
                return -1; // Need at least 2 occurrences to have a distance
            }

            Collections.sort(word1Positions);
            for (int i = 0; i < word1Positions.size() - 1; i++) {
                double distance = word1Positions.get(i + 1) - word1Positions.get(i);
                minDistance = Math.min(minDistance, distance);
            }
        } else {
            for (double pos1 : word1Positions) {
                for (double pos2 : word2Positions) {
                    double distance = Math.abs(pos1 - pos2);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }

        return minDistance;
    }

    private static double shortestDistance_ai(String document, String word1, String word2) {
        if (document == null || document.isBlank() || word1 == null || word1.isBlank() ||
                word2 == null || word2.isBlank()) {
            return -1;
        }

        // For same word search, we need to track all positions
        if (word1.equalsIgnoreCase(word2)) {
            return shortestDistanceSameWord(document, word1);
        }

        int pos = 0;
        List<Double> positions1 = new ArrayList<>();
        List<Double> positions2 = new ArrayList<>();

        String[] words = document.split("\\s+");
        for (String word : words) {
            String sanitizedWord = word.replaceAll("[^a-zA-Z0-9]", "");
            double midpoint = pos + (word.length() / 2.0);

            if (sanitizedWord.equalsIgnoreCase(word1)) {
                positions1.add(midpoint);
            }
            if (sanitizedWord.equalsIgnoreCase(word2)) {
                positions2.add(midpoint);
            }

            pos += word.length() + 1;
        }

        // If either word is not found
        if (positions1.isEmpty() || positions2.isEmpty()) {
            return -1;
        }

        // Find shortest distance
        double minDist = Double.MAX_VALUE;
        for (double p1 : positions1) {
            for (double p2 : positions2) {
                double delta = Math.abs(p1 - p2);
                minDist = Math.min(minDist, delta);
            }
        }

        return minDist;
    }

    private static double shortestDistanceSameWord(String document, String word) {
        int pos = 0;
        List<Double> positions = new ArrayList<>();

        String[] words = document.split("\\s+");
        for (String w : words) {
            String sanitizedWord = w.replaceAll("[^a-zA-Z0-9]", "");
            if (sanitizedWord.equalsIgnoreCase(word)) {
                positions.add(pos + (w.length() / 2.0));
            }
            pos += w.length() + 1;
        }

        if (positions.size() < 2) {
            return -1; // Need at least 2 occurrences for same word search
        }

        // Find minimum distance between consecutive positions
        double minDist = Double.MAX_VALUE;
        Collections.sort(positions);
        for (int i = 0; i < positions.size() - 1; i++) {
            double delta = positions.get(i + 1) - positions.get(i);
            minDist = Math.min(minDist, delta);
        }

        return minDist;
    }

    private static void runTestCases() {
        // Test Case 1: Original example from problem statement
        String document1 = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        testAndPrint(document1, "is", "a", 2.5);

        // Test Case 2: Multiple occurrences of words
        String document2 = "word1 other word2 another word1 more word2";
        testAndPrint(document2, "word1", "word2", 6.0);

        // Test Case 3: Case insensitivity
        String document3 = "Word1 other WORD2";
        testAndPrint(document3, "word1", "word2", 6.0);

        // Test Case 4: Words with punctuation
        String document4 = "word1, other. word2!";
        testAndPrint(document4, "word1", "word2", 7.5);

        // Test Case 5: Same word search
        String document5 = "word1 other word1";
        testAndPrint(document5, "word1", "word1", 6.0);

        // Test Case 6: Words not in document
        String document6 = "word1 other word2";
        testAndPrint(document6, "word3", "word4", -1.0);

        // Test Case 7: Empty document
        String document7 = "";
        testAndPrint(document7, "word1", "word2", -1.0);

        // Test Case 8: Empty search words
        String document8 = "word1 other word2";
        testAndPrint(document8, "", "word2", -1.0);

        // Test Case 9: Words close together
        String document9 = "This is a test";
        testAndPrint(document9, "is", "a", 2.0);

        // Test Case 10: Words far apart
        String document10 = "First word is here and the last word is there";
        testAndPrint(document10, "First", "there", 35.5);
    }

    private static void testAndPrint(String document, String word1, String word2, double expected) {
        double result = shortestDistance_optimized(document, word1, word2);
        boolean passed = Math.abs(result - expected) < 0.001; // Allow small floating-point differences

        PrintStream printStream = passed ? System.out : System.err;
        printStream.println("Test Case: \"" + document + "\"");
        printStream.println("Words: \"" + word1 + "\", \"" + word2 + "\"");
        printStream.println("Expected: " + expected);
        printStream.println("Result: " + result);
        printStream.println("Status: " + (passed ? "PASSED" : "FAILED"));
        printStream.println();
    }

}
