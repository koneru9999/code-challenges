/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * Node.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jun 27, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.emaratech;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    public static Node createNode(int number) {
        return new Node(number);
    }
}
