/*
 * Copyright © 2017, Emaratech, All Rights Reserved
 * 
 * TreeNode.java
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
public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    /**
     *
     * @param num
     */
    public TreeNode(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @return
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public int getData() {
        return data;
    }
}
