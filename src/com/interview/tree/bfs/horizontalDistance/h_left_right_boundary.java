package com.interview.tree.bfs.horizontalDistance;

import java.util.LinkedList;
import java.util.Queue;

public class h_left_right_boundary {

    public static void main(String[] args) {
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

        Queue<a_NodeView> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                a_NodeView node = queue.poll();
                if(i==0 || i==size-1)
                    System.out.println(node.data);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
        }
    }
}
