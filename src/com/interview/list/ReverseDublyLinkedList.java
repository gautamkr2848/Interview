package com.interview.list;

class DoublyNode{
    int data;
    DoublyNode prev, next;

    public DoublyNode(int data){
        this.data = data;
    }
}

public class ReverseDublyLinkedList {

    public void reverseDublyLinkedList(DoublyNode head){
        DoublyNode temp = null;
        DoublyNode current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        /* Before changing head, check for the cases like empty
         list and list with only one node */
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static DoublyNode reverse(DoublyNode node) {
        if (node == null)
            return null;

        // Otherwise, swap the next and prev
        DoublyNode temp = node.next;
        node.next = node.prev;
        node.prev = temp;

        // If the prev is now null, the list
        // has been fully reversed
        if (node.prev == null)
            return node;

        // Otherwise, keep going
        return reverse(node.prev);
    }
}
