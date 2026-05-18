package com.interview.tree.bfs.width;

import java.util.LinkedList;
import java.util.Queue;

public class e_ConnectNodeAtSameLevel {

    public void connect(NodeNext root){
        Queue<NodeNext> q = new LinkedList<>();
        q.add(root);
        NodeNext temp = null;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                NodeNext prev = temp;
                temp = q.poll();

                if (i > 0)
                    prev.next = temp;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            temp.next = null;
        }
    }
}

class NodeNext {
    int data;
    NodeNext left, right, next;

    public NodeNext(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
