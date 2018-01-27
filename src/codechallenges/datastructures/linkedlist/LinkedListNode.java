/*
 * Copyright © 2018, All Rights Reserved
 *
 * Element.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jan 27, 2018		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.datastructures.linkedlist;

/**
 * Linked list element to hold data and next.<br/>
 * Each element references to the next element in the chain - the last element points to NULL.
 *
 * @author Venkaiah Chowdary Koneru
 */
public class LinkedListNode<T> {
    /**
     * information held in each element
     */
    private final T data;

    /**
     * reference to the next element in the list
     */
    private LinkedListNode<T> next;

    /**
     * this takes in the data associated with this node.
     * Initially, the next reference is set to NULL.
     *
     * @param data
     */
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
