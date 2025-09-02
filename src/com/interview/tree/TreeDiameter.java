package com.interview.tree;

/*
              1
             / \
            2   3
           / \
          4   5
         /
        6
*/

public class TreeDiameter {

    private static int diameter = 0;

    public static int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter;
    }

    private static int height(Node node) {      // Height function that also updates diameter
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

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
