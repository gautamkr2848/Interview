package com.interview.array;

/*
Given a sorted array of positive numbers,
find the smallest positive integer value that cannot be represented as sum of
elements of any subset of given set.
        Input:  arr[] = {1, 3, 6, 10, 11, 15};
        Output: 2
*/

public class NotSubsetSum {

    public static void findSmallest(int[] arr, int n) {
        int res = 1;
        for (int i = 0; i < n && arr[i] <= res; i++)
            res = res + arr[i];

        System.out.println(res);
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 6, 10, 11, 15};
        int n = arr.length;
        findSmallest(arr, n);
    }
}
