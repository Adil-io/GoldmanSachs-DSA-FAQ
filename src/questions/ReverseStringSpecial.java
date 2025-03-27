package questions;

public class ReverseStringSpecial {

    public static void main(String[] args) {
        String str = "a@#bc,d";
        System.out.println(reverseString(str));
    }

    public static String reverseString(String str) {
        int l = 0, r = str.length() - 1;
        char[] charArray = str.toCharArray();
        while (l < r) {
            while (!Character.isLetter(charArray[l])) {
                l++;
            }

            while (!Character.isLetter(charArray[r])) {
                r--;
            }

            char ch = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = ch;
            l++;
            r--;
        }
        return new String(charArray);
    }
}
