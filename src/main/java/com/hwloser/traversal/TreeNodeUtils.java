package com.hwloser.traversal;

import java.util.Random;

public class TreeNodeUtils {
    private final static Random r = new Random();
    public static TreeNode<Integer> mockIntegerTree() {
        int[] arr = {1, 7, 33, 4234, 44, 234, 6, 77, 123, 3, 4224, 423};
        return genBinaryTree(arr, 0);
    }

    private static TreeNode<Integer> genBinaryTree(int[] arr, int index) {
        TreeNode<Integer> subTreeRoot = null;
        while (index < arr.length) {
            subTreeRoot = new TreeNode<>(arr[index]);
            subTreeRoot.setRight(genBinaryTree(arr, (index * 2) + 1));
            subTreeRoot.setLeft(genBinaryTree(arr, (index * 2) + 2));
        }
        return subTreeRoot;
    }
}
