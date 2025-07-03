package com.interview.tree;

public class DeleteLeafNodes {

    public Node deleteLeaves(Node root) {
        // If null, return null
        if (root == null) return null;

        // Recurse on left and right
        root.left = deleteLeaves(root.left);
        root.right = deleteLeaves(root.right);

        // If current node is now a leaf, delete it
        if (root.left == null && root.right == null) {
            return null;
        }

        return root;
    }
}
