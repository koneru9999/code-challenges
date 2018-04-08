/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * SuperReducedString.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.strings;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 *
 * @author Venkaiah Chowdary Koneru
 */
public class SuperReducedString {

    static String super_reduced_string(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop(); // since String has 2 adjacent equal characters
            } else {
                stack.push(ch);
            }
        }

        /* Print final result */
        if (stack.isEmpty()) {
            return "Empty String";
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();

        String result = super_reduced_string(s);

        System.out.println(result);
    }
}
