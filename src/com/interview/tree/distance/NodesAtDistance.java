package com.interview.tree.distance;

/*
                    20
         8                      22
    4         12
            10   14

    Parent Map
        20  =>  null
        8   =>  20
        22  =>  20
        4   =>  8
        12  =>  8
        10  =>  12
        14  =>  12


Given the root of a binary tree, the value of a target node , and an integer k, return an array of the values
of all nodes that have a distance k from the target node
*/

import com.interview.tree.Node;

import java.util.*;

public class NodesAtDistance {

    public void nodes(){
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left.right;

        Map<Node, Node> map = new HashMap<>();
        storeParent(root, map);
        nodeAtDistK(target, 2, map);
    }

    public void storeParent(Node root, Map<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            if (tmp.left != null) {
                map.put(tmp.left, tmp);
                q.add(tmp.left);
            }

            if (tmp.right != null) {
                map.put(tmp.right, tmp);
                q.add(tmp.right);
            }
        }
    }


    private void nodeAtDistK(Node target, int k, Map<Node, Node> map){
        Set<Node> s = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        s.add(target);

        int dist = 0;
        
        while (!q.isEmpty()) {
            if (dist == k) {
                while (!q.isEmpty()) {
                    System.out.print(q.poll().key + " ");
                }
                break;
            }
            
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node tmp = q.poll();
                
                if (tmp.left != null && !s.contains(tmp.left)) {
                    q.add(tmp.left);
                    s.add(tmp.left);
                }
                
                if (tmp.right != null && !s.contains(tmp.right)) {
                    q.add(tmp.right);
                    s.add(tmp.right);
                }
                
                if (map.get(tmp) != null && !s.contains(map.get(tmp))) {
                    q.add(map.get(tmp));
                    s.add(map.get(tmp));
                }
            }
            dist++;
        }
    }
}
