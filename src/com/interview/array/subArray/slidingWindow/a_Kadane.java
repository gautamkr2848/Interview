package com.interview.array.subArray.slidingWindow;

// Find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

public class a_Kadane {

    public int Kadane(int[] a){
        //int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = a[0], currMax = 0;

        for (int i = 0; i < a.length; i++) {
            currMax = currMax + a[i];
            if (maxSum < currMax)
                maxSum = currMax;
            if (currMax < 0)
                currMax = 0;
        }
        return maxSum;
    }
}
