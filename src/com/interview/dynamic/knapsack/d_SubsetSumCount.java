package com.interview.dynamic.knapsack;

public class d_SubsetSumCount {

    public void subsetSumCount(int[] arr, int sum){
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= sum; i++)
            t[0][i] = 0;
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        for(int i=1; i<=n; i++) {
            for (int j =1; j <= sum; j++) {
                if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
            }
        }
        System.out.println(t[n][sum]);
    }
}
