package com.interview.dynamic.MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class c_MinCostRodCutting {

    // Recursive function to calculate the minimum cost
    static int f(int i, int j, List<Integer> cuts) {
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, cuts.get(j + 1) - cuts.get(i - 1) + f(i, k, cuts) + f(k + 1, j, cuts));
        }

        return min;
    }

    public static void main(String[] args) {
        List<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);

        System.out.println("The minimum cost incurred: " + f(1, c, cuts));
    }

    static int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];

        // Find maximum value for all rod of length i.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }
}
