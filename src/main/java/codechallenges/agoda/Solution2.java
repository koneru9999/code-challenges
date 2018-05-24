package codechallenges.agoda;

import java.util.Scanner;

/**
 * Calculate the square of given number.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] testData = new int[0];
        if (in.hasNext()) {
            String[] input = in.next().split(",");
            testData = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                testData[i] = Integer.parseInt(input[i]);
            }
        } else {
            System.out.println("566F69642053717561726528496E74333220427952656629");
        }

        Solution2 program = new Solution2();
        program.run(testData);
    }

    private void square(int data) {
        System.out.println(data*data);
    }

    private void run(int[] testData) {
        for (int i = 0; i < testData.length; i++) {
            int data = testData[i];
            square(data);
        }
    }
}
