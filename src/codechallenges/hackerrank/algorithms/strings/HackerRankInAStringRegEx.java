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
 * <p>
 * RegEx version
 *
 * @author Venkaiah Chowdary Koneru
 */
public class HackerRankInAStringRegEx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        while (q-- > 0) {
            String s = in.next();

            if (s.matches(".*h.*a.*c.*k.*e.*r.*r.*a.*n.*k.*")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        in.close();
    }
}
