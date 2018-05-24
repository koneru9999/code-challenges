/*
 * Copyright © 2018, All Rights Reserved
 *
 * AVeryBigSum.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Apr 11, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum
 *
 * @author Venkaiah Chowdary Koneru
 */
public class AVeryBigSum {
    /*
     * Complete the aVeryBigSum function below.
     */
    static long aVeryBigSum(int n, long[] ar) {
        /*
         * Write your code here.
         */
        return Arrays.stream(ar).reduce(0, Long::sum);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        long[] ar = new long[n];

        String[] arItems = scan.nextLine().split(" ");

        for (int arItr = 0; arItr < n; arItr++) {
            long arItem = Long.parseLong(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        long result = aVeryBigSum(n, ar);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}
