/*
 * Copyright © 2017,  All Rights Reserved
 * 
 * MaxPathSum.java
 * Modification History
 * *************************************************************
 * Date				Author		Comment
 * Jun 27, 2017		Venkaiah Chowdary Koneru		Created
 * *************************************************************
 */
package codechallenges.emaratech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

/**
 * @author Venkaiah Chowdary Koneru
 */
public class MaxPathSum {

    private static int maxSum = 0;
    private static int[] arr;

    public static void maxSumPath(Node root, int[] path) {
        maxSum = Integer.MIN_VALUE;
        maxSumPathRoot2Leaf(root, path, 0, 0);
        System.out.println("Maximum Sum :" + maxSum);
        System.out.println("Root to Leaf Path: " + Arrays.toString(arr));
    }

    public static void maxSumPathRoot2Leaf(Node root, int[] path, int index, int sum) {
        if (null == root) {
            return;
        }
        path[index++] = root.data;
        sum += root.data;
        if (root.left == null && root.right == null) {
            System.out.println("inside null : " + root.data + ". index =" + index);
            if (sum > maxSum) {
                maxSum = sum;
                arr = Arrays.copyOf(path, index);
            }
            System.out.println(Arrays.toString(arr) + " : " + maxSum);
            return;
        }

        if ((root.data % 2 == 0 && root.left.data % 2 != 0) || (root.data % 2 != 0 && root.left.data % 2 == 0)) {
            System.out.println("going to left from : " + root.data);
            maxSumPathRoot2Leaf(root.left, path, index, sum);
        }

        if ((root.data % 2 == 0 && root.right.data % 2 != 0) || (root.data % 2 != 0 && root.right.data % 2 == 0)) {
            System.out.println("going to right from : " + root.data);
            maxSumPathRoot2Leaf(root.right, path, index, sum);
        }
    }

    public static void main(String[] args) throws IOException {

        Stream<String> stream = new BufferedReader(
                new InputStreamReader(ClassLoader.getSystemResourceAsStream("triangle.txt")))
                .lines();

        Node[][] nodes = stream
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .map(intArr -> stream(intArr).mapToObj(Node::createNode).toArray(Node[]::new))
                .toArray(Node[][]::new);

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                if (i < nodes.length - 1) {
                    nodes[i][j].left = nodes[i + 1][j > 0 ? j : 0];
                    nodes[i][j].right = nodes[i + 1][j + 1];
                }
            }
        }

        for (int k = 0; k < nodes.length; k++) {
            for (int l = 0; l < nodes[k].length; l++) {
                System.out.print(nodes[k][l].data);
                if (k < nodes.length - 1) {
                    System.out.print(" (" + nodes[k][l].left.data + "," + nodes[k][l].right.data + ")");
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        int[] path = new int[512];
        MaxPathSum.maxSumPath(nodes[0][0], path);
    }
}
