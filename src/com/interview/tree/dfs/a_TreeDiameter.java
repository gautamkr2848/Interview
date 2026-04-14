package com.interview.tree.dfs;

/*

The diameter of a tree is defined as the number of edges in the longest path between any two nodes.

              1
             / \
            2   3
           / \
          4   5
         /
        6
*/

import com.interview.tree.Node;

public class a_TreeDiameter {

    private static int diameter = 0;

    public static int diameterOfBinaryTree(Node root) {
        processHeight(root);
        return diameter;
    }

    private static int processHeight(Node node) {      // Height function that also updates diameter
        if (node == null) return 0;

        int left = processHeight(node.left);
        int right = processHeight(node.right);

        diameter = Math.max(diameter, left + right);    // Update diameter at this node

        return 1 + Math.max(left, right);       // Return height
    }

    // Time Complexity - O(n)

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println("Diameter: " + diameterOfBinaryTree(root)); // Output: 4
        System.out.println("Diameter: " + diameter(root)); // Output: 4
    }

    // Function to get diameter of a binary tree
    static int diameter(Node root) {
        if (root == null)
            return 0;

        // Get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);

        // Get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight, Math.max(ldiameter, rdiameter));
    }

    static int height(Node root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Time Complexity - O(n2)

}
