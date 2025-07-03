package com.interview.list;

import java.util.HashMap;
import java.util.Map;

public class ListCloneWithNextAndRandomPointer {
    static class Node {
        int data;
        Node next,random;
        Node(int x){
            data = x;
            next = random = null;
        }
    }

     /* 1       2       3       4       5
            1       2       3       4       5 */

    public static Node cloneLinkedList(Node head) {
        if (head == null)
            return null;

        Node curr = head;       // Step 1: Create new nodes and insert them next to the original nodes
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;        // Step 2: Set the random pointers of the new nodes
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        curr = head;        // Step 3: Separate the new nodes from the original nodes
        Node clonedHead = head.next;
        Node clonedCurr = clonedHead;
        while (clonedCurr.next != null) {
            curr.next = curr.next.next;
            clonedCurr.next = clonedCurr.next.next;
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }
        curr.next = null;
        clonedCurr.next = null;

        return clonedHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("The original linked list:");
        printList(head);

        // Function call
        Node sol = cloneLinkedList(head);

        System.out.println("The cloned linked list:");
        printList(sol);
    }

    private static void printList(Node head) {
        System.out.print(head.data + "(" + head.random.data + ")");
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.data + "(" + head.random.data + ")");
            head = head.next;
        }
        System.out.println();
    }

    public static Node listCloneWithNextAndRandomPointer(Node head){

        Node curr1 = head;
        Node curr2 = null;
        Map<Node, Node> map = new HashMap<>();

        while (curr1 != null) {
            curr2 = new Node(curr1.data);
            map.put(curr1, curr2);
            curr1 = curr1.next;
        }

        curr1 = head;
        while (curr1 != null){
            curr2 = map.get(curr1);
            curr2.next = map.get(curr1.next);
            curr2.random = map.get(curr1.random);
            curr1 = curr1.next;
        }
        return map.get(head);
    }
}
