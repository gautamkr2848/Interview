package com.interview.tree.horizontalDistance;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class g_rightView {

    public void rightView(Node root){

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int n = q.size();

            for(int i=0; i<n; i++){
                Node temp = q.poll();

                if (i == n-1)
                    System.out.print(temp.key);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }
}

// Time Complexity: O(n), where n is the number of nodes in the binary tree.
// Auxiliary Space: O(n)