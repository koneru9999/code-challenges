/*
 * Copyright © 2017, All Rights Reserved
 * 
 * AdjacentMaxDistance.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jul 22, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.rakuten;

import java.util.Arrays;

/**
 * Integer V lies strictly between integers U and W if U < V < W or if U > V > W
 * <p>
 * A non empty zero indexed array A consisting of N integers is given.
 * A pair of indices (P, Q), where 0 <= P < Q < N, is said to have 'adjacent values'
 * if no value in the array lies strictly between values A[P] and A[Q],
 * and in addition A[P] != A[Q]
 * <p>
 * For example, in array A such that:
 * A[0] = 0
 * A[1] = 3
 * A[2] = 3
 * A[3] = 7
 * A[4] = 5
 * A[5] = 3
 * A[6] = 11
 * A[7] = 1
 * <p>
 * the following pairs of indices have adjacent values:
 * (0,7), (1,4), (1,7)
 * (2,4), (2,7), (3,4)
 * (3,6), (4,5), (5,7)
 * <p>
 * For example, indices 4 and 5 have adjacent values because the values a[4] = 5 and A[5] = 3 are different
 * and there is no value in array A that lies strictly between them
 * the only such value could be the number 4, which is not present in the array
 * <p>
 * Given two indices P and Q, their distance is defined as abs(P-Q)
 * where abs(X) = X for X>=0
 * and abs(X) = -X for X<=0
 * For example the distance between indices 4 and 5 is 1 because abs(4-5) = abs(5-4) = 1
 * <p>
 * Write a function that given a non-empty zero-indexed array A consisting of N integers
 * returns the maximum distance between indices of this array that have adjacent values
 * The function should return -1 if no adjacent indices exist
 * <p>
 * For example given array A such that:
 * A[0] = 1
 * A[1] = 4
 * A[2] = 7
 * A[3] = 3
 * A[4] = 3
 * A[5] = 5
 * <p>
 * the function should return 4 because:
 * - indices 0 and 4 are adjacent because A[0] != A[4]
 * and the array does not contain any value that lies strictly between A[0] = 1 and A[4] = 3
 * - the distance between these indices is abd(0-4) = 4
 * - no other pair of adjacent indices that has a larger distance exists
 * <p>
 * Assume that
 * - N is an integer within the range [1 .. 40,000]
 * - each element of array A is an integer within the range [-2,147,483,648 to 2,147,483,647]
 *
 * @author Venkaiah Chowdary Koneru
 */
public class AdjacentMaxDistance {

    /**
     * @param myArray
     * @param sortedArray
     * @param index1
     * @param index2
     * @return
     */
    public static boolean areAdjacent(int[] myArray, int[] sortedArray, int index1, int index2) {
        int value1, value2;
        int minval, maxval;

        value1 = myArray[index1];
        value2 = myArray[index2];

        if (value1 == value2) {
            return false;
        }

        index1 = Arrays.binarySearch(sortedArray, value1);
        index2 = Arrays.binarySearch(sortedArray, value2);

        minval = Math.min(index1, index2);
        maxval = Math.max(index1, index2);

        for (int between = minval + 1; between < maxval; between++) {
            if ((sortedArray[between] != value1) && (sortedArray[between] != value2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param A
     * @return
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        int absval = -1;
        int maxabsolute = -1;

        int[] sortedArray = A.clone();
        Arrays.sort(sortedArray);

        for (int i = 0; i < A.length; i++) {
            for (int j = (i + 1); j < A.length; j++) {
                if (areAdjacent(A, sortedArray, i, j)) {
                    absval = Math.abs(i - j);
                    if (absval > maxabsolute) {
                        maxabsolute = absval;
                    }
                }
            }
        }
        return maxabsolute;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AdjacentMaxDistance adj = new AdjacentMaxDistance();

        System.out.print(adj.solution(new int[]{1, 4, 7, 3, 3, 5}));
    }
}
