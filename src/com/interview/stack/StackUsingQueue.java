package com.interview.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q1 = new LinkedList<Integer>();

    void push(int x) {
        int s = q1.size();
        q1.add(x);

        // Pop all the previous elements and put them after current element
        for (int i = 0; i < s; i++) {
            q1.add(q1.remove());
        }
    }

    Integer pop() {
        if (q1.isEmpty())
            return null;
        return q1.poll();
    }

    int top() {
        if (q1.isEmpty())
            return -1;
        return q1.peek();
    }

    int size() { return q1.size(); }

}
