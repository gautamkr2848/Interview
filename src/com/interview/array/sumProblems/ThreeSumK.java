package com.interview.array.sumProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSumK {

    public static void findTriplets(int arr[], int n) {
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                int sum = x + arr[l] + arr[r];
                if (sum == 0) {
                    System.out.print(x + " ");
                    System.out.print(arr[l] + " ");
                    System.out.print(arr[r] + " ");
                    System.out.print("\n");
                    l++;
                    r--;
                } else if (sum < 0)
                    l++;
                else
                    r--;
            }
        }
    }

    public static void main(String[] args) {
        findTriplets(new int[]{-3, 2, 1, 4}, 4);
    }
}
