package com.interview.tree.dfs;

import com.interview.tree.Node;

/**
 * Finds the maximum path sum in a binary tree.
 * A path can start and end at any nodes in the tree.
 **/

public class BSTMaxPathSum {

    private static int maxSum = -1001;

    public static int maxPathSum(Node root) {
        calculateMaxGain(root);
        return maxSum;
    }

    private static int calculateMaxGain(Node node) {
        if (node == null)
            return 0;

        int leftGain = Math.max(0, calculateMaxGain(node.left));    // Use Math.max with 0 to ignore negative paths
        int rightGain = Math.max(0, calculateMaxGain(node.right));  // Use Math.max with 0 to ignore negative paths

        maxSum = Math.max(maxSum, node.key + leftGain + rightGain);

        // If path sum is needed for leaf to leaf
//        if (node.left != null && node.right != null) {
//            maxSum = Math.max(maxSum, node.key + leftGain + rightGain);
//        }

        // Return the maximum gain from this node to its parent
        // Parent can only use one branch (either left or right) plus the current node's value
        return node.key + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        System.out.println(maxPathSum(node)); // 1
    }
}
