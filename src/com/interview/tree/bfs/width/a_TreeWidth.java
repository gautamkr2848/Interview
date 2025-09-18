package com.interview.tree.bfs.width;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class a_TreeWidth {

    public void treeWidth(Node node){       //same as max sum at level
        int width = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int count = q.size();
            width = Math.max(width, count);

            while (count-- > 0){
                Node temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        System.out.println(width);
    }
}
