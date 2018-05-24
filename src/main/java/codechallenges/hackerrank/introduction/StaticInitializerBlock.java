/*
 * Copyright © 2018, All Rights Reserved
 *
 * StaticInitializerBlock.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 08, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.introduction;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-static-initializer-block
 *
 * @author Venkaiah Chowdary Koneru
 */
public class StaticInitializerBlock {

    static boolean flag = false;
    static Scanner in = new Scanner(System.in);
    static int B = Integer.parseInt(in.next());
    static int H = Integer.parseInt(in.next());

    static {
        in.close();

        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }

    }//end of main
}
