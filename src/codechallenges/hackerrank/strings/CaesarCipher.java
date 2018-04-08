/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * CaesarCipher.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 08, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 *
 * @author Venkaiah Chowdary Koneru
 */
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        String s = in.next();
        int k = Integer.parseInt(in.next());

        in.close();

        System.out.println(Arrays.stream(s.split("")).map(c -> {
            int ch = c.charAt(0);
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                return Character.toString((char) ((ch - base + k) % 26 + base));
            }
            return c;
        }).collect(Collectors.joining()));
    }
}
