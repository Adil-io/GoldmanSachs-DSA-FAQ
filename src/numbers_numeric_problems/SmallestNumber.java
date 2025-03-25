package numbers_numeric_problems;

/**
 * Problem Statement
 * Returns the smallest number in array that has been rotated
 * For example - Array {3,4,5,6,1,2} returns 1
 * Input array was originally sorted in increasing orders
 * FindMinInArray must have O(log n) runtime
 * Input array does not have any duplicates
 * Signature:
 * public static int FindMin(int a[]){}
 * Test Cases:
 * Input: [3, 4, 5, 6, 1, 2]
 * Output: 1
 * Input: [2, 1]
 * Output:1
 */
public class SmallestNumber {

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println(findMin(a));
        System.out.println(findMinInArray(a));
    }

    private static int findMin(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int num : a) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static int findMinInArray(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > a[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return a[left];
    }

}
