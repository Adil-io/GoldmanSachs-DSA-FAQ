package mathematics_problems;

import java.util.Arrays;

/**
 * Problem Statement
 * Given two fractions passed in as int arrays,
 * returns the fraction which is result of adding the two input fractions
 * Fraction is represented as a two-element array - [ numerator, denominator ]
 * The returned fraction has to be in its simplest form.
 * Signature:
 *  int[] addFractions ( int[] fraction1, int[] fraction2 ){}
 * Test Cases:
 *  INPUT:
 *      fraction1 - [2, 3];
 *      fraction2 - [1, 2];
 *  OUTPUT:
 *      Hint- {2/3 + 1/2}
 *      result = [7,6]
 */
public class AddFraction {

    public static void main(String[] args) {
        int[] fraction1 = new int[]{2, 3};
        int[] fraction2 = new int[]{1, 3};

        System.out.println(Arrays.toString(addFractions(fraction1, fraction2)));
    }

    private static int[] addFractions(int[] fraction1, int[] fraction2) {
        int n1 = fraction1[0], d1 = fraction1[1];
        int n2 = fraction2[0], d2 = fraction2[1];

        int numerator = n1 * d2 + n2 * d1;
        int denominator = d1 * d2;
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator/gcd, denominator/gcd};
    }

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }

}
