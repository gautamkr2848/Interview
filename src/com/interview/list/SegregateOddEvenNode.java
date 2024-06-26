package com.interview.list;

public class SegregateOddEvenNode {

    public static Node rearrangeEvenOdd(Node head) {

        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        Node oddStart = null, oddEnd = null, evenStart = null, evenEnd = null;
        int i = 1;

        while (curr != null) {
            if (i % 2 == 0) {       // even
                if (evenStart == null)
                    evenStart = curr;
                else
                    evenEnd.next = curr;

                evenEnd = curr;

            } else {      // odd
                if (oddStart == null)
                    oddStart = curr;
                else
                    oddEnd.next = curr;

                oddEnd = curr;
            }

            curr = curr.next;
            i++;
        }

        oddEnd.next = evenStart;
        evenEnd.next = null;
        return oddStart;
    }

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node curr = rearrangeEvenOdd(node);
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
}
