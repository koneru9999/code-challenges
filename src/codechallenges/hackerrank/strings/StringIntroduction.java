/*
 * Copyright © 2018, All Rights Reserved
 *
 * StringIntroduction.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 08, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-strings-introduction
 *
 * @author Venkaiah Chowdary Koneru
 */
public class StringIntroduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1));
    }
}
