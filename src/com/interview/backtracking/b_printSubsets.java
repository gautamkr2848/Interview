package com.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

public class b_printSubsets {

    public static void printSubsets(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(arr, res, curr, 0);

        System.out.println(res.toString());
    }

    public static void backtrack(int[] arr, List<List<Integer>> res, List<Integer> curr, int index) {
        res.add(new ArrayList<>(curr));
        for(int i=index; i<arr.length; i++) {
            curr.add(arr[i]);
            backtrack(arr, res, curr, i + 1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        printSubsets(new int[]{1, 2,3});
        StringCombination();
        printSubsets_dup(new int[]{1,2,2});
    }

    // print all the subsets of a string
    public static void StringCombination(){
        String s = "abc";
        char set[] = s.toCharArray();
        int n = set.length;

        for (int i = 0; i < Math.pow(2,n); i++) {
            for (int j = 0; j < n; j++){
                if ((i & (int)(Math.pow(2,j))) > 0)
                    System.out.print(set[j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void printSubsets_dup(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(arr);
        backtrack_dup(arr, res, curr, 0);

        System.out.println(res.toString());
    }

    public static void backtrack_dup(int[] arr, List<List<Integer>> res, List<Integer> curr, int index) {

        if(res.contains(curr))
            return;

        res.add(new ArrayList<>(curr));
        for(int i=index; i<arr.length; i++) {
            curr.add(arr[i]);
            backtrack_dup(arr, res, curr, i + 1);
            curr.remove(curr.size()-1);
        }
    }

    // Time Complexity: O(N*2^N)
}
