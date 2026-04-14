package com.interview.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class mergeKSortedList {

    public Node mergeKLists(Node[] arr) {
        Node result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = mergeList_3(result, arr[i]);
        }

        return result;
    }

    private Node mergeList_3(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.next = mergeList_3(a.next, b);
        } else {
            result = b;
            result.next = mergeList_3(a, b.next);
        }

        return result;
    }

    public Node mergeKLists_2(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>();     // use min heap, which will return min element first
        pq.addAll(Arrays.asList(lists).subList(0, lists.length));  // push the first node of each list into the min-heap

        Node head = null;   // head points to the first node of the output list
        Node last = null;   // tail points to its last node

        while (!pq.isEmpty()) {
            Node min = pq.poll();

            if (head == null)      // add the minimum node to the output list
                head = last = min;
            else {
                last.next = min;
                last = min;
            }

            if (min.next != null)       // take the next node from the "same" list and insert it into the min-heap
                pq.add(min.next);
        }
        return head;
    }
}
