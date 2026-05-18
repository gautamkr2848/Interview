package com.interview.array.sort;

// Dutch National Flag problem

/*
Given N balls of colour red, white or blue arranged in a line in random order. You have to arrange all the balls such
that the balls with the same colours are adjacent with the order of the balls, with the order of the colours being red,
white and blue (i.e., all red coloured balls come first then the white coloured balls and then the blue coloured balls).
*/

public class h_Sort0_1_2 {

    //Initialise l=0 and r=n-1.
    //Inside a for loop, make sure i<=r and do the following steps:
    //If the i-th element is 0, swap it with arr[l] and increment l and i.
    //If the i-th element is 2, swap it with arr[r] and decrement r (not i). The loop will automatically check for the next updated value of arr[i].
    //If the i-th element is 1, simply increment i and continue.

    public static void sort0_1_2() {
        int[] arr = {1, 0, 0, 2, 1, 0, 2};
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0)        // current element is 0
                swap(arr, low++, mid++);
            else if (arr[mid] == 2)         // current element is 2
                swap(arr, mid, high--);
            else                            // current element is 1
                mid++;
        }

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        sort0_1_2();
    }
}
