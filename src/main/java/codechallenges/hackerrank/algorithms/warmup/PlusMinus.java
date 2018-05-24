/*
 * Copyright © 2018, All Rights Reserved
 *
 * PlusMinus.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 11, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.warmup;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/plus-minus
 *
 * @author Venkaiah Chowdary Koneru
 */
public class PlusMinus {
    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        /*
         * Write your code here.
         */
        long positive = 0;
        long negative = 0;
        long zero = 0;

        for (int a: arr) {
            if (a > 0) {
               positive++;
            } else if (a < 0) {
                negative++;
            } else {
                zero++;
            }
        }

        /*positive = Arrays.stream(arr)
                .filter(p -> p > 0).count();

        negative = Arrays.stream(arr)
                .filter(p -> p < 0).count();

        zero = Arrays.stream(arr)
                .filter(p -> p == 0).count();*/

        NumberFormat fomratter = NumberFormat.getInstance();
        fomratter.setMinimumFractionDigits(6);

        System.out.println(fomratter.format(((double)positive)/arr.length));
        System.out.println(fomratter.format(((double)negative)/arr.length));
        System.out.println(fomratter.format(((double)zero)/arr.length));
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}
