package com.interview.array;

import java.util.PriorityQueue;

public class CostToConnectRoap {

    public void costToConnectRoap(){
        int arr[] = { 4, 3, 2, 6 };
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++)
            pq.add(arr[i]);

        while (pq.size() > 1) {
            // Extract shortest two ropes from pq
            int first = pq.poll();
            int second = pq.poll();

            // Connect the ropes: update result and insert the new rope to pq
            res += first + second;
            pq.add(first + second);
        }
        System.out.println(res);
    }
}
