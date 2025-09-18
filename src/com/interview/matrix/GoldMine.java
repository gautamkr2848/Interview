package com.interview.matrix;

import java.util.Arrays;

/*
Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold
in tons. Initially, the miner is in the first column but can be in any row. He can move only (right->,right up /,right
down\) that is from a given cell, the miner can move to the cell diagonally up towards the right or diagonally down
towards the right. Find out the maximum amount of gold he can collect.
*/

public class GoldMine {

    public void maxGold(int m, int n, int gold[][]) {
        int t[][] = new int[m][n];
        for(int[] rows : t)
            Arrays.fill(rows, 0);

        for (int col = n-1; col >= 0; col--){
            for (int row = 0; row < m; row++){

                // Gold collected on going to the cell on the right(->)
                int right = (col == n-1) ? 0 : t[row][col+1];

                // Gold collected on going to the cell to right up (/)
                int right_up = (row == 0 ||  col == n-1) ? 0 :  t[row-1][col+1];

                // Gold collected on going to the cell to right down (\)
                int right_down = (row == m-1 || col == n-1) ? 0 :  t[row+1][col+1];

                // Max gold collected from taking either of the above 3 paths
                t[row][col] = gold[row][col] + max(right, right_up,  right_down);
            }
        }

        // The max amount of gold collected will be the max value in first column of all rows
        int res = t[0][0];
        for (int i = 1; i < m; i++)
            res = Math.max(res, t[i][0]);

        System.out.println(res);
    }

    private int max(int x, int y, int z) {
        if(x < y)
            return (y < z) ? z : y;
        else
            return (x < z) ? z : x;
    }

    public static void main(String[] args) {
        GoldMine g = new GoldMine();
        int gold[][] = { {1, 3, 3},
                         {2, 1, 4},
                         {0, 6, 4},
                         {7, 5, 5},
                         {3, 0, 6} };
        g.maxGold(5, 3, gold);
    }
}
