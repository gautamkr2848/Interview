package com.interview.list;

public class RemoveDuplicates {

    //Remove duplicates from a sorted linked list
    public static Node removeDuplicates(Node head){
        Node curr = head;

        while (curr != null) {
            Node temp = curr;
            while(temp != null && temp.data == curr.data)
                temp = temp.next;

            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(2);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(3);
        node.next.next.next.next.next = new Node(3);
        node.next.next.next.next.next.next = new Node(5);

        Node curr = removeDuplicates(node);
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
}
