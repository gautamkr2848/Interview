package com.interview.array;

public class SubarrayMinMaxSum {

    public static int[] findMinMaxSum(int[] arr, int k) {

        int n = arr.length;

        if (k > n) return new int[]{-1, -1};

        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int minSum = windowSum;
        int maxSum = windowSum;

        // slide window
        for (int i = k; i < n; i++) {

            windowSum += arr[i] - arr[i - k];

            minSum = Math.min(minSum, windowSum);
            maxSum = Math.max(maxSum, windowSum);
        }

        return new int[]{minSum, maxSum};
    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int[] res = findMinMaxSum(arr, k);

        System.out.println("Min sum = " + res[0]);
        System.out.println("Max sum = " + res[1]);
    }
}