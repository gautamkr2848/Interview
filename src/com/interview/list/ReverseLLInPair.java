package com.interview.list;

public class ReverseLLInPair {

    public Node reverseInPairs(Node head) {
        if (head == null || head.next == null) {
            return head; // No pairs to reverse
        }

        Node newHead = head.next; // The new head will be the second node
        Node prev = null;
        Node current = head;

        while (current != null && current.next != null) {
            Node nextPair = current.next.next; // Save the next pair's starting point
            Node second = current.next; // The second node in the pair

            // Reverse the current pair
            second.next = current;
            current.next = nextPair;

            if (prev != null) {
                prev.next = second; // Link the previous pair to the current reversed pair
            }

            prev = current; // Move prev to the end of the reversed pair
            current = nextPair; // Move to the next pair
        }

        return newHead; // Return the new head of the reversed list
    }

    //Base case: if 0 or 1 node is left → return as is.
    //Recursively reverse the rest of the list after the first two nodes.
    //Swap the first two nodes.
    //Connect the reversed rest of the list after the swapped pair.

    public Node reverseInPairs_2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node second = head.next;
        head.next = reverseInPairs(second.next);
        second.next = head;
        return second;
    }
}
