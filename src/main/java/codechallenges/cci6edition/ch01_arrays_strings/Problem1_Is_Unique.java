package codechallenges.cci6edition.ch01_arrays_strings;

/**
 * Ch: Arrays And Strings
 * Problem 1.1
 *
 * <b>Is Unique:</b> Implement an algorithm to determine if a string has all uniques characters.
 *
 * If we can't use additional data structures, we can do the following:<br>
 * 1. Compare every character of the string to every other character of the string. This will take O(n^2) time
 * and 0(1) space.<br>
 * 2. If we are allowed to modify the input string, we could sort the string in O(n log(n)) time and then
 * linearly check the string for neighboring characters that are identical. Careful, though: many sorting
 * algorithms take up extra space.
 * @author Venkaiah Chowdary Koneru
 */
public class Problem1_Is_Unique {

    /**
     * Questions to ask: <br>
     * 1. is the string ASCII or unicode ?
     * 2. Does string contain repetitions ?
     *
     * Time Complexity: O(n)
     * or O(min(c, n)) where c is charcterset length
     *
     * Space Complexity: O(n).
     */
    public static boolean isUnique(String input) {
        if (input.length() > 128) {
            return false;
        }

        // Assumption: string is ASCII
        boolean[] asciiChars = new boolean[128];

        // count the number of occurrences of characters and store the count in char array
        for (char c : input.toCharArray()) {
            int pos = (int) c;
            if (asciiChars[pos]) {
                return false;
            }
            asciiChars[pos] = true;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isUnique("abcd"));
        System.out.println(isUnique("abcd"));
    }
}
