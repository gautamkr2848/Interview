package com.interview.tree.bfs.width;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class d_kDistaceFromRoot {

    public void Kdistance_2(){

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);

        if(node == null)
            System.out.println(-1);

        int k = 3;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int count = q.size();

            while (count-- > 0 && k >= 0) {
                Node temp = q.poll();
                if(k == 0)
                    System.out.print(temp.key + " ");

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            k--;
        }
    }
}
