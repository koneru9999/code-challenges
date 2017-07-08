/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * HackerRankInAString.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string
 *
 * @author Venkaiah Chowdary Koneru
 */
public class HackerRankInAString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        String hackerrank = "hackerrank";

        while (q-- > 0) {
            String s = in.next();

            int index = 0;
            boolean matched = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == hackerrank.charAt(index)) {
                    index++;
                }
                if (index == hackerrank.length()) {
                    System.out.println("YES");
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                System.out.println("NO");
            }
        }
        in.close();
    }
}
