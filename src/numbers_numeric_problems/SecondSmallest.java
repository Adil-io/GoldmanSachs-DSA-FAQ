package numbers_numeric_problems;

/**
 * Problem Statement
 * Returns second smallest element in array x. If x has fewer than 2 elements returns 0.
 * Signature:
 * int secondSmallest(int[] x){}
 * Test Cases:
 * Input:[ -1, 0, 1, -2, 2]
 * Output: -1
 * Input:[ 0, 1]
 * Output: 1
 */
public class SecondSmallest {

    public static void main(String[] args) {
        int[] x1 = new int[]{-1, 0, 1, -2, 2};
        int[] x2 = new int[]{0, 1};
        int[] x3 = new int[]{1, 1, 1};
        int[] x4 = new int[]{5};
        int[] x5 = new int[]{};

        System.out.println(secondSmallest(x1)); // Expected: -1
        System.out.println(secondSmallest(x2)); // Expected: 1
        System.out.println(secondSmallest(x3)); // Expected: 0
        System.out.println(secondSmallest(x4)); // Expected: 0
        System.out.println(secondSmallest(x5)); // Expected: 0
    }

    private static int secondSmallest(int[] x) {
        if (x.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : x) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num > min) {
                secondMin = num;
            }
        }
        return secondMin == Integer.MAX_VALUE ? 0 : secondMin;
    }

}
