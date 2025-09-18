package com.interview.tree;

public class DeleteLeafNodes {

    public static Node deleteLeaves(Node root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = deleteLeaves(root.left);
        root.right = deleteLeaves(root.right);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        printInOrder(root);

        root = deleteLeaves(root);
        System.out.println();
        printInOrder(root);
    }

    public static void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.key + " ");
        printInOrder(root.right);
    }
}
