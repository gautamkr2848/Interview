package com.interview.dynamic.knapsack;

public class b_SubsetSum {

    public void subSetSum(int[] arr, int sum){
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= sum; i++)
            t[0][i] = false;
        for (int i = 0; i <= n; i++)
            t[i][0] = true;

        for(int i=0; i<=n; i++) {
            for (int j = 0; j <= sum; j++) {
                if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
            }
        }
        System.out.println(t[n][sum]);
    }
}
