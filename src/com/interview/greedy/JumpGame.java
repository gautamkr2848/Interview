package com.interview.greedy;

// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
// array represents your maximum jump length at that position.
//
// Return true if you can reach the last index, or false otherwise.

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(i + nums[i] >= finalPos) {
                finalPos = i;
            }
        }

        return finalPos == 0;
    }

    // Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element
    // in the array represents your maximum jump length at that position. Your goal is to reach the last index in the
    // minimum number of jumps. You can assume that you can always reach the last index.

    public int jumpII(int[] nums) {

        int totalJumps = 0, destination = nums.length - 1;
        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1) return 0;

        for (int i = 0; i < nums.length; i++) {

            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // check if we reached destination already
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }

    // Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you
    // are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
    //
    //Notice that you can not jump outside of the array at any time.

    boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();

            // reached the target index
            if (arr[curr] == 0)
                return true;

            // negative means we already tried it
            if (arr[curr] < 0)
                continue;

            // Try both directions
            if (curr + arr[curr] < arr.length)
                q.add(curr + arr[curr]);

            if (curr - arr[curr] >= 0)
                q.add(curr - arr[curr]);

            // mark this element as visited
            arr[curr] = -arr[curr];
        }

        return false;
    }
}
