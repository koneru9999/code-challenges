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
 * called {@linkplain head}. <br/>
 *
 * @author Venkaiah Chowdary Koneru
 */
public class LinkedList<T> {

    /**
     * Initially, the head will be NULL. As we create and add nodes to the list,
     * the head will reference the first element in the list.
     */
    private LinkedListNode<T> head = null;

    public LinkedList() {
    }

    /**
     * Appends a new node with some data to the very end of the list.
     * This involves traversing the list to the very end and then adding a node.
     * Remember the newly added node should have the next set to NULL.
     *
     * @param data
     */
    public void addNode(T data) {
        if (head == null) {
            this.head = new LinkedListNode<>(data);
        } else {
            LinkedListNode<T> currNode = head;
            while (currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(new LinkedListNode<>(data));
        }
    }

    /**
     * Access and remove the first element form the list.
     *
     * @return returns the first element in the list
     */
    public T popElement() {
        if (head == null) {
            return null;
        }

        T firstElementData = head.getData();
        head = head.getNext();

        return firstElementData;
    }

    /**
     * Insert at the nth position in the list. Return if the number of nodes is
     * less than n.
     */
    public void insertNth(int n, T data) {
        if (countNodes() < n) {
            return;
        }

        if (n == 0) {
            LinkedListNode<T> currHead = head;
            head = new LinkedListNode<>(data);
            head.setNext(currHead);
        } else {
            int i = 0;
            LinkedListNode<T> currNode = head;
            while (i < n - 1) {
                currNode = currNode.getNext();
                i++;
            }

            LinkedListNode<T> next = currNode.getNext();
            currNode.setNext(new LinkedListNode<>(data));
            currNode.getNext().setNext(next);
        }
    }

    /**
     * Count the number of nodes in the list
     *
     * @return a positive int value
     */
    public int countNodes() {
        if (head == null) {
            // if head is NULL means no node exists in the list
            return 0;
        } else {
            LinkedListNode<T> currNode = head;
            int count = 0;
            // Walk through the list till you reach NULL.
            while (currNode != null) {
                currNode = currNode.getNext();
                count++;
            }
            return count;
        }
    }
}
