/*
 * Copyright © 2017, All Rights Reserved
 * 
 * CoinChangeProblem.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 09, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.hackerrank.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change
 *
 * @author Venkaiah Chowdary Koneru
 */
public class CoinChangeProblem {
    static long getWays(long n, long[] coins) {
        if (n < 0) {
            return 0;
        }
        return getWays(n, coins, 0, new HashMap<>());
    }

    static long getWays(long n, long[] coins, int coinNumber, HashMap<String, Long> cache) {
        /* Check our cache */
        String key = n + "," + coinNumber;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        /* Base case */
        if (coinNumber == coins.length - 1) {
            if (n % coins[coinNumber] == 0) {
                cache.put(key, 1L);
                return 1;
            } else {
                cache.put(key, 0L);
                return 0;
            }
        }
        /* Recursive case */
        long ways = 0;
        for (int i = 0; i <= n; i += coins[coinNumber]) {
            ways += getWays(n - i, coins, coinNumber + 1, cache);
        }
        /* Cache and return solution */
        cache.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];

        for (int c_i = 0; c_i < m; c_i++) {
            c[c_i] = in.nextLong();
        }
        in.close();

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        System.out.println(getWays(n, c));
    }
}
