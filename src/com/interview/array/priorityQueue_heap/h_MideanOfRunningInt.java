package com.interview.array.priorityQueue_heap;

import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity - O(nlogn)

public class h_MideanOfRunningInt {

// we can use a max heap on the left side to represent elements that are less than effective median, and a min-heap on
// the right side to represent elements that are greater than effective median.

// After processing an incoming element, the number of elements in heaps differs utmost by 1 element. When both heaps
// contain the same number of elements, we pick the average of heaps root data as effective median. When the heaps are
// not balanced, we select effective median from the root of the heap containing more elements.

// maxHeap - evicts greater element and store min element
// minHeap - evicts lesser element and store max element

    // maxHeap size can't be less than minHeap size
    // maHeap size either equal or only 1 greater than minHeap size

    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {
        h_MideanOfRunningInt h = new h_MideanOfRunningInt();
        int[] a = {5, 15, 1, 3};
        for(int i=0; i<a.length; i++) {
            insert(a[i]);
            System.out.println(median());
        }
    }

    public h_MideanOfRunningInt(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());      //left side     // first polls larger element
        minHeap = new PriorityQueue<>();        //right side        // first polls smaller element
    }

    public static void insert(Integer n) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= n)
            maxHeap.add(n);
        else
            minHeap.add(n);

        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public static double median(){
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
