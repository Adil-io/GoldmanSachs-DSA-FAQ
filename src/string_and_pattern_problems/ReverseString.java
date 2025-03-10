package string_and_pattern_problems;

/**
 * Problem Statement :
 * Takes String str and returns a new String
 * such that the characters are in reversed order.
 * Example: reverseStr(str) where str is "abcd" returns "dcba".
 * Signature: public static String reverseStr( String str ){}
 * Test Cases:
 * Input : abcd
 * Output: dcba
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(reverseStr(str));
    }

    private static String reverseStr(String str) {
        char[] charArray = str.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n / 2; i++) {
            char ch = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1 - i] = ch;
        }
        return new String(charArray);
    }

}
