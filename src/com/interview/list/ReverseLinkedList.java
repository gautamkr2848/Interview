package com.interview.list;

public class ReverseLinkedList {

    // 1 2 3 4      prev = null, current = 1
    // next = 2, current.next = null, prev = 1, current = 2
    // next = 3, current.next = 1, prev = 2, current = 3
    // next = 4, current.next = 2, prev = 3, current = 4
    // next = null, current.next = 3, prev = 4, current = null

    public Node reverseList(Node head){

        Node prev = null, next;
        Node current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // 1

    // 1    2
    // 2
    // 2    1

    // 1    2   3   4
    // 2    3   4
    // 3    4
    // 4
    // 4    3
    // 4    3   2
    // 4    3   2   1

    public Node reverseListRecurrsion(Node head){

        if(head == null || head.next == null)
            return head;

        Node newHead = reverseListRecurrsion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
