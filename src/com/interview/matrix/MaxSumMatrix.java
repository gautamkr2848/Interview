package com.interview.matrix;

public class MaxSumMatrix {

    public int MaximumPath(int [][]mat) {
        int m = mat.length;
        int n = mat[0].length;

        int [][]sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                sum[i][j] = mat[i - 1][j - 1] + Math.max(sum[i - 1][j], sum[i][j - 1]);

        return sum[m][n];
    }

    public int maxCost_2(int[][] cost, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MIN_VALUE;
        if(m == 0 && n == 0)
            return cost[m][n];
        return cost[m][n] + max(maxCost_2(cost, m-1, n), maxCost_2(cost, m, n-1), maxCost_2(cost, m-1, n-1));
    }

    private int max(int x, int y, int z) {
        if (x < y)
            return (y < z)? y : z;
        else
            return (x < z)? x : z;
    }
}