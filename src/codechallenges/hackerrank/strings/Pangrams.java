/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * Pangrams.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 08, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Pangrams {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next().replaceAll("[^\\p{IsAlphabetic}]", "").toLowerCase();

        in.close();

        if (s.length() < 26) {
            System.out.println("not pangram");
            return;
        }

        for (int i = 97; i < 123; i++) {
            if (!s.contains(String.valueOf((char) i))) {
                System.out.println("not pangram");
                return;
            }
        }
        System.out.println("pangram");
    }
}
