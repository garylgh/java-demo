package com.ghlin.algorithm.DataStructure;

import java.util.Stack;

public class BST<T extends Comparable<T>> {
    private static class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> root;

    public BST() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    // 前序遍历
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void add(T data) {

    }

    public int size() {
        if (root == null)
            return 0;
//        size()
//        Stack
        return 0;
    }

    public void clear() {
        root = null;
    }
}
