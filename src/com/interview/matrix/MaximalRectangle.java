package com.interview.matrix;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    // Maximum Rectangle Matrix with All 1s

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println(maximalRectangle(mat));
    }

    private static int maximalRectangle(int[][] m) {
        if (m == null || m.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                heights[j] = m[i][j] == 0 ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    // Helper function to calculate largest rectangle in histogram
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
