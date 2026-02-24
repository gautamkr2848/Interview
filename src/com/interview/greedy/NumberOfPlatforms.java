package com.interview.greedy;

import java.util.Arrays;

public class NumberOfPlatforms {

    public void numberOfPlatforms(){

        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, count = 1;

        for (int i=1, j=0; i < arr.length && j < arr.length;) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else {
                plat_needed--;
                j++;
            }

            count = Math.max(count, plat_needed);
        }
        System.out.println(count);
    }
}
