package com.interview.tree.bfs.levelOrder;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
                1
        2               3           => 4 5 6 2 3 1
    4       5       6
*/

//Paytm

public class b_LevelOrderReverse {

    public void levelOrderReverse(Node node){
        Stack<Node> stk = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        while(queue.size() > 0) {
            Node temp = queue.poll();
            stk.push(temp);

            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
        }

        while (!stk.empty()){
            Node data = stk.pop();
            System.out.print(data.key+" ");
        }
    }
}
