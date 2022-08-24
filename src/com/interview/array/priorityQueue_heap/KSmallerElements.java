package com.interview.array.priorityQueue_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallerElements {

    public void FirstKelements() {
        int[] arr = {12,5,787,1,23};
        int k = 2;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++)
            queue.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            if (queue.peek() >= arr[i]){    //q.peek() >= arr[i]
                queue.poll();
                queue.add(arr[i]);
            }
        }

        while (!queue.isEmpty())
            System.out.print(queue.poll() + " ");
    }
}