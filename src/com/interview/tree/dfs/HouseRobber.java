package com.interview.tree.dfs;

import com.interview.tree.Node;

public class HouseRobber {

    public int rob(Node root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * @return Array where [0] = max money if current node is robbed,
     *                     [1] = max money if current node is not robbed
     */
    private int[] dfs(Node root) {
        if (root == null) {
            return new int[2];
        }

        // Recursively calculate optimal values for left and right subtrees
        int[] leftSubtree = dfs(root.left);
        int[] rightSubtree = dfs(root.right);

        // robCurrent: If we rob current node, we cannot rob its children
        int robCurrent = root.key + leftSubtree[1] + rightSubtree[1];

        // skipCurrent: If we skip current node, we can choose the max from each child
        int skipCurrent = Math.max(leftSubtree[0], leftSubtree[1]) +
                Math.max(rightSubtree[0], rightSubtree[1]);

        return new int[] {robCurrent, skipCurrent};
    }
}
