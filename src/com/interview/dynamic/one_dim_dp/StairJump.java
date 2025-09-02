package com.interview.dynamic.one_dim_dp;

public class StairJump {

    public int numberOfWays(int n) {
        if(n == 1) return 1;
        return numberOfWays(n-1) + numberOfWays(n-2);
    }

    public int numberOfWays_2(int n) {

        if(n==1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
