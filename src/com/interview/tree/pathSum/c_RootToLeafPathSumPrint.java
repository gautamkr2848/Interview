package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class c_RootToLeafPathSumPrint {

    public static List<List<Integer>> pathSum(Node node, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(node, sum, ans, new ArrayList<>());
        return ans;
    }


    public static void dfs(Node root, int sum, List<List<Integer>> ans, List<Integer> curr){
        if(root == null)
            return;

        curr.add(root.key);

        if(root.left == null && root.right == null && sum == root.key) {
            ans.add(new ArrayList<>(curr));
        } else {
            dfs(root.left, sum - root.key, ans, curr);
            dfs(root.right, sum - root.key, ans, curr);
        }

        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(4);
        node.right = new Node(8);
        node.left.left = new Node(11);
        node.left.left.left = new Node(7);
        node.left.left.right = new Node(2);

        node.right.left = new Node(13);
        node.right.right = new Node(4);
        node.right.right.left = new Node(5);
        node.right.right.right = new Node(1);

        System.out.println(pathSum(node, 22).toString());
    }
}
