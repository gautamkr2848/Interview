package com.interview.dynamic;

//Find minimum number of coins that make a given value

// amount - 11
// coins - 1, 5, 6, 9

// minCoin Array pos -   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// minCoin Array value - 0, 1, 2, 3, 4, 1, 1, 2, 2, 3, 2,  2

import java.util.Arrays;

public class  c_CoinChangeMinNumberCoins {

    public static void coinChangeMinNumberCoins(){
        int[] coinArray = {25, 10, 5};
        int sum = 30;
        int[] minCoins = new int[sum + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);

        if(sum < 1) {
            System.out.println("Sum must be greater than 0.");
            return;
        }

        minCoins[0] = 0; // Base case: 0 coins needed to make sum 0

        for (int i = 1; i <= sum; i++) {
            for (int coin : coinArray) {
                if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }

        if (minCoins[sum] == Integer.MAX_VALUE) {
            System.out.println("No solution exists for the given sum.");
        } else {
            System.out.println("Minimum number of coins required: " + minCoins[sum]);
        }

    }

    public static void main(String[] args) {
        coinChangeMinNumberCoins();
    }
}
