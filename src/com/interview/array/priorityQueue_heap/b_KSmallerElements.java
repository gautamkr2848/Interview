package com.interview.array.priorityQueue_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class b_KSmallerElements {

    public static void FirstKelements() {
        int[] arr = {12,1,787,5,23};
        int k = 2;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++)
            queue.add(arr[i]);

        for(int i = k; i < arr.length; i++) {
            if (queue.peek() >= arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        while (!queue.isEmpty())
            System.out.println("K smaller element is: " + queue.poll());
    }

    public static void FirstKelements2() {
        int[] arr = {12,1,787,5,23};
        int k = 2;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++)
            queue.add(arr[i]);

        for(int i=0; i<k; i++)
            System.out.println("K smaller element is: " + queue.poll());
    }

    //  O(n + k * log n).

    public static void main(String[] args) {
        FirstKelements();
        System.out.println();
        FirstKelements2();
    }
}
