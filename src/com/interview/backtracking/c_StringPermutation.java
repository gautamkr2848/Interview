package com.interview.backtracking;

//Input: S = “ABC”
//Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

import java.util.*;

public class c_StringPermutation {

    public static void solve(char[] arr, int idx, Set<String> result) {
        if (idx == arr.length - 1) {
            result.add(String.valueOf(arr) + " ");
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            solve(arr, idx + 1, result);
            swap(arr, idx, i);
        }
    }

    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        String str = "ABC";
        char[] arr = str.toCharArray();
        Set<String> result = new HashSet<>();
        solve(arr, 0, result);
        System.out.println(result);
    }
}
