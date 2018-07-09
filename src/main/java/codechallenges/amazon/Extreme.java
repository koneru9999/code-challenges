package codechallenges.amazon;

/**
 * A zero-indexed array A consisting of N integers is given. The average value of array A is defined as:
 * <p>
 * (A[0] + A[1] + ... + A[N-1]) / N
 * <p>
 * The deviation of element A[P] (where 0 ≤ P < N) is defined as |A[P] - M|, where M is the average value of array A.
 * <p>
 * Element A[P] is called extreme if its deviation is maximal among all the elements of A.
 * <p>
 * For example, consider the following array A consisting of four elements:
 * •	A[0] = 9
 * •	A[1] = 4
 * •	A[2] = -3
 * •	A[3] = -10
 * <p>
 * The average value of this array is (9 + 4 + (-3) + (-10)) / 4 = 0. The deviation of element A[2]
 * is |(-3) - 0| = |0 - (-3)| = 3. The deviation of element A[3] is 10. It is an extreme element of array A,
 * since no other element has a deviation greater than 10. There are no other extreme elements in this array.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers, returns the index of an extreme element.
 * If more than one extreme element exists, the function may return the index of any of them. If the array is
 * empty (and hence no extreme element exists), the function should return -1.
 * <p>
 * For example, given array A shown above, the function should return 3, since A[3] is the only extreme element.
 * <p>
 * Assume that:
 * •	N is an integer within the range [0..100,000];
 * •	each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
 * <p>
 * Complexity:
 * •	expected worst-case time complexity is O(N);
 * •	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * <p>
 * Elements of input arrays can be modified.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Extreme {

    public static int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        int maxValue = A[0];
        int minValue = A[0];
        int maxIndex = 0;
        int minIndex = 0;

        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > maxValue) {
                maxValue = A[i];
                maxIndex = i;
            } else if (A[i] < minValue) {
                minValue = A[i];
                minIndex = i;
            }
            sum += A[i];
        }

        double avg = sum * 1.0 / A.length;

        return Math.abs(minValue - avg) > Math.abs(maxValue - avg) ? minIndex : maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 4, -3, -10})); // 3
        System.out.println(solution(new int[]{2, 1, 2})); // 1
        System.out.println(solution(new int[]{-10, 9, 4, -3})); // 0
        System.out.println(solution(new int[]{-41, 75, -19, 79, -10, -79, 69, 91, -36, -45, -62, 67,
                -2, -92, -75, -21, 14, -55, 13, 52})); // 7
        System.out.println(solution(new int[]{-20, 19, -19, 4, -8, 17, 2, 7, 0, -16})); // 1
        System.out.println(solution(new int[]{722314384, -1260508779, 1665517200, -214646912, -1381334706, -813291737,
                -951050307, 601407129, 892613969, -608436879})); // 2
    }
}
