package com.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ListToBinaryTree {

    public com.interview.list.Node convertBinaryTreeToList(Node root) {
        if (root == null)
            return null;

        com.interview.list.Node head = null, tail = null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            com.interview.list.Node newNode = new com.interview.list.Node(tmp.key);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        return head;
    }

    private Node convertListToBinaryTreeUtil(com.interview.list.Node head) {
        if (head == null)
            return null;

        Queue<Node> q = new ArrayDeque<>();
        Node root = new Node(head.data);
        q.add(root);
        head = head.next;

        while (head != null) {
            Node parent = q.poll();

            Node leftChild = null, rightChild = null;
            if (head != null) {
                leftChild = new Node(head.data);
                parent.left = leftChild;
                q.add(leftChild);
                head = head.next;
            }

            if (head != null) {
                rightChild = new Node(head.data);
                parent.right = rightChild;
                q.add(rightChild);
                head = head.next;
            }
        }
        return root;
    }
}
