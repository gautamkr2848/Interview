package com.interview.tree.pathSum;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathSumPrint {

    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr = new ArrayList();
        //dfs(root, targetSum, ans, curr);
        findPaths(root, curr, ans);
        return ans;
    }

    private static void findPaths(Node root, List<Integer> curr, List<List<Integer>> ans) {
        if (root == null)
            return;

        curr.add(root.key);

        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        if(root.left!= null) {
            findPaths(root.left, curr, ans);
            curr.remove(curr.size() - 1);
        }

        if(root.right != null) {
            findPaths(root.right, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public static void dfs(Node root, int Sum, List<List<Integer>> ans, List<Integer> curr){
        if(root==null)
            return ;

        curr.add(root.key);
        if(root.left==null&&root.right==null) {
            if(Sum-root.key==0)
                ans.add(new ArrayList(curr)) ;
            return;
        }

        if(root.left!=null) {
            dfs(root.left,Sum-root.key,ans,curr);
            curr.remove(curr.size()-1);
        }

        if(root.right!=null) {
            dfs(root.right,Sum-root.key,ans,curr);
            curr.remove(curr.size()-1);
        }
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
