/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * MarsExploration.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 08, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 *
 * @author Venkaiah Chowdary Koneru
 */
public class MarsExploration {
    public static void main(String[] s) {
        Scanner in = new Scanner(System.in);

        String S = in.next();
        in.close();

        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != sos.charAt(i % 3)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
