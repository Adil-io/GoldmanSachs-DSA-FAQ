package mathematics_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 *  Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
 *  Some fractions in decimal form have cyclic decimal points.
 * Signature:
 *  public static String vulgarToDecimal(Long numerator, Long denominator) {}
 * Test Cases:
 *  vulgarToDecimal(1l, 2l).equals("0.5");
 *  vulgarToDecimal(1l, 3l).equals("0.(3)");
 *  vulgarToDecimal(1l, 30l).equals("0.0(3)");
 *  vulgarToDecimal(1l, 75l).equals("0.01(3)");
 *  vulgarToDecimal(4l, 7l).equals("0.(571428)");
 */
public class DecimalConversion {

    public static void main(String[] args) {
        Long numerator = 22L;
        Long denominator = 7L;
        System.out.println(vulgarToDecimal(numerator, denominator));
    }

    private static String vulgarToDecimal(Long numerator, Long denominator) {
        StringBuilder sb = new StringBuilder();
        sb.append(numerator / denominator);
        long rem = numerator % denominator;
        if (rem == 0) {
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> hm = new HashMap<>();
        while (rem != 0) {
            if (hm.containsKey(rem)) {
                sb.insert(hm.get(rem), "(");
                sb.append(")");
                break;
            }
            hm.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / denominator);
            rem %= denominator;
        }
        return sb.toString();
    }

}
