package com.interview.array.twoPointer;

/*
Find the previous and the next smaller element for every element of the histogram, as this would help to calculate the
length of the subarray in which this current element is the minimum element. So we can create a rectangle of size
(current element * length of the subarray) using this element. Take the maximum of all such rectangles.

maxArea = height * (Nearest Smaller to Right index - Nearest Samller to Left index - 1)

        { 6, 2, 5, 4, 5, 1, 6 }
NSR       1, 5, 3, 5, 5, 7, 7
NSL     -1, -1, 1, 1, 3, -1, 5
Area    6, 10, 5, 12, 5, 7, 6
 */

import java.util.Stack;

public class MaxHistogramArea {

    public static void maxArea_2(){
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };
        int area = Integer.MIN_VALUE;
        int n = a.length;

        for(int i=0; i<n; i++){
            int left = i;
            int right = i;

            while(left >= 0 && a[i] <= a[left])
                left--;

            while (right < n && a[i] <= a[right])
                right++;

            area = Math.max(area, (right - left - 1) * a[i]);
        }
        System.out.println(area);
    }

    // O(N2)

    public static void main(String[] args) {
        maxArea_2();
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(largestRectangleArea(a));
        maxHistogram2(a);
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        Stack<Integer> s = new Stack<>();

        //Nearest smaller element right side
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()])
                s.pop();

            if (s.isEmpty())
                nsr[i] = n;
            else
                nsr[i] = s.peek();
            s.push(i);
        }

        while (!s.isEmpty()) s.pop();

        //Nearest smaller element left side
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[i] <= heights[s.peek()])
                s.pop();

            if (s.isEmpty())
                nsl[i] = -1;
            else
                nsl[i] = s.peek();
            s.push(i);
        }

        int area = 0;
        for (int i = 0; i < n; i++)
            area = Math.max(area, heights[i] * (nsr[i] - nsl[i] - 1));

        return area;
    }

    private static void maxHistogram2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, element * (nse - pse - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int element = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, element * (nse - pse - 1));
        }
        System.out.println(maxArea);
    }
}
