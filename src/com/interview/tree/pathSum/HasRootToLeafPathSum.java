package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.Stack;

public class HasRootToLeafPathSum {

    public boolean hasPathSum(Node node, int sum) {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.key) ||
                hasPathSum(node.right, sum - node.key);
    }

    boolean hasPathSum_2(Node root, int sum) {

        if (root == null)
            return false;

        // Create 2 stacks for the path and the sums
        Stack<Node> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.key);

        while (!path.isEmpty()) {
            Node temp = path.pop();
            int tempVal = sumPath.pop();

            // If a child node and we find the sum total, return true
            if (temp.left == null && temp.right == null && tempVal == sum)
                return true;

            if (temp.right != null) {
                path.push(temp.right);
                sumPath.push(temp.right.key + tempVal);
            }

            if (temp.left != null) {
                path.push(temp.left);
                sumPath.push(temp.left.key + tempVal);
            }

        }

        return false;
    }
}
