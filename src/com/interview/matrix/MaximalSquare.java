package com.interview.matrix;

// A square having maximum area

// Explanation:
//Initialization: Create a DP table with the same dimensions as the input matrix. Initialize a variable to track the maximum side length found.
//DP Transition: For each cell containing '1', update the DP table based on the values of its top, left, and top-left diagonal neighbors.
//Tracking the Maximum: Update the maximum side length whenever a larger square is found.
//Return the Area: Calculate the area of the largest square by squaring the maximum side length.
//Time Complexity: O(n * m), where n is the number of rows and m is the number of columns. Each cell is processed once.
//Space Complexity: O(n * m) for the DP table.

public class MaximalSquare {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(maximalSquare(mat));
    }

    private static int maximalSquare(int[][] m) {
        int row = m.length;
        int col = m[0].length;

        int[][] dp = new int[row][col];
        int max = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) {
                if(m[i][j] == 1) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1; // First row or first column
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // Time Complexity: O(n * m)
}
