package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.*;

public class a_RootToLeafPath {

    public static List<List<Integer>> Paths(Node root){

        List<Node> leafs = new ArrayList<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(root, null);
        storeParent(root, map, leafs);

        return findPaths(map, leafs);

    }

    private static void storeParent(Node root, Map<Node, Node> map, List<Node> leafs){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.left == null && tmp.right == null)
                leafs.add(tmp);

            if(tmp.left != null) {
                map.put(tmp.left, tmp);
                q.add(tmp.left);
            }

            if(tmp.right != null) {
                map.put(tmp.right, tmp);
                q.add(tmp.right);
            }
        }
    }

    private static List<List<Integer>> findPaths(Map<Node, Node> map, List<Node> leafs){
        List<List<Integer>> paths = new ArrayList<>();
        for(Node node : leafs){
            List<Integer> path = new ArrayList<>();
            path.add(node.key);
            while(map.get(node) != null){
                path.add(map.get(node).key);
                node = map.get(node);
            }
            Collections.reverse(path);
            paths.add(path);
        }
        return paths;
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.right = new Node(4);

        node.right = new Node(7);
        node.right.left = new Node(6);

        List<List<Integer>> ans = new ArrayList<>();
        findPaths(node, new ArrayList<>(), ans);

        for(List<Integer> l : ans){
            System.out.println(l.toString());
        }
    }

    // If the node is null, we return an empty list.
    // If the node is a leaf node, we return a list containing the path from the node to the root.
    // Otherwise, we recursively call the helper function on the left and right children of the node, and concatenate the results.

    // with add + remove (backtracking)
    public static void findPaths(Node root, List<Integer> curr, List<List<Integer>> ans) {
        if (root == null)
            return;

        curr.add(root.key);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(curr));
        } else {
            findPaths(root.left, curr, ans);
            findPaths(root.right, curr, ans);
        }
        curr.remove(curr.size() - 1);
    }

    // Time complexity - O(n)
}
