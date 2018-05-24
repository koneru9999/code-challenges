/*
 * Copyright © 2018, All Rights Reserved
 *
 * LinkedList.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jan 27, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.datastructures.linkedlist;

/**
 * Linked lists are List data structures - They can store
 * multiple elements as a list. <br/>
 * Each element is linked to or references
 * the next element - the elements are chained together.<br/>
 * The way to access linked list is via the very first element in the list
 * called head. <br/>
 *
 * @author Venkaiah Chowdary Koneru
 */
public class LinkedList<T> {

    /**
     * Initially, the head will be NULL. As we create and add nodes to the list,
     * the head will reference the first element in the list.
     */
    protected Node<T> head = null;

    /**
     * Appends a new node with some data to the very end of the list.
     * This involves traversing the list to the very end and then adding a node.
     * Remember the newly added node should have the next set to NULL.
     * <br>
     * Time Complexity: O(n)
     *
     * @param data
     */
    public void addNode(T data) {
        if (head == null) {
            this.head = new Node<>(data);
            return;
        }
        Node<T> currNode = head;
        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }
        currNode.setNext(new Node<>(data));

    }

    /**
     * Appends a new node with some data to the very beginning of the list.
     * This involves chanigng the head's next to the new node
     * <br>
     * Time Complexity: O(1)
     *
     * @param data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            this.head = newNode;
            return;
        }

        newNode.setNext(head.getNext());
        head.setNext(newNode);
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     * <br>
     * Time Complexity: O(n)
     *
     * @param data
     * @param n
     */
    public void insertAt(int n, T data) {
        if (size() < n) {
            return;
        }

        if (n == 0) {
            head = new Node<>(data);
        } else {
            int i = 0;
            Node<T> currNode = head;
            while (i < n - 1) {
                currNode = currNode.getNext();
                i++;
            }

            Node<T> newNode = new Node<>(data);
            newNode.setNext(currNode.getNext());
            currNode.setNext(newNode);
        }
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }

        if (head.getNext() == null) {
            this.head = null;
            return;
        }

        Node<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        current.setNext(null);
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }

        this.head = head.getNext();
    }

    /**
     * Count the number of nodes in the list
     *
     * @return a positive int value
     */
    public int size() {
        Node<T> currNode = head;
        int count = 0;
        // Walk through the list till you reach NULL.
        while (currNode != null) {
            currNode = currNode.getNext();
            count++;
        }
        return count;
    }

    /**
     * Small util to print
     */
    public void print() {
        System.out.println("LinkedList *****");
        if (head == null) {
            System.out.println("[]");
            System.out.println("LinkedList *****");
            return;
        }

        Node<T> current = head;
        do {
            System.out.println(current.getData());
            current = current.getNext();
        } while (current != null);

        System.out.println("LinkedList *****");
    }
}
