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
import java.util.stream.Collectors;

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

        System.out.println(s.chars().boxed().collect(Collectors.toSet()).size() == 26 ? "panagram" : "not panagram");
    }
}
