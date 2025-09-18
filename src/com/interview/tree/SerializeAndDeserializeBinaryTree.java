package com.interview.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(Node root) {
        if (root == null)
            return null;

        List<String> l = new ArrayList<>();

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node t = s.pop();

            if (t == null)
                l.add("#");
            else {
                l.add("" + t.key);
                s.push(t.right);
                s.push(t.left);
            }
        }
        return String.join(",", l);
    }

    static int t = 0;
    public Node deserialize(String data) {
        if (data == null)
            return null;
        String[] arr = data.split(",");
        return helper(arr);
    }

    public Node helper(String[] arr) {
        if (arr[t].equals("#"))
            return null;

        Node root = new Node(Integer.parseInt(arr[t]));
        t++;
        root.left = helper(arr);
        t++;
        root.right = helper(arr);
        return root;
    }
}
