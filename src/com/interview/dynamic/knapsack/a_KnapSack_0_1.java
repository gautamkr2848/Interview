package com.interview.dynamic.knapsack;

/*
    Knapsack    => Bag
    1. 0-1  => we can't break the item
    2. Fractional   => we can break the item
    3. Unbounded    => we can add same item multiple times
*/

import java.util.Arrays;

public class a_KnapSack_0_1 {

    public int knapSack_1(int[] wt, int[] val, int w, int n){
        if(n == 0 || w == 0)
            return 0;

        if(wt[n-1] > w)
            return knapSack_1(wt, val, w, n-1);
        else
            return Math.max(val[n-1] + knapSack_1(wt, val, w-wt[n-1], n-1), knapSack_1(wt, val, w, n-1));
    }

/*
    Time Complexity: O(2^N)
    Auxiliary Space: O(N)
*/

    static int[][] t = new int[5][51];
    public a_KnapSack_0_1(){
        for(int[] arr : t)
            Arrays.fill(arr, -1);
    }

    public int knapSack_2(int[] wt, int[] val, int w, int n){
        if(n == 0 || w == 0)
            return 0;
        if(t[n][w] != -1)
            return t[n][w];

        if(wt[n-1] > w)
            t[n][w] = knapSack_2(wt, val, w, n-1);
        else
            t[n][w] = Math.max(val[n-1] + knapSack_2(wt, val, w-wt[n-1], n-1), knapSack_2(wt, val, w, n-1));
        return t[n][w];
    }

/*
    Time Complexity: O(N * W)
    Auxiliary Space: O(N * W) + O(N)
*/

// wt  = {1, 3, 4, 5}
// val = {1, 4, 5, 7}
// w = 7
// n = 4

/*| i/j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
  | --- | - | - | - | - | - | - | - | - |
  |  0  | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
  |  1  | 0 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
  |  2  | 0 | 1 | 1 | 4 | 5 | 5 | 5 | 5 |
  |  3  | 0 | 1 | 1 | 4 | 5 | 6 | 6 | 9 |
  |  4  | 0 | 1 | 1 | 4 | 5 | 7 | 8 | 9 |*/

    public static int knapSack_3(int[] wt, int[] val, int w, int n){
        int[][] t = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
            }
        }
        return t[n][w];
    }

/*
    Time Complexity: O(N * W)
*/

    public static void main(String[] args) {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };

        System.out.println(knapSack_3(weight, profit, 50, 3));
    }

}
