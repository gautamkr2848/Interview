package com.interview.tree.bfs.horizontalDistance;

public class a_NodeView {

    int data; //data of the node
    int hd; //horizontal distance of the node
    a_NodeView left, right; //left and right references

    public a_NodeView(int key){
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
