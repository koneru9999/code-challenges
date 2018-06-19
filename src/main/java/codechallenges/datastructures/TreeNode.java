package codechallenges.datastructures;

/**
 * A binary tree node
 * @param <T>
 */
public class TreeNode<T> {
    /**
     * information held in each element
     */
    private final T data;

    /**
     * reference to the left element
     */
    private TreeNode<T> left;

    /**
     * reference to the right element
     */
    private TreeNode<T> right;

    /**
     * this takes in the data associated with this node.
     * Initially, the left and right reference is set to NULL.
     *
     * @param data
     */
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
}
