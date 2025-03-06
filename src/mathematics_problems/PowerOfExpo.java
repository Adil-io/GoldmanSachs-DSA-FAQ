package mathematics_problems;

/**
 * Problem Statement
 *  Given base and integer exponent, compute value of base raised to the power of exponent.
 * Signature:
 *  public static double power(double base, int exp) {}
 * Test Cases:
 *  Input: 2.0
 *         4
 *  Output: 16.0
 */
public class PowerOfExpo {

    public static void main(String[] args) {
        double base = 2;
        int exp = 4;
        System.out.println(power(base, exp));
    }

    private static double power(double base, int exp) {
        double pow = 1;
        while (exp-- > 0) {
            pow *= base;
        }
        return pow;
    }

}
