package com.interview.tree.LCA;

import com.interview.tree.Node;

public class LCAForBST {

    public void lCAForBST(Node root, int n1, int n2){
        while (root != null) {
            if (root.key > n1 && root.key > n2)
                root = root.left;
            else if (root.key < n1 && root.key < n2)
                root = root.right;
            else break;
        }
        System.out.println(root);
    }
}

