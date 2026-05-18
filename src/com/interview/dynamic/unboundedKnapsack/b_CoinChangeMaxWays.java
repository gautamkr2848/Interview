package com.interview.dynamic.unboundedKnapsack;

/* coin change problem deals with finding the total number of ways that
         an amount of money can be made using specific coins only.*/

import java.util.Arrays;

public class b_CoinChangeMaxWays {

    public void coinChangeMaxNumberOfWays(){
        int coinArray[] = { 1, 2, 3 };
        int sum = 4;
        int n = coinArray.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i <= sum; i++)
            t[0][i] = 0;
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(coinArray[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i][j-coinArray[i-1]] + t[i-1][j];
            }
        }
        System.out.println(t[n][sum]);
    }

    // Time complexity of this function: O(n*sum)
    // Space Complexity of this function: O(sum)

    public static int count(int coins[], int n, int sum) {

        if (sum == 0)
            return 1;

        if (sum < 0 || n <= 0)
            return 0;

        return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
    }

    //Time Complexity: O(2 ^ sum)
    //Auxiliary Space: O(target)

    public static void main(String[] args) {
        int[] price = { 1, 2, 3 };

        System.out.println(count(price, price.length-1, 4));
    }
}
