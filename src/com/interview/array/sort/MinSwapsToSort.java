package com.interview.array.sort;

// no. of swaps to sort the array

import java.util.*;

public class MinSwapsToSort {

    public void arrayInversion_1(){
        int[] a = {2, 4, 1, 5};
        int count = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j])
                    count++;
        System.out.println("Inversion count "+ count);
    }

    public int minSwaps(int arr[]){
        int count = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put(arr[i], i);

        for (int i = 0; i < N; i++){
            if (arr[i] != temp[i]){
                count++;
                int val = arr[i];

                swap(arr, i, map.get(temp[i]));

                map.put(val, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return count;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
