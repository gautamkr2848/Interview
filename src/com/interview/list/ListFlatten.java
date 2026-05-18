package com.interview.list;

/*
5 -> 10 -> 19 -> 28
|    |     |     |
7    20    22    35
|          |     |         ==>  5 -> 7 -> 8 -> 10 -> 19 -> 20 -> 22 -> 28 -> 30 -> 35 -> 40 -> 45 -> 50
8          50    40
|                |
30               45
*/

public class ListFlatten {

    class Node{
        int data;
        Node next, down;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.down = null;
        }
    }

    static Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        return merge(root, flatten(root.next));
    }

    // An utility function to merge two sorted linked lists
    private static Node merge(Node a, Node b) {
        if (a == null)      return b;
        if (b == null)      return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.down =  merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        result.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListFlatten list = new ListFlatten();

        Node head = list.new Node(5);
        head.down = list.new Node(7);
        head.down.down = list.new Node(8);
        head.down.down.down = list.new Node(30);

        head.next = list.new Node(10);
        head.next.down = list.new Node(20);

        head.next.next = list.new Node(19);
        head.next.next.down = list.new Node(22);
        head.next.next.down.down = list.new Node(50);

        head.next.next.next = list.new Node(28);
        head.next.next.next.down = list.new Node(35);
        head.next.next.next.down.down = list.new Node(40);
        head.next.next.next.down.down.down = list.new Node(45);

        head = flatten(head);

        while(head != null) {
            System.out.println(head.data);
            head = head.down;
        }
    }
}
