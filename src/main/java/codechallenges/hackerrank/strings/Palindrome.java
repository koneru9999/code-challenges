package codechallenges.hackerrank.strings;

import java.util.Scanner;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String[] strArr = A.split("");

        int forwardIndex = 0;
        int backwardIndex = strArr.length - 1;
        boolean isPalindrome = true;
        while (backwardIndex > forwardIndex) {
            if (!strArr[forwardIndex].equals(strArr[backwardIndex])) {
                isPalindrome = false;
            }
            ++forwardIndex;
            --backwardIndex;
        }

        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
