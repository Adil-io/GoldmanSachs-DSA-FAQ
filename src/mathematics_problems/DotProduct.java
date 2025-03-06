package mathematics_problems;

/**
 * Problem Statement
 *  Given two arrays of integers, returns the dot product of the arrays.
 * Signature:
 *  long dotProduct( int[] array1, int array2[] ){}
 * Test Cases:
 *  INPUT:
 *      array1 = [1, 2];
 *      array2 = [2, 3];
 *  OUTPUT:
 *      Hint {1*2+2*3}
 *      Result =[8]
 */
public class DotProduct {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3};
        int[] array2 = new int[]{2,3};
        System.out.println(dotProduct(array1, array2));
    }

    private static long dotProduct(int[] array1, int[] array2) {
        long arr1Product = 1;
        for (int i : array1) {
            arr1Product *= i;
        }
        long arr2Product = 1;
        for (int i : array2) {
            arr2Product *= i;
        }
        return arr1Product + arr2Product;
    }

}
