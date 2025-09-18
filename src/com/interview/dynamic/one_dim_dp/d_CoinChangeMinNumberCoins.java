package com.interview.dynamic.one_dim_dp;

//Find minimum number of coins that make a given value

// amount - 11
// coins - 1, 5, 6, 9

// minCoin Array pos -   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// minCoin Array value - 0, 1, 2, 3, 4, 1, 1, 2, 2, 3, 2,  2

import java.util.Arrays;

public class d_CoinChangeMinNumberCoins {

    public static int coinChangeMinNumberCoins(){
        int[] coinArray = {1, 5, 6, 9};
        int sum = 11;
        int[] minCoins = new int[sum + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);

        minCoins[0] = 0; // Base case: 0 coins needed to make sum 0

        for (int i = 1; i <= sum; i++) {
            for (int coin : coinArray) {
                if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }
        return minCoins[sum] == Integer.MAX_VALUE ? -1 : minCoins[sum];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeMinNumberCoins());
    }
}
