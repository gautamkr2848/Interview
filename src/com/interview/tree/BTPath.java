package com.interview.tree;

import java.util.ArrayList;
import java.util.List;

/*
                                1
                  2                             3
           4            5               6               7
                      8   9          10    11
*/

public class BTPath {

    public boolean searchNode(Node node, int n){
        if (node == null)
            return false;

        if(node.key == n)
            return true;

        if(searchNode(node.left, n))
            return true;

        if(searchNode(node.right, n))
            return true;

        return false;
    }

    public List<Integer> nodeToRootPath(Node node, int data) {
        if (node == null)
            return new ArrayList<>();

        if (node.key == data) {
            List<Integer> list = new ArrayList<>();
            list.add(node.key);
            return list;
        }

        List<Integer> llist = nodeToRootPath(node.left, data);
        if (llist.size() > 0) {
            llist.add(node.key);
            return llist;
        }

        List<Integer> rlist = nodeToRootPath(node.right, data);
        if (rlist.size() > 0) {
            rlist.add(node.key);
            return rlist;
        }
        return new ArrayList<>();
    }

    public List<Integer> nodeToLeafPath(Node node) {
        if (node == null)
            return new ArrayList<>();

        if (node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(node.key);
            return list;
        }

        List<Integer> llist = nodeToLeafPath(node.left);
        if (llist.size() > 0) {
            llist.add(node.key);
            return llist;
        }

        List<Integer> rlist = nodeToLeafPath(node.right);
        if (rlist.size() > 0) {
            rlist.add(node.key);
            return rlist;
        }
        return new ArrayList<>();
    }

}
