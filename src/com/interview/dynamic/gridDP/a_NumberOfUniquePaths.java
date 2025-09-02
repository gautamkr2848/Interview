package com.interview.dynamic.gridDP;

//Count all possible paths from top left to bottom right of a mXn matrix

import java.util.ArrayList;
import java.util.List;

public class a_NumberOfUniquePaths {

    public static int uniquePaths(int m, int n){

        if(m < 0 || n < 0)
            return 0;

        if (m == 0 && n == 0)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }

    // time complexity - O(2pow(m*n)) == exponential

    static int[][] t = new int[3][3];
    public static int uniquePaths_memorization(int m, int n){

        if(t[m][n] != -1)
            return t[m][n];

        if(m < 0 || n < 0)
            t[m][n] = 0;

        if (m == 0 && n == 0)
            t[m][n] = 1;

        t[m][n] = uniquePaths_memorization(m - 1, n) + uniquePaths_memorization(m, n - 1); // + numberOfPaths(m-1, n-1);
        return t[m][n];
    }

    // time complexity - O(m*n)

    public static int uniquePaths_dp(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i ==0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j]+ dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // Here O(1,1) comes with obstacle
    public static int maze_with_obstcale(int m, int n){
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i == 1 && j == 1)
                    dp[i][j] = 0;
                else if(i == 0  || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(maze_with_obstcale(3,3));
        findPaths(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new ArrayList<>(),0,0,3,3);

    }

    public static void findPaths(int[][] arr, List<Integer> path, int i, int j, int M, int N) {
        if (i == M - 1 && j == N - 1) {
            path.add(arr[i][j]);

            for (int a : path) {
                System.out.print(a + ", ");
            }
            System.out.println();

            path.remove(path.size() - 1);
            return;
        }

        if (i < 0 || i >= M || j < 0 || j >= N)
            return;

        path.add(arr[i][j]);

        findPaths(arr, path, i, j + 1, M, N);
        findPaths(arr, path, i + 1, j, M, N);

        path.remove(path.size() - 1);
    }
}
