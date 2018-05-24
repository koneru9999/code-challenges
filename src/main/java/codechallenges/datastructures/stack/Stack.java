package codechallenges.datastructures.stack;

import codechallenges.datastructures.linkedlist.Node;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class Stack<T> {

    private Node<T> head = null;

    /**
     * used to add elements into the stack.
     * <br>
     * Time Complexity: O(1)
     *
     * @param data
     */
    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            this.head = newNode;
            return;
        }

        newNode.setNext(head);
        this.head = newNode;
    }

    /**
     * use to remove and return elements from the stack
     * <br>
     * Time Complexity: O(1)
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is not initialized");
        }

        T headData = head.getData();
        this.head = head.getNext();

        return headData;
    }

    /**
     * returns the first value (what’s on top of the stack), but doesn’t remove it
     * <br>
     * Time Complexity: O(1)
     *
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is not initialized");
        }

        return head.getData();
    }

    /**
     * returns the number of elements that are in a stack at any given time
     *
     * @return
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        Node<T> current = head;
        int count = 1;
        while (current.getNext() != null) {
            current = current.getNext();
            count++;
        }

        return count;
    }

    /**
     * checks if the stack is empty or not — super helpful
     * when trying to clear all the elements from a stack
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        System.out.println("Stack ******");

        if (isEmpty()) {
            System.out.println("[]");
            System.out.println("Stack ******");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
        System.out.println("Stack ******");
    }
}
