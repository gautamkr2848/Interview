package com.interview.tree.horizontalDistance;

import java.util.*;

class NodeBottomView {
    int data; //data of the node
    int hd; //horizontal distance of the node
    NodeBottomView left, right; //left and right references

    public NodeBottomView(int key){
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class TreeBottemView {

    public void bottomView() {

        NodeBottomView root = new NodeBottomView(20);
        root.left = new NodeBottomView(8);
        root.right = new NodeBottomView(22);
        root.left.left = new NodeBottomView(5);
        root.left.right = new NodeBottomView(3);
        root.right.left = new NodeBottomView(4);
        root.right.right = new NodeBottomView(25);
        root.left.right.left = new NodeBottomView(10);
        root.left.right.right = new NodeBottomView(14);

        if (root == null)
            return;

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<NodeBottomView> queue = new LinkedList<>();

        // Assign initialized horizontal distance value to root node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()){
            NodeBottomView temp = queue.remove();
            hd = temp.hd;
            map.put(hd, temp.data);

            // If the dequeued node has a left child, add it to the queue with a horizontal distance hd-1.
            if (temp.left != null){
                temp.left.hd = hd-1;
                queue.add(temp.left);
            }
            // If the dequeued node has a right child, add it to the queue with a horizontal distance hd+1.
            if (temp.right != null){
                temp.right.hd = hd+1;
                queue.add(temp.right);
            }
        }

        // Traverse the map elements and print values
        for(Integer i : map.values()){
            System.out.print(i+" ");
        }
    }
}
