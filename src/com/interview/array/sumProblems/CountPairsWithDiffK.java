package com.interview.array.sumProblems;

import java.util.Arrays;
import java.util.HashMap;

public class CountPairsWithDiffK {

    public int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;
        Arrays.sort(arr); // Sort array elements

        int l = 0, r = 0;
        while(r < n) {
            if(arr[r] - arr[l] == k) {
                count++;
                l++;
                r++;
            } else if(arr[r] - arr[l] > k)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }

    static int countPairs(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            // Check if the complement (arr[i] + k)
            // exists in the map. If yes, increment count
            if (freq.containsKey(arr[i] + k))
                cnt += freq.get(arr[i] + k);

            // Check if the complement (arr[i] - k)
            // exists in the map. If yes, increment count
            if (freq.containsKey(arr[i] - k))
                cnt += freq.get(arr[i] - k);

            // Increment the frequency of arr[i]
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        return cnt;
    }
}
