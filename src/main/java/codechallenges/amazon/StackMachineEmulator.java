package codechallenges.amazon;

import java.util.Stack;

/**
 * A stack machine is a simple system that performs arithmetic operations on an input string of numbers and operators.
 * It contains a stack that can store an arbitrary number of 12-bit unsigned integers. Initially the stack is empty.
 * The machine processes a string of characters in the following way:
 * <p>
 * •	the characters of the string are processed one by one;
 * •	if the current character is a digit ('0'-'9'), the machine pushes the value of that digit onto its stack;
 * •	if the current character is '+', the machine pops the two topmost values from its stack, adds them and pushes the result onto the stack;
 * •	if the current character is '+', the machine pops the two topmost values from its stack, adds them and pushes the result onto the stack;
 * •	if the current character is '*', the machine pops the two topmost values from its stack, multiplies them and pushes the result onto the stack;
 * •	after the machine has processed the whole string it returns the topmost value of its stack as the result;
 * •	the machine reports an error if any operation it performs (addition or multiplication) results in an overflow;
 * •	the machine reports an error if it tries to pop an element from its stack when the stack is empty, or if the stack is empty after the machine has processed the whole string.
 * <p>
 * For example, given the string "13+62*7+*" the machine will perform the following operations:
 * <p>
 * <p>
 * The machine will return 76 as the result as it is the topmost element of its stack.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters containing input for the stack machine, returns the result
 * the machine would return if given this string. The function should return -1 if the machine would report an error
 * when processing the string.
 * <p>
 * For example, given string S = "13+62*7+*" the function should return 76, as explained in the example above.
 * Given string S = "11++" the function should return -1.
 * <p>
 * Assume that:
 * •	the length of S is within the range [0..200,000];
 * •	string S consists only of the following characters: "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+" and/or "*".
 * <p>
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class StackMachineEmulator {

    public static int solution(String S) {
        if (!S.matches("^[0-9\\*\\+]+$")) {
            return -1;
        }

        Stack<Long> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if(c >= '0' && c <= '9') {
                stack.push((long) (c - '0'));
            } else {
                if (stack.isEmpty() || stack.size() < 2) {
                    return -1;
                }
                long newValue = (c == '+') ? stack.pop() + stack.pop() : stack.pop() * stack.pop();

                if (newValue > Integer.MAX_VALUE) {
                    return -1;
                }
                stack.push(newValue);
            }
        }

        return stack.pop().intValue();
    }

    public static void main(String[] args) {
        System.out.println(solution("13+62*7+*")); // 76
        System.out.println(solution("99*9")); // 9
        System.out.println(solution("99*9*1+")); // 730

        System.out.println(solution("13+62*7-*")); // -1
        System.out.println(solution("abc1234+")); // -1
        System.out.println(solution("2+2=4")); // -1
        System.out.println(solution("")); // -1

        StringBuilder sb = new StringBuilder();
        sb.append("99*");
        for(int i = 0; i < 1500; i++)
            sb.append("9*");

        System.out.println(solution(sb.toString())); // 9

        sb = new StringBuilder();
        for(int i = 0; i < 33333; i++)
            sb.append("55*44+");
        sb.append("2+");
        System.out.println(sb.toString().length() +" : " + solution(sb.toString())); // 10
    }
}
