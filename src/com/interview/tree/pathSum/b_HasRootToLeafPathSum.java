package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class b_HasRootToLeafPathSum {

    public boolean hasPathSum(Node node, int sum) {
        if (node == null)
            return sum == 0;
        return hasPathSum(node.left, sum - node.key) ||
                hasPathSum(node.right, sum - node.key);
    }

    // DFS
    public boolean hasPathSum_2(Node root, int targetSum) {
        if (root == null) return false;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.key));

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            Node node = curr.node;
            int sum = curr.sum;

            // Check leaf
            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, sum + node.right.key));
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, sum + node.left.key));
            }
        }

        return false;
    }

    class Pair {
        Node node;
        int sum;

        Pair(Node node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    // BFS
    public boolean hasPathSum_3(Node root, int targetSum) {
        if (root == null) return false;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root.key));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int sum = curr.sum;

            if (node.left == null && node.right == null && sum == targetSum) {
                return true;
            }

            if (node.left != null)
                queue.add(new Pair(node.left, sum + node.left.key));

            if (node.right != null)
                queue.add(new Pair(node.right, sum + node.right.key));
        }

        return false;
    }
}
