package com.interview.tree.bfs.levelOrder;

import com.interview.tree.Node;

import java.util.Stack;

public class c_LevelOrderSpiral {

    public void levelOrderSpiral(Node node){

        if(node == null)
            return;

        Stack<Node> stk1 = new Stack<>();
        Stack<Node> stk2 = new Stack<>();

        stk1.push(node);
        while (!stk1.empty() || !stk2.empty()){
            while (!stk1.empty()){
                Node temp = stk1.pop();
                System.out.println(temp.key);

                if(temp.right != null)
                    stk2.push(temp.right);
                if(temp.left != null)
                    stk2.push(temp.left);
            }

            while (!stk2.empty()){
                Node temp = stk2.pop();
                System.out.println(temp.key);

                if(temp.left != null)
                    stk1.push(temp.left);
                if(temp.right != null)
                    stk1.push(temp.right);
            }
        }
    }

    public void levelOrderSpiral_2(Node node){
        Boolean flag = true;
        int height = height(node);
        for(int i=1; i<=height; i++){
            printLevel(node, i, flag);
            flag = !flag;
        }
    }

    void printLevel(Node node, int level, Boolean flag){
        if(node == null)
            return;

        if(level == 1)
            System.out.println(node.key);
        else if(level > 1){
            if(flag){
                printLevel(node.left, level - 1, flag);
                printLevel(node.right, level - 1, flag);
            } else {
                printLevel(node.right, level - 1, flag);
                printLevel(node.left, level - 1, flag);
            }
        }

    }

    int height(Node node){
        if (node == null)
            return 0;
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
