package com.interview.tree.treeOrder;

import com.interview.tree.Node;

import java.util.Stack;

/*
                1
        2               3           => 1 2 4 5 3 6
    4       5       6
*/

public class b_PreOrder {

    public void preorder(Node node){
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void preOrder2(Node root){
        if (root == null)
            return;

        Stack<Node> stk = new Stack<>();
        stk.push(root);

        while (!stk.empty()) {
            Node node = stk.pop();
            System.out.print(node.key + " ");

            if (node.right != null)
                stk.push(node.right);

            if (node.left != null)
                stk.push(node.left);
        }
    }

}
