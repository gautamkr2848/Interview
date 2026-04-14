package com.interview.dynamic.printSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// For n ≤ 20 → normal subset
// For n ≤ 40 → Meet in the Middle
// For n ≥ 100 → DP / approximation

public class CountTriplets {

    public static void countTriplets(){
        int[] A = {0, 1, -1, 2, -2, 3};
        int n = A.length;
        int count = 0 ;
        for (int i = 0; i < Math.pow(2,n); i++){
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (int)Math.pow(2,j)) > 0) {
                    sum = sum + A[j];
                    list.add(A[j]);
                }
            }
            if(sum == 0 && list.size() == 3) {
                System.out.println(list.toString());
                count++;
            }
        }
        System.out.println("Total subset with 0 sum: "+ count);
    }

    public int countTriplets(int n, int sum) {
        int[] arr = {0, 1, -1, 2, -2, 3};
        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;

            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;

                    // Else move left corner
                else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans = ans + (k - j);
                    j++;
                }
            }
        }
        return ans;
    }
}
