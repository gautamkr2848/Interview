package com.interview.tree;

public class IsBST {

    public void isBST(Node root){
        System.out.println(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    boolean isBSTUtil(Node node, int min, int max){
        if (node == null)
            return true;

        if (node.key < min || node.key > max)
            return false;

        return (isBSTUtil(node.left, min, node.key-1) &&
                isBSTUtil(node.right, node.key+1, max));
    }

}