package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencePrint {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> res = new ArrayList<>();
        printSubsequences(arr, 0, res);
        //printAnyOneSubsequencesWithSumK(arr, 0, res, 0, 7);
    }

    private static void printSubsequences(int[] arr, int index, List<Integer> res) {
        if(index >= arr.length) {
            System.out.println(res.toString());
            return;
        }
        res.add(arr[index]);
        printSubsequences(arr, index + 1, res);
        res.remove(res.size() - 1); // backtrack
        printSubsequences(arr, index + 1, res); // exclude current element
    }

    private static void printSubsequencesWithSumK(int[] arr, int index, List<Integer> res, int currentSum, int sum) {
        if (index >= arr.length) {
            if (currentSum == sum) {
                System.out.println(res.toString());
            }
            return;
        }
        res.add(arr[index]);
        printSubsequencesWithSumK(arr, index + 1, res, currentSum + arr[index], sum);
        res.remove(res.size() - 1); // backtrack
        printSubsequencesWithSumK(arr, index + 1, res, currentSum, sum); // exclude current element
    }

    private static boolean printAnyOneSubsequencesWithSumK(int[] arr, int index, List<Integer> res, int currentSum, int sum) {
        if (index >= arr.length) {
            if (currentSum == sum) {
                System.out.println(res.toString());
                return true; // found a valid subsequence
            }
            return false;
        }
        res.add(arr[index]);
        if(printAnyOneSubsequencesWithSumK(arr, index + 1, res, currentSum + arr[index], sum)) {
            return true; // found a valid subsequence in the inclusion case
        }
        res.remove(res.size() - 1); // backtrack
        if(printAnyOneSubsequencesWithSumK(arr, index + 1, res, currentSum, sum)) {
            return true; // found a valid subsequence in the exclusion case
        } // exclude current element
        return false; // no valid subsequence found
    }
}
