package codechallenges.test.datastructres.stack;

import codechallenges.datastructures.stack.Stack;

public class StackTest {

    public static void pushTest() {
        Stack<String> stack = getNewInstance();

        stack.print();

        stack.push("abc");
        stack.push("def");
        stack.push("ghi");

        stack.print();
    }

    public static void popTest() {
        Stack<String> stack = getNewInstance();

        stack.print();

        stack.push("abc");
        stack.push("def");
        stack.push("ghi");

        stack.print();

        System.out.println(stack.pop().getData());

        stack.print();
    }

    public static void peekTest() {
        Stack<String> stack = getNewInstance();

        stack.print();

        stack.push("abc");
        stack.push("def");
        stack.push("ghi");

        stack.print();

        System.out.println(stack.top().getData());

        stack.print();
    }

    public static void main(String[] args) {
//        pushTest();

//        popTest();

        peekTest();
    }

    public static <T> Stack<T> getNewInstance() {
        return new Stack<>();
    }
}
