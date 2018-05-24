package codechallenges.datastructures.queue;

import codechallenges.datastructures.Node;

/**
 * Queue implementation with LinkedList
 *
 * @param <T>
 * @author Venkaiah Chowdary Koneru
 */
public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * Pushes to end of the list<br>
     * Time Complexity : O(1)
     *
     * @param data
     */
    public void enQueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        }

        tail.setNext(newNode);
        this.tail = newNode;
    }

    /**
     * Remove first element from the list and points the head to next element
     * <br>
     * Time Complexity : O(1)
     *
     * @return
     */
    public Node<T> deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is not initialized");
        }

        Node<T> currentHead = head;
        this.head = head.getNext();
        return currentHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        System.out.println("QUEUE ******");

        if (isEmpty()) {
            System.out.println("[]");
            System.out.println("QUEUE ******");
            return;
        }

        Node<T> node = head;
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }

        System.out.println("QUEUE ******");
    }
}
