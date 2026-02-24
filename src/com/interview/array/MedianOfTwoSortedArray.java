package com.interview.array;

import java.util.Arrays;

public class MedianOfTwoSortedArray {

    public double findMedian(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength / 2;
        int[] merged = mergedArray(nums1, nums2, mid);
        if (totalLength % 2 == 0) {
            return (merged[mid - 1] + merged[mid]) / 2.0;
        } else {
            return merged[mid];
        }
    }

    public int[] mergedArray(int[] num1, int[] num2, int mid) {
        int[] merged = new int[mid + 1];
        int i = 0, j = 0, k = 0;
        while (i < num1.length && j < num2.length && k <= mid) {
            if (num1[i] < num2[j]) {
                merged[k++] = num1[i++];
            } else {
                merged[k++] = num2[j++];
            }
        }
        while (i < num1.length && k <= mid) {
            merged[k++] = num1[i++];
        }
        while (j < num2.length && k <= mid) {
            merged[k++] = num2[j++];
        }
        return merged;
    }
}
