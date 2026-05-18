package com.interview.list;

public class DeleteNodeWithoutHead {

    public static void deleteWithoutHead(){

        Node node = new Node(5);
        node.next = new Node(3);
        node.next.next = new Node(8);
        node.next.next.next = new Node(7);

        // 5 -> 3 -> 8 -> 7
        // 5 -> 8 -> 8 -> 7
        // 5 -> 8 -> 7 -> 7
        // 5 -> 8 -> 7
        Node tobeDeleted = node.next;
        Node prev = null;
        while (tobeDeleted.next != null) {
            tobeDeleted.data = tobeDeleted.next.data;
            prev = tobeDeleted;
            tobeDeleted = tobeDeleted.next;
        }
        prev.next = null;

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        deleteWithoutHead();
    }
}