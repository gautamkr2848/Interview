package com.interview.dynamic.one_dim_dp;

// You are given an array of distinct integers nums and a target integer target. Your task is to find the number of
// possible combinations from the array that add up to the target.

public class CombinationSum {

    public int combinationSum4(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;      // there's one way to make sum 0 (using no numbers)

        for (int currentSum = 1; currentSum <= sum; currentSum++) {
            for (int num : nums) {
                // If the current number can be used to form currentSum
                if (currentSum >= num) {
                    // Add the number of ways to form (currentSum - num) to current position
                    // This represents using 'num' as the last element in the combination
                    dp[currentSum] += dp[currentSum - num];
                }
            }
        }

        return dp[sum];
    }
}
