package com.interview.backtracking;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    static int cntSubarrays(int[] arr, int k) {

        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];

            if (currSum == k)   // If currSum is equal to desired sum hen a new subarray is found.
                res++;

            if (prefixSums.containsKey(currSum - k))    // Check if the difference exists in the prefixSums map.
                res += prefixSums.get(currSum - k);

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);       // Add currSum to the set of prefix sums.
        }

        return res;
    }
}
