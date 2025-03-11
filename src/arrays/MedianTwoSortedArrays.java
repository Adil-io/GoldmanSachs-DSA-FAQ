package arrays;

import java.util.Scanner;

/**
 * Problem Statement:
 * Find the median of the two sorted arrays
 * Signature:
 * public static double findMedianSortedArrays(int[] A, int[] B) {}
 * Test Cases:
 * Input:
 * Arr1 = [1,3];
 * Arr2 = [2,4];
 * Output:
 * 2.5
 * Input:
 * Arr1 = [1,3]
 * Arr2 = [2]
 * Output:2.0
 */
public class MedianTwoSortedArrays {

    private static final Scanner sc = new Scanner(System.in);

    private static int[] getArrFromUser(String input) {
        String[] strArr = input.split("\\s+");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3};
        int[] B = new int[]{2};
        System.out.println(findMedianSortedArrays(A, B));
    }

    /**
     * Time Complexity => O(m+n)
     * Space Complexity => O(m+n)
     */
    private static double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;
        int[] arr = new int[n];
        int i = 0, a = 0, b = 0;
        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                arr[i++] = A[a++];
            } else {
                arr[i++] = B[b++];
            }
        }
        while (a < A.length) {
            arr[i++] = A[a++];
        }
        while (b < B.length) {
            arr[i++] = B[b++];
        }

        if (n % 2 == 0) {
            double median = arr[(n - 1) / 2] + arr[((n - 1) / 2) + 1];
            return median / 2;
        } else {
            return arr[n / 2];
        }
    }

}
