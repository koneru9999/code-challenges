/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * WeightedUniformStrings.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.strings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * @author Venkaiah Chowdary Koneru
 */
public class WeightedUniformStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();

        HashSet<Integer> weights = new HashSet<>();
        int weight = 0;
        char prev = ' '; // so it doesn't match 1st character

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr != prev) {
                weight = 0;
            }
            weight += curr - 'a' + 1;
            weights.add(weight);
            prev = curr;
        }

        while (n-- > 0) {
            int x = in.nextInt();
            System.out.println(weights.contains(x) ? "Yes" : "No");
        }
    }
}
