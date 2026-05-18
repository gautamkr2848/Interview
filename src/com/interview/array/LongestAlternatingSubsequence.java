package com.interview.array;

// A sequence {X1, X2, .. Xn} is an alternating sequence if its elements satisfy one of the following relations :

// X1 < X2 > X3 < X4 > X5 < …. xn or
// X1 > X2 < X3 > X4 < X5 > …. xn

//Input: arr[] = {10, 22, 9, 33, 49, 50, 31, 60}
//Output: 6
//Explanation: The subsequences {10, 22, 9, 33, 31, 60} or
//{10, 22, 9, 49, 31, 60} or {10, 22, 9, 50, 31, 60}
//are longest subsequence of length 6

public class LongestAlternatingSubsequence {

    private static int LAS(int[] arr, int n) {

        int inc = 1;
        int dec = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1])
                inc = dec + 1;
            else if (arr[i] < arr[i - 1])
                dec = inc + 1;
        }

        return Math.max(inc, dec);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 49, 50, 31, 60 };
        int n = arr.length;
        System.out.println(LAS(arr, n));
    }
}
