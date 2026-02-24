package com.interview.array.priorityQueue_heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestDifference {

    public static void main(String[] args) {

        int[] a = {2, 3, 4, 7, 8, 9, 7, 15};
        int n = 7, k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(a[i] - a[j]);
                pq.add(diff);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        System.out.println(pq.poll());

        // Another method
        System.out.println(kthDiff(a, a.length, k));
    }

    // Sort the array
    // Find min diff and max diff
    // Iterate over min -> max, using left and right pointer
    // For mid, find the total diff count equal to less than mid
    // If count < k, low = mid + 1
    // Else high = mid



    // Returns k-th absolute difference
    static int kthDiff(int a[], int n, int k) {
        // Sort array
        Arrays.sort(a);

        // Minimum absolute difference
        int low = a[1] - a[0];
        for (int i = 1; i <= n-2; ++i)
            low = Math.min(low, a[i+1] - a[i]);

        // Maximum absolute difference
        int high = a[n-1] - a[0];

        // Do binary search for k-th absolute difference
        while (low < high)
        {
            int mid = (low + high) >> 1;
            if (countPairs(a, n, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static int countPairs(int[] a, int n, int mid) {
        int res = 0, value;
        for(int i = 0; i < n; i++) {
            if(a[i] + mid > a[n-1])
                res = res + n - (i+1);
            else {
                int ub = upperbound(a, n, a[i] + mid);
                res = res + (ub- (i+1));
            }
        }
        return res;
    }

    // returns the upper bound
    static int upperbound(int a[], int n, int value) {
        int low = 0;
        int high = n;
        while(low < high) {
            int mid = (low + high)/2;
            if(value >= a[mid])
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}