package codechallenges.test.datastructres.stack;

import codechallenges.datastructures.stack.Stack;

public class ReverseStringWithStackTest {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "HELLO";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int size = stack.size();

        while (size > 0) {
            System.out.print(stack.pop().getData());
            size--;
        }
    }
}
