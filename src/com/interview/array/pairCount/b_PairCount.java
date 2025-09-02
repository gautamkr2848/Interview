package com.interview.array.pairCount;

// Count pairs (i, j) from arrays arr[] & brr[] such that arr[i] – brr[j] = arr[j] – brr[i]

// a[i] – b[j] = a[j] – b[i]

// a[i] + b[i] = a[j] + b[j]

import java.util.HashMap;
import java.util.Map;

public class b_PairCount {

    public static void CountPairs(int a[], int b[], int n) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
            map.put((a[i] + b[i]), map.getOrDefault((a[i] + b[i]), 0) + 1);

        int NoOfPairs = 0;

        for(Integer x : map.values()) {
            NoOfPairs = NoOfPairs + x * (x - 1) / 2;
        }

        System.out.println(NoOfPairs);
    }
}