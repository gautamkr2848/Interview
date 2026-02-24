package com.interview.array.priorityQueue_heap;

//Given an array of n elements, where each element is at most k away from its target
// position, devise an algorithm that sorts in O(n log k) time

//Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
//            k = 3
//Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

import java.util.*;

public class d_KSortedArray {

    public void kSortedArray(){

        int k = 4;
        int arr[] = {10, 9, 8, 7, 4, 70, 60, 50};
        int n = arr.length;

        if (arr == null || arr.length == 0)
            return;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(arr[i]);

        List<Integer> result = new ArrayList<>();
        for (int i = k; i < n; i++) {
            pq.add(arr[i]);
            result.add(pq.poll());
        }

        while (!pq.isEmpty())
            result.add(pq.poll());

        for(int i=0; i<result.size(); i++)
            System.out.print(result.get(i) + " ");
    }

    static String isKSortedArray(int arr[], int n, int k) {

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Map each value in sorted array to its index (handles duplicates carefully)
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // If element occurs multiple times, only put if not already present
            indexMap.putIfAbsent(sorted[i], i);
        }

        // Check if each element is within k distance of its sorted position
        String result = "Yes";
        for (int i = 0; i < n; i++) {
            int sortedIndex = indexMap.get(arr[i]);
            if (Math.abs(sortedIndex - i) > k) {
                result = "No";
                break;
            } else {
                // Move indexMap pointer forward in case of duplicates
                indexMap.put(arr[i], sortedIndex + 1);
            }
        }

        return result;
    }
}
