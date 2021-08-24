package com.hwloser.traversal;

import java.util.Stack;

/**
 * 先序遍历
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeNodeUtils.mockIntegerTree();

        recursiveTraverse(root);
//        preorderTraversal(root);
    }

    private static void recursiveTraverse(TreeNode<Integer> treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.getValue());
            recursiveTraverse(treeNode.getLeft());
            recursiveTraverse(treeNode.getRight());
        }
    }
    private static void preorderTraversal(TreeNode<Integer> treeNode) {
        if (treeNode == null) return;

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cursor = treeNode;

        while (cursor != null | !stack.isEmpty()) {
            while (cursor != null) {
                System.out.println(cursor.getValue());

                stack.push(cursor);
                cursor = cursor.getLeft();
            }

            if (!stack.isEmpty()) {
                cursor = stack.pop().getRight();
            }
        }
    }
}
