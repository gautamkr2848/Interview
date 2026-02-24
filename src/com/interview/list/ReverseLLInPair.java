package com.interview.list;

public class ReverseLLInPair {

    public static Node reverseInPairs(Node head) {
        if (head == null || head.next == null) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (head != null && head.next != null) {
            Node first = head;
            Node second = head.next;

            // Swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node = reverseInPairs(node);

        while (node != null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    //Base case: if 0 or 1 node is left → return as is.
    //Recursively reverse the rest of the list after the first two nodes.
    //Swap the first two nodes.
    //Connect the reversed rest of the list after the swapped pair.

    public static Node reverseInPairs_2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = head.next;
        head.next = reverseInPairs(second.next);
        second.next = head;
        return second;
    }
}
