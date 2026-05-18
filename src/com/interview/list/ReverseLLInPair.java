package com.interview.list;

public class ReverseLLInPair {

    public static Node reverseInPairs(Node head) {

        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;

        // New head will be second node
        head = head.next;

        while (curr != null && curr.next != null) {

            Node next = curr.next;
            Node nextPair = next.next;

            // Reverse current pair
            next.next = curr;
            curr.next = nextPair;

            // Connect previous pair
            if (prev != null) {
                prev.next = next;
            }

            // Move prev and curr forward
            prev = curr;
            curr = nextPair;
        }

        return head;
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
}
