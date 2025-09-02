package com.interview.array.array_shift;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0; // Pointer for the position to place the next non
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
}
