package com.interview.array.subArray.slidingWindow;

// The problem presents a binary array nums, comprised of 0s and 1s. The task is to find the size of the largest
// contiguous subarray of 1s that could be obtained by removing exactly one element from the array. You are also
// informed that if there is no such subarray made up entirely of 1s after removing an element, the function should return 0.

public class LongestSubArrayof_1_AfterDeleting_1_Element {

    public static int longestSubarray(int[] nums) {
        int length = nums.length;
        int maxLength = 0;

        int[] left = new int[length];
        int[] right = new int[length];

        // Count consecutive 1s from left to right, starting from the second element
        for (int i = 1; i < length; ++i) {
            if (nums[i - 1] == 1) {
                left[i] = left[i - 1] + 1;      // If the previous element is 1, increment the count
            }
        }

        // Count consecutive 1s from right to left, starting from the second-to-last element
        for (int i = length - 2; i >= 0; --i) {
            if (nums[i + 1] == 1) {
                right[i] = right[i + 1] + 1;        // If the next element is 1, increment the count
            }
        }

        // Loop to find the maximum length by combining the left and right counts of 1s
        for (int i = 0; i < length; i++) {
            // Compute the length of subarray by removing the current element, hence adding left and right counts of 1s.
            // Since one element is always removed, the combined length of consecutive 1s from left and right
            // should not be equal to the total length of the array (which implies no 0 was in the array to begin with).
            maxLength = Math.max(maxLength, left[i] + right[i]);
        }

        // Reduce the length by 1 if the length of consecutive 1s equals the array length, since we need to remove one element.
        if (maxLength == length) {
            maxLength--;
        }

        // Return the maximum length of subarray after deletion
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(longestSubarray(nums)); // Output: 3
    }
}
