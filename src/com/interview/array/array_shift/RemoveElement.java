package com.interview.array.array_shift;

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the
// elements may be changed. Then return the number of elements in nums which are not equal to val.

import java.util.Arrays;

public class RemoveElement {

    public static void removeElements() {
        int[] arr = {5, 5, 1, 4, 5, 3, 5, 8};
        int val = 5;

        int i=0;
        for(int j=0; j<arr.length; j++){
            if(arr[j] != val){
                arr[i] = arr[j];
                i++;
            }
        }

        for(int k=0; k<i; k++)
            System.out.print(arr[k] + " ");
    }

    public static void removeElements_2() {
        int[] arr = {5, 5, 1, 4, 5, 3, 5, 8};
        int val = 5;
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            if(arr[left] == val) {
                if(arr[right] != val) {
                    int tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                    right--;
                } else {
                    right--;
                    left--;
                }
            }
            left++;
        }

        for(int i=0; i<left; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 1, 4, 5, 3, 5, 8};
        int val = 5;

        Arrays.stream(arr).filter(x -> x != val).forEach(System.out::print);
        System.out.println();
        Arrays.stream(arr).distinct().forEach(System.out::print);
        System.out.println();
        removeElements();
        System.out.println();
        removeElements_2();
    }
}
