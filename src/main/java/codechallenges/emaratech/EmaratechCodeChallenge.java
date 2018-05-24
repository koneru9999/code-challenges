/*
 * Copyright © 2017, Emaratech, All Rights Reserved
 * 
 * EmaratechCodeChallenge.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jun 27, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.emaratech;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * <b>Problem Statement:</b><br>
 * You will have a triangle (which is a binary tree) input below and you need to find the maximum sum of the numbers per
 * the given rules below:<br>
 * <p>
 * <ol>
 * <li>You will start from the top and move downwards to an adjacent number as in below.</li>
 * <li>You are only allowed to walk downwards and diagonally.</li>
 * <li>You should walk over the numbers as evens and odds subsequently. Suppose that you are on an even number
 * the next number you walk must be odd, or if you are stepping over an odd number the next number must be
 * even. In other words, the final path would be like <em>odd -> even -> odd -> even ...</em></li>
 * <li>You must reach to the bottom of the pyramid.</li>
 * </ol>
 * </p>
 * <p>
 * <b>triangle to find max sum:</b><br>
 * 215<br>
 * 192 124<br>
 * 117 269 442<br>
 * 218 836 347 235<br>
 * 320 805 522 417 345<br>
 * 229 601 728 835 133 124<br>
 * 248 202 277 433 207 263 257<br>
 * 359 464 504 528 516 716 871 182<br>
 * 461 441 426 656 863 560 380 171 923<br>
 * 381 348 573 533 448 632 387 176 975 449<br>
 * 223 711 445 645 245 543 931 532 937 541 444<br>
 * 330 131 333 928 376 733 017 778 839 168 197 197<br>
 * 131 171 522 137 217 224 291 413 528 520 227 229 928<br>
 * 223 626 034 683 839 052 627 310 713 999 629 817 410 121<br>
 * 924 622 911 233 325 139 721 218 253 223 107 233 230 124 233<br>
 * </p>
 * <p>
 * <b>The implementation can be summarized as follows</b>
 * <ol>
 * <li>reads the "triangle.txt" file</li>
 * <li>prepares the double dimensional array of TreeNode with descendant information</li>
 * <li>bruteforce approach to traverse through from root TreeNode until bottom to find the maximum sum based on above conditions</li>
 * </ol>
 * </p>
 *
 * @author Venkaiah Chowdary Koneru
 */
public class EmaratechCodeChallenge {
    private static int maximumSumResult = 0;

    /**
     * prints the result of max sum
     *
     * @param rootNode root node
     */
    private static void findMaxSum(TreeNode rootNode) {
        maxSumRecursive(rootNode, 0, 0);
        System.out.println("Maximum Sum Result :" + maximumSumResult);
    }

    /**
     * recursive method to traverse based on the even odd condition
     *
     * @param nodeObj
     * @param index
     * @param sum
     */
    private static void maxSumRecursive(TreeNode nodeObj, int index, int sum) {
        if (nodeObj == null) {
            return;
        }

        index++;
        sum += nodeObj.getData();

        /*
        if the both the child nodes of the current
        node are null means we reached bottom of the triangle
        */
        if (nodeObj.getLeft() == null && nodeObj.getRight() == null) {
            System.out.println("reached end : " + nodeObj.getData() + ". Will check for current highest sum");
            if (sum > maximumSumResult) {
                maximumSumResult = sum;
            }
            return;
        }

        /*
        walk over the numbers as evens and odds subsequently. Suppose that you are on an even number
        the next number you walk must be odd, or if you are stepping over an odd number the next number must be
        even.
        */
        // Checking for current data and left child for even or odd. walk over only if they are different
        if ((nodeObj.getData() % 2 == 0 && nodeObj.getLeft().getData() % 2 != 0)
                || (nodeObj.getData() % 2 != 0 && nodeObj.getLeft().getData() % 2 == 0)) {
            System.out.println("going to left from : " + nodeObj.getData() + " at level " + index);
            maxSumRecursive(nodeObj.getLeft(), index, sum);
        }

        // Checking for current data and right child for even or odd. walk over only if they are different
        if ((nodeObj.getData() % 2 == 0 && nodeObj.getRight().getData() % 2 != 0)
                || (nodeObj.getData() % 2 != 0 && nodeObj.getRight().getData() % 2 == 0)) {
            System.out.println("going to right from : " + nodeObj.getData() + " at level " + index);
            maxSumRecursive(nodeObj.getRight(), index, sum);
        }
    }

    /**
     * Main method
     *
     * @param args - not relevant here
     */
    public static void main(String[] args) {
        // Load the file from classpath and stream each line
        Stream<String> stream = new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream("triangle.txt")))
                .lines();

        TreeNode[][] nodes = stream
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray()) // map every line to int[] by splitting against space
                .map(intArr -> stream(intArr)
                        .mapToObj(TreeNode::new)
                        .toArray(TreeNode[]::new)) // map every int[] as TreeNode[]
                .toArray(TreeNode[][]::new);

        // Traverse through the each node to assign descendants information.
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (i < nodes.length - 1) { // Skip for last line
                    nodes[i][j].setLeft(nodes[i + 1][j > 0 ? j : 0]);
                    nodes[i][j].setRight(nodes[i + 1][j + 1]);
                }
            }
        }

        // the following enhanced for loop(s) can be ignored.
        // Printing just for the sake of validation of file reading
        for (TreeNode[] node : nodes) {
            for (TreeNode aNode : node) {
                System.out.print(aNode.getData() + " ");
            }
            System.out.print("\n");
        }

        EmaratechCodeChallenge.findMaxSum(nodes[0][0]);
    }
}
