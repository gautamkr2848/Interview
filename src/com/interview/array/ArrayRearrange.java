package com.interview.array;

/*Given an array arr[] of size n where every element is in range from 0 to n-1.
        Rearrange the given array so that arr[i] becomes arr[arr[i]].
        This should be done with O(1) extra space.

        Examples:
        Input: arr[]  = {3, 2, 0, 1}
        Output: arr[] = {1, 0, 3, 2}*/

public class ArrayRearrange {

    public static void rearrange(long arr[], int n) {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] + (arr[(int)arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }

    public static void main(String[] args) {
        long[] arr  = {3, 2, 0, 1};
        rearrange(arr, 4);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
