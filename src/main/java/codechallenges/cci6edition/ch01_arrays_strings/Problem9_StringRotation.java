package codechallenges.cci6edition.ch01_arrays_strings;

/**
 * Ch: Arrays And Strings
 * Problem 1.9
 *
 * <b>String Rotation:</b> Assume you have a method i5Substring which checks ifone word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g., waterbottle is a rotation of erbottlewat ).
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Problem9_StringRotation {

    /**
     * Time Complexity: O(n)
     */
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String big = s1 + s1;

        return isSubString(big, s2);
    }

    private static boolean isSubString(String big, String small) {
        return big.contains(small);
    }

    public static void main(String args[]) {
        System.out.println(isRotation("waterbottle", "erbottlewat")); // true
        System.out.println(isRotation("zaterbottle", "erbottlewat")); // false
    }
}
