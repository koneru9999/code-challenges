package codechallenges.cci6edition.ch01_arrays_strings;

/**
 * Ch: Arrays And Strings
 * Problem 1.2
 *
 * <b>Check Permutation:</b> Given two strings, write a method to decide if one is a permutation of the
 * other.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Problem2_CheckPermutation {

    /**
     * Time Complexity : O(n^2)
     * Space Complexity: O(1)
     */
    public static boolean checkPermutation(String one, String other) {
        if (one.length() != other.length()) {
            return false;
        }

        int k = 0;
        while (k < other.length()) {

            for (int i = 0; i < one.length(); i++) {
                char[] charArr = one.toCharArray();
                if (i != k) {
                    char temp = charArr[i];
                    charArr[i] = one.charAt(k);
                    charArr[k] = temp;

                    if (other.equals(new String(charArr))) {
                        return true;
                    }
                }
            }

            k++;
        }
        return true;
    }

    /**
     * Time Complexity : O(2n)
     * Space Complexity : O(1)
     */
    public static boolean elegantCheckPermutation(String one, String other) {
        if (one.length() != other.length()) {
            return false;
        }

        // Assumption is that Strings are ASCII charset based
        int[] charSetArr = new int[128];

        for (char c : one.toCharArray()) {
            charSetArr[c] += 1;
        }

        for (char c : other.toCharArray()) {
            charSetArr[c]--;
            if (charSetArr[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(elegantCheckPermutation("abcd", "acdb")); // True

        System.out.println(elegantCheckPermutation("asaf", "afaa")); // False
    }
}
