package codechallenges.test.datastructres.tree;

import codechallenges.datastructures.TreeNode;
import codechallenges.datastructures.tree.BinaryTree;

public class BinaryTreeTest {

    public static void printZinZagTest() {
        TreeNode<Integer> rootNode = new TreeNode<>(1);
        rootNode.setLeft(new TreeNode<>(2));
        rootNode.setRight(new TreeNode<>(3));

        rootNode.getLeft().setLeft(new TreeNode<>(7));
        rootNode.getLeft().setRight(new TreeNode<>(6));

        rootNode.getRight().setLeft(new TreeNode<>(5));
        rootNode.getRight().setRight(new TreeNode<>(4));

        BinaryTree<Integer> tree = new BinaryTree<>(rootNode);
        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZag();
    }

    public static void main(String[] args) {
        printZinZagTest();
    }
}
