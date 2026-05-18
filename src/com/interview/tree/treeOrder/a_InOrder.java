package com.interview.tree.treeOrder;

import com.interview.tree.Node;

import java.util.Stack;

/*
                1
        2               3           => 4 2 5 1 6 3
    4       5       6
*/

public class a_InOrder {

    public void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    // O(n) time complexity

    public void inOrder2(Node node){
        if (node == null)
            return;

        Stack<Node> s = new Stack<>();
        Node curr = node;

        while (curr != null || s.size() > 0){
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
}
    // O(n) time complexity
