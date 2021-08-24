package com.hwloser.traversal;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T value){
        this.value = value;
        left = null;
        right = null;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }
    public TreeNode<T> getLeft() {
        return left;
    }
    public TreeNode<T> getRight() {
        return right;
    }
}
