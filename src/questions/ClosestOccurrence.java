package questions;

/**
 * Given a string s and two words w1 and w2 that are present in S. The task is to find the minimum distance between w1 and w2.
 * Here, distance is the number of steps or words between the first and the second word.
 * Input : s = “geeks for geeks contribute practice”, w1 = “geeks”, w2 = “practice”
 * Output : 1
 * There is only one word between the closest occurrences of w1 and w2.
 * Input : s = “the quick the brown quick brown the frog”, w1 = “quick”, w2 = “frog”
 * Output : 2
 */
public class ClosestOccurrence {

    public static void main(String[] args) {
        String input = "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(closestOccurrence(input, w1, w2));
    }

    public static int closestOccurrence(String str, String w1, String w2) {
        if (str.isBlank() || w1.isBlank() || w2.isBlank()) {
            return -1;
        }

        int p1 = -1, p2 = -1;
        int minWordsDistance = Integer.MAX_VALUE;
        String[] words = str.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(w1)) {
                p1 = i;
                if (p2 != -1) {
                    int delta = Math.abs(p2 - p1 - 1);
                    minWordsDistance = Math.min(minWordsDistance, delta);
                }
            } else if (words[i].equals(w2)) {
                p2 = i;
                if (p1 != -1) {
                    int delta = Math.abs(p2 - p1 - 1);
                    minWordsDistance = Math.min(minWordsDistance, delta);
                }
            }
        }
        return minWordsDistance;
    }

}
