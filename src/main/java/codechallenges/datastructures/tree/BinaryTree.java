package codechallenges.datastructures.tree;

import codechallenges.datastructures.TreeNode;

import java.util.Stack;

public class BinaryTree<T> {
    private final TreeNode<T> root;

    public BinaryTree(TreeNode<T> node) {
        this.root = node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void printZigZag() {
        if (root == null) {
            return;
        }

        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(root);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            TreeNode<T> current = currentLevel.pop();
            System.out.println("" + current.getData());
            if (leftToRight) {
                if (current.getLeft() != null) {
                    nextLevel.push(current.getLeft());
                }

                if (current.getRight() != null) {
                    nextLevel.push(current.getRight());
                }
            } else {
                if (current.getRight() != null) {
                    nextLevel.push(current.getRight());
                }

                if (current.getLeft() != null) {
                    nextLevel.push(current.getLeft());
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}
