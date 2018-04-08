/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * CamelCase.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/camelcase
 *
 * @author Venkaiah Chowdary Koneru
 */
public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        System.out.println(count);
    }
}
