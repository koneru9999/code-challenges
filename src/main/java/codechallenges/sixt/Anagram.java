package codechallenges.sixt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class Anagram {

    /**
     * Step 1: Collect the count of each character in lhs <br>
     * Step 2: iterate over rhs string characters to validate following conditions <br>
     *      Step 2.1:   if a matching character exists in lhs <br>
     *      Step 2.2:   if the count is more than 0 <br>
     *
     * @param lhs
     * @param rhs
     * @return
     */
    public static boolean isAnagram(final String lhs, String rhs) {
        // they are not anagrams if null or having different length
        if (lhs == null
                || rhs == null
                || lhs.length() != rhs.length()) {
            return false;
        }

        // initialize a map to store count of occurrences of a character
        Map<Character, Integer> lhsMap = new HashMap<>();

        // iterate over characters to collect the count of each letter (case insensitive)
        for (char letter : lhs.toLowerCase().toCharArray()) {
            if (lhsMap.containsKey(letter)) {
                lhsMap.put(letter, lhsMap.get(letter) + 1);
            } else {
                lhsMap.put(letter, 1);
            }
        }

        // iterate over second string characters (case insensitive)
        for (char letter : rhs.toLowerCase().toCharArray()) {
            // not anagram if there is un-matched letter
            if (!lhsMap.containsKey(letter)) {
                return false;
            }

            int count = lhsMap.get(letter);
            if (count > 0) {
                lhsMap.put(letter, count - 1);
            } else { // if count is zero means individual characters are not exactly matched
                return false;
            }
        }

        // We will not reach here if there is any count mismatch or un-matched characters. so, rhs is an anagram
        return true;
    }
}
