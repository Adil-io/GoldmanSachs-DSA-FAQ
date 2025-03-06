package mathematics_problems;

import java.util.ArrayList;

/**
 * Problem Statement:
 *  Return an array containing prime numbers whose product is x
 * Examples:
 *  primeFactorization( 6 ) == [2,3]
 *  primeFactorization( 5 ) == [5]
 *  primeFactorization( 12 ) == [2,2,3]
 * Signature:
 *  public static ArrayList<Integer> primeFactorization(int x) {}
 * Test Cases
 *  Input: 6
 *  Output:[2,3]
 */
public class PrimeFactorization {

    public static void main(String[] args) {
        int x = 12;
        System.out.println(primeFactorization(x));
    }

    private static ArrayList<Integer> primeFactorization(int x) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= x; i++) {
            while (x % i == 0) {
                factors.add(i);
                x /= i;
            }
        }
        return factors;
    }

}
