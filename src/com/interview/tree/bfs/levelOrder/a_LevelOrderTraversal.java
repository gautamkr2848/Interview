package com.interview.tree.bfs.levelOrder;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class a_LevelOrderTraversal {

    public void levelOrder(Node node){

        if(node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            Node data = queue.poll();
            System.out.print(data.key + " ");

            if(data.left != null)
                queue.offer(data.left);
            if(data.right != null)
                queue.offer(data.right);
        }
    }

    public void levelOrder_2(Node node) {
        int height = treeHeight(node);

        for(int i=1; i<=height; i++)
            printLevel(node, i);
    }

    private void printLevel(Node node, int level){
        if(node == null)
            return;

        if(level == 1)
            System.out.println(node.key);
        else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    private int treeHeight(Node node){
        if(node == null)
            return 0;

        return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
    }

    // Time complexity - O(n2)
}
