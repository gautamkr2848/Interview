package com.interview.dynamic.gridDP;

public class b_MinCostPath {

    public static int minCost_2(int[][] cost, int m, int n){
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if(m == 0 && n == 0)
            return cost[m][n];
        return cost[m][n] + min(minCost_2(cost, m-1, n), minCost_2(cost, m, n-1), minCost_2(cost, m-1, n-1));
    }

    // Time Complexity: O((M * N)3)
    // Auxiliary Space: O(M + N), for recursive stack space

    public int minCostMemoized(int[][] cost, int m, int n, int[][] dp) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];

        // Check if the result is already memoized
        if (dp[m][n] != -1)
            return dp[m][n];

        dp[m][n] = cost[m][n] + min(minCostMemoized(cost, m - 1, n - 1, dp), minCostMemoized(cost, m - 1, n, dp), minCostMemoized(cost, m, n - 1, dp));

        return dp[m][n];
    }

    static int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }

    public static int minCost_dp(int[][] cost, int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] =  cost[i][j];
                else {
                    dp[i][j] =  cost[i][j] + min((i>0 ? dp[i-1][j] : Integer.MAX_VALUE), (j>0 ? dp[i][j-1] : Integer.MAX_VALUE), ((i>0 && j>0 ? dp[i-1][j-1] : Integer.MAX_VALUE)));
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int cost[][]=  {{9, 4, 9, 9},
                        {6, 7, 6, 4},
                        {8, 3, 3, 7},
                        {7, 4, 9, 10}};
        int m=4, n=4;
        System.out.println(minCost_dp(cost, m, n));
    }
}
