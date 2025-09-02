package com.interview.tree.horizontalDistance;

import com.interview.tree.Node;

import java.util.*;

public class f_treeBoundary {

    public void printBoundary(Node root) {
        if (root == null)
            return;

        if ((root.left == null) && (root.right == null)) {
            System.out.print(root.key);
            return;
        }

        List<Node> list = new ArrayList<>();
        list.add(root);

        Node L = root.left;
        while (L.left != null) {
            list.add(L);
            L = L.left;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if ((temp.left == null) && (temp.right == null))
                list.add(temp);

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        List<Node> list_r = new ArrayList<>();
        Node R = root.right;
        while (R.right != null) {
            list_r.add(R);
            R = R.right;
        }

        Collections.reverse(list_r);
        list.addAll(list_r);

        for (Node i : list)
            System.out.print(i.key + " ");

    }

    public static void treeBoundary2(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return;
        }

        List<Node> boundaryElements = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node current = q.poll();

                if (i == 0 || i == size-1 || (current.left == null && current.right == null)) {
                    boundaryElements.add(current);
                }

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }

        boundaryElements.stream().forEach(x -> System.out.print(x.key + " "));
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.left.right.left = new Node(8);

        f_treeBoundary.treeBoundary2(node);
    }
}

//    1
//  2   3
//4   56 7