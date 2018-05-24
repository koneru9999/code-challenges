package codechallenges.test.datastructres.stack;

import codechallenges.datastructures.Node;
import codechallenges.datastructures.linkedlist.LinkedList;
import codechallenges.datastructures.stack.Stack;

public class ReverseLinkedListWithStack {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addNode("abc");
        list.addNode("def");
        list.addNode("ghi");

        list.print();

        Node<String> current = list.getHead();

        Stack<String> stack = new Stack<>();
        while(current != null) {
            stack.push(current.getData());
            current = current.getNext();
        }

        Node<String> temp = stack.pop();
        list.setHead(temp);
        while (!stack.isEmpty()) {
            temp.setNext(stack.pop());

            temp = temp.getNext();
        }

        list.print();
    }
}
