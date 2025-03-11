package arrays;

/**
 * Problem Statement:
 * Your task is ultimately to implement a function that takes in an array and an integer.
 * You want to return the *LENGTH* of the shortest subarray whose sum is at least the integer,
 * and -1 if no such sum exists.
 * Signature:
 * public static int subArrayExceedsSum(int arr[], int target) {}
 * Test Cases:
 * Input: [1,2,3,4,] , k=6
 * Output: 2
 * Input: [1,2,3,4,] , k=-1
 * Output: 12 => TODO: how is this 12 it should be 1
 */
public class SubArrayExceedingSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int k = 6;
        System.out.println(subArrayExceedsSum(arr, k));
    }

    /**
     * Time Complexity => O(n)
     * Space Complexity => O(1)
     */
    private static int subArrayExceedsSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int minLength = Integer.MAX_VALUE;
        int l = 0, sum = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];

            while (sum >= target && l <= r) {
                minLength = Math.min(r - l + 1, minLength);
                sum -= arr[l];
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}
