package com.interview.array;

import java.util.Arrays;

public class TripletSumClosestToTarget {

    public static int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int currSum = arr[i] + arr[start] + arr[end];

                if (Math.abs(currSum - target) < minDiff) {
                    minDiff = Math.abs(currSum - target);
                    sum = currSum;
                } else if(Math.abs(currSum - target) == minDiff) {
                    sum = Math.max(sum, currSum);
                }

                if (currSum > target)
                    end--;
                else
                    start++;
            }
        }

        return sum;
    }
}

//Time complexity - O(n^2)
