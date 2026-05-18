package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

// Print every path in the tree with sum of the nodes in the path as k.
// A path can start from any node and end at any node and must be downward only

/*
                    1
            2               3
        4       5       6
    7      8

    sum = 13
    path = 1    2   4   7
    currSum = 7, count = 0
    currSum = 11, count = 0
    currSum = 13, count = 1

    path = 1    2   4   8
    currSum = 14, count = 1

    path = 1    2   4
    currSum = 7, count = 1

    path = 1    2   5
 */

public class TreePathSumK {

    static List<Integer> path = new ArrayList<>();
    static int count = 0;

    public static void pathCount(Node root, int k) {
        if (root == null)
            return;

        path.add(root.key);

        pathCount(root.left, k);
        pathCount(root.right, k);

        int currSum = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            currSum += path.get(j);

            if (currSum == k) {
                count++;
                for (int i=j; i<path.size(); i++){
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }
        }
        path.remove(path.size() - 1);       // Remove the current element from the path
    }

    public static void main(String[] args) {
        Node node = new Node(6);
        node.left = new Node(4);
        node.left.left = new Node(3);
        node.left.right = new Node(5);

        node.right = new Node(8);
        node.right.left = new Node(7);
        node.right.right = new Node(9);

        pathCount(node, 15);
    }
}