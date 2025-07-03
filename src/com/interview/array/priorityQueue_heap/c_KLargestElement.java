package com.interview.array.priorityQueue_heap;

// Priority Queue
// Add and Remove - O(log n)
// Peek - O(1)
// Poll - O(log n)

import java.util.PriorityQueue;

public class c_KLargestElement {

    public void kLargestElement(){
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        int k = 2;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
            q.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            if (q.peek() <= arr[i]){
                q.poll();
                q.add(arr[i]);
            }
        }

        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
    }
}

// Time Complexity: O(n * log k), this solution can work in O(k + (n-k) Log K) as build heap take linear time.
// Auxiliary Space: O(k)
