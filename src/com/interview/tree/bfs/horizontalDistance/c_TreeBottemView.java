package com.interview.tree.bfs.horizontalDistance;

import java.util.*;

public class c_TreeBottemView {

    public void bottomView() {

        a_NodeView root = new a_NodeView(20);
        root.left = new a_NodeView(8);
        root.right = new a_NodeView(22);
        root.left.left = new a_NodeView(5);
        root.left.right = new a_NodeView(3);
        root.right.left = new a_NodeView(4);
        root.right.right = new a_NodeView(25);
        root.left.right.left = new a_NodeView(10);
        root.left.right.right = new a_NodeView(14);

        if (root == null)
            return;

        int hd = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<a_NodeView> queue = new LinkedList<>();

        // Assign initialized horizontal distance value to root node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()){
            a_NodeView temp = queue.poll();
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
