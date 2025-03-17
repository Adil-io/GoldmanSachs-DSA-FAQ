package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 * [["Bobby", "87"],
 * ["Charles", "100"],
 * ["Eric", "64"],
 * ["Charles", "22"]].
 * Expected output: 87
 * Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric, respectively.
 * 87 is the highest.
 */
public class MaxAverage {

    public static void main(String[] args) {
        Map<String[][], Integer> testCases = new HashMap<>();
        testCases.put(new String[][]{
                {"Bobby", "87"},
                {"Charles", "100"},
                {"Eric", "64"},
                {"Charles", "22"}
        }, 87);
        testCases.put(new String[][]{
                {"Sarah", "91"},
                {"Goldie", "92"},
                {"Elaine", "93"},
                {"Elaine", "95"},
                {"Goldie", "94"},
                {"Sarah", "93"}
        }, 94);
        testCases.put(new String[][]{
                {"Janie", "-66"},
                {"Janie", "0"},
                {"Gina", "-88"},
                {"Bobby", "0"},
                {"Gina", "44"},
                {"Bobby", "0"},
                {"Bobby", "-6"}
        }, -2);

        testCases.forEach((input, output) -> {
            int result = maxAverage(input);
            if (result == output) {
                System.out.println("Input : " + Arrays.deepToString(input));
                System.out.println("Passed : Output = " + result);
            } else {
                System.err.println("Input : " + Arrays.deepToString(input));
                System.err.println("Failed : Expected = " + output + " : Output = " + result);
            }
        });
    }

    public static int maxAverage(String[][] input) {
        Map<String, int[]> hm = new HashMap<>();
        for (String[] strings : input) {
            String name = strings[0];
            int score = Integer.parseInt(strings[1]);
            int[] sumAndCount = new int[2];
            if (hm.containsKey(name)) {
                sumAndCount = hm.get(name);
            }
            sumAndCount[0] += score;
            sumAndCount[1]++;
            hm.put(name, sumAndCount);
        }

        int maxAvg = Integer.MIN_VALUE;
        for (int[] num : hm.values()) {
            int avg = num[0] / num[1];
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}
