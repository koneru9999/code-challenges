package codechallenges.hackerrank.algorithms.warmup;

/*
 * Copyright © 2018, All Rights Reserved
 *
 * Staircase.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 12, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/staircase
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Staircase {

    /*
     * Complete the staircase function below.
     */
    static void staircase(int n) {
        /*
         * Write your code here.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1 - i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        staircase(n);
    }
}
