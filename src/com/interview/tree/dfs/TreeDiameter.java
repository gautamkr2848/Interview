package com.interview.tree.dfs;

/*
              1
             / \
            2   3
           / \
          4   5
         /
        6
*/

import com.interview.tree.Node;

public class TreeDiameter {

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

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println("Diameter: " + diameterOfBinaryTree(root)); // Output: 4
    }

}
