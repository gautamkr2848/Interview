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

    static int getMaxArea2(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0, tmp, pse, nse;

        // Traverse all bars of the histogram
        for (int i = 0; i < n; i++) {
            // While the current bar is smaller than the bar at stack top
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                tmp = s.pop();
                nse = i; // Nearest Smaller to Right index
                pse = s.isEmpty() ? -1 : s.peek(); // Nearest Smaller to Left index
                maxArea = Math.max(maxArea, (nse - pse - 1) * arr[tmp]);
            }
            s.push(i);
        }

        // Process remaining bars in stack
        while (!s.isEmpty()) {
            tmp = s.pop();
            nse = n; // No smaller to right, so use n
            pse = s.isEmpty() ? -1 : s.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * arr[tmp]);
        }

        return maxArea;
    }

    // O(N)

    public static void main(String[] args) {
        maxArea_2();
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(getMaxArea2(a));
        System.out.println(largestRectangleArea(a));
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
}
