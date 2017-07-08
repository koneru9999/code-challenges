/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * FunnyStrings.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 *
 * @author Venkaiah Chowdary Koneru
 */
public class FunnyStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());

        while (n-- > 0) {
            System.out.println(funnyString(in.next()));
        }
        in.close();
    }

    private static String funnyString(String s) {
        for (int i = 0; i < Math.floor(s.length() / 2); i++) {
            int s1 = (int) s.charAt(i);
            int s2 = (int) s.charAt(i + 1);
            int r1 = (int) s.charAt(s.length() - i - 1);
            int r2 = (int) s.charAt(s.length() - i - 2);

            if (Math.abs(s1 - s2) != Math.abs(r1 - r2)) {
                return "Not Funny";

            }
        }
        return "Funny";
    }
}
