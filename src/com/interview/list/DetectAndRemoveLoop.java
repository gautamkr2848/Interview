package com.interview.list;

import java.util.HashSet;
import java.util.Set;

//Floyd’s Cycle-Finding Algorithm:

public class
DetectAndRemoveLoop {

    public Node detectLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }

    public void removeLoop(Node head) {
        Node meet = detectLoop(head);

        if(meet == null)
            System.out.print("No loop exists");

        Node curr = head;
        Node prev = null;

        while (curr != meet){
            prev = meet;
            curr = curr.next;
            meet = meet.next;
        }

        prev.next = null;
    }

    static int countNodesInLoop(Node node) {
        int res = 1;
        Node temp = node;
        while (temp.next != node) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    public boolean removeLoop_2(Node h) {
        Set<Node> s = new HashSet<Node>();
        Node prev = null;
        while (h != null) {
            if (s.contains(h)) {
                prev.next = null;
                return true;
            } else {
                s.add(h);
                prev = h;
                h = h.next;
            }
        }

        return false;
    }
}
