package mathematics_problems;

/**
 * Problem Statement
 *  Returns true if x is a power-of-10, Otherwise returns false.
 * Signature:
 *  bool isPowerOf10(int x){}
 * Test Cases:
 *  INPUT/OUTPUT:
 *      Input1: 3
 *      Output1: false
 *  INPUT/OUTPUT:
 *      Input1: 10
 *      Output1: true
 */
public class IsPowerOf10 {

    public static void main(String[] args) {
        int x = 40;
        System.out.println(isPowerOf10(x));
    }

    private static boolean isPowerOf10(int x) {
        return x % 10 == 0;
    }

}
