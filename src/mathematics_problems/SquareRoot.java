package mathematics_problems;

/**
 * Problem Statement
 *  Returns square root of the given double
 * Signature:
 *  double squareRoot( double x ){}
 * Test Cases:
 *  Input1: 4
 *  Output1: 2
 *  Input2: 2
 *  Output2: 1.41421
 */
public class SquareRoot {

    public static void main(String[] args) {
        int x = 2;
        System.out.println(squareRoot(x));
    }

    private static double squareRoot(double x) {
        double low = 0, high = x;
        double tolerance = 1e-7;
        double mid = 0;

        while ((high - low) > tolerance) {
            mid = (low + high) / 2;
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return Double.parseDouble(String.format("%.5f", mid));
    }

}
