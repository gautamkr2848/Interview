package com.interview.tree.width;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class c_MaxSumAtLevel {

    public void maxSum(){

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);
        
        if(node == null)
            System.out.println(0);

        int max = node.key;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int count = q.size();
            int sum = 0;

            while (count-- > 0) {
                Node temp = q.poll();
                sum = sum + temp.key;

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }

    public void averageAtLevel(){

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(8);
        node.right.right.left = new Node(6);
        node.right.right.right = new Node(7);

        if(node == null)
            System.out.println(0);

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()){
            int startingCount = q.size();
            int count = q.size();
            int sum = 0;

            while (count-- > 0) {
                Node temp = q.poll();
                sum = sum + temp.key;

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            System.out.println((float) sum/startingCount);
        }

    }

    public static void main(String[] args) {
        c_MaxSumAtLevel obj = new c_MaxSumAtLevel();
        obj.maxSum();
        obj.averageAtLevel();
    }
}
