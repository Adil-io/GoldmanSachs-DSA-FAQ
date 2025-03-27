package dynamic_programming;

import java.util.Arrays;

/**
 * Given an array of non-negative integers representing the elevations
 * from the vertical cross-section of a range of hills,
 * determine how many units of snow could be captured between the hills
 * i/p - {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}
 * o/p - 13
 */
public class SnowPackProblem {

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;

        int[] ldp = new int[n];
        ldp[0] = height[0];
        for (int i = 1; i < n; i++) {
            ldp[i] = Math.max(height[i], ldp[i - 1]);
        }

        int[] rdp = new int[n];
        rdp[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rdp[i] = Math.max(height[i], rdp[i + 1]);
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(ldp[i], rdp[i]);
            dp[i] = Math.abs(height[i] - min);
        }

        return Arrays.stream(dp)
                .filter(num -> num != 0)
                .sum();
    }

}
