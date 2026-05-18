package com.interview.matrix;

// The Naive Solution for this problem is to check every possible rectangle in the given 2D array.

/*
The idea is to fix the left and right columns one by one and find the maximum sum contiguous rows for every left and
right column pair.

We basically find top and bottom row numbers (which have maximum sum) for every fixed left and right column pair.
To find the top and bottom row numbers, calculate the sum of elements in every row from left to right and store these
sums in an array say temp[].

So temp[i] indicates sum of elements from left to right in row i. If we apply Kadane’s 1D algorithm on temp[], and get
the maximum sum subarray of temp, this maximum sum would be the maximum possible sum with left and right as boundary columns.

To get the overall maximum sum, we compare this sum with the maximum sum so far.

Time complexity to O(n^3)
*/

public class MaxSumRectangle {

    public static void maxSumRectangle() {

        int mat[][] = new int[][] {{ -1, -2, -1, -4, -20 },
                                    { -8, -3, -4, -2, -1 },
                                    { -3, 8, 1000, -1, -3 },
                                    { -4, -1, -1, -7, -6 }};

        int rows = mat.length;
        int columns = mat[0].length;
        int maxSum=0;

        for (int left = 0; left < columns; left++) {
            int temp[] = new int[rows];

            for (int right = left; right < columns; right++) {
                for (int i = 0; i < rows; i++)
                    temp[i] = temp[i] + mat[i][right];

                int sum = kadane(temp);
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }

    // Time Complexity - O(col pow 2 * row)

    public static void main(String[] args) {
        maxSumRectangle();
    }

    private static int kadane(int a[]){
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
