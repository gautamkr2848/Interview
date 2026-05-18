package com.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    // One element can be used multiple times

    public static void main(String[] args) {
        int[] a = {2, 4, 8, 6};
        int sum = 8;
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, a, sum, ans, new ArrayList<>());
        System.out.println(ans.toString());
    }

    private static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> curr) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if (arr[index] <= target) {
            curr.add(arr[index]);
            findCombinations(index, arr, target - arr[index], ans, curr);
            curr.remove(curr.size() - 1);
        }
        findCombinations(index + 1, arr, target, ans, curr);
    }

    // O(k*2^n) time complexity
}
