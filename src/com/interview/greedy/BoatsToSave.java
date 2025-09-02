package com.interview.greedy;

import java.util.Arrays;

// Given an array people[] where people[i] is the weight of the ith person, and an infinite number of boats where each
// boat can carry at most two people at a time with total maximum weight of W. Return the minimum number of boats to carry all the people.

public class BoatsToSave {

    public void minBoats(int[] arr, int boatCapacity) {
        Arrays.sort(arr);
        int boats = 0, left = 0, right = arr.length - 1;

        while (left <= right) {
            if (arr[left] + arr[right] <= boatCapacity) {      // If heaviest and lightest person can fit in same boat
                left++;
            }

            right--;        // In any case, the heaviest person will be on the boat
            boats++;
        }

        System.out.println(boats);
    }
}
