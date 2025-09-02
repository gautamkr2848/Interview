package com.interview.array.pairCount;

// Example 1:
//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

//Example 2:
//Input: nums = [1,1,1,1]
//Output: 6
//Explanation: Each pair in the array are good.

//Example 3:
//Input: nums = [1,2,3]
//Output: 0

import java.util.HashMap;
import java.util.Map;

public class a_IdenticalPairs {

    public void countIdenticalPairs(int[] a, int n) {
        int[] tmp = new int[100];

        for(int i=0; i<a.length; i++)
            tmp[a[i]]++;

        int count = 0;
        for(Integer i : tmp) {
            count = count + (i* (i-1)) / 2;
        }

        System.out.println(count);
    }

    public void countIdenticalPairs_2(int[] a, int n) {
        Map<Integer, Integer> tmp = new HashMap<>();

        for(int i=0; i<a.length; i++)
            tmp.put(a[i], tmp.getOrDefault(a[i], 0) + 1);

        int count = 0;
        for(Integer i : tmp.values()) {
            count = count + (i* (i-1)) / 2;
        }

        System.out.println(count);
    }
}
