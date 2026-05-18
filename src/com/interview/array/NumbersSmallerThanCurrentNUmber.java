package com.interview.array;

import java.util.Arrays;

//Input: nums = [8,1,2,2,3]
//Output: [4,0,1,1,3]
//Explanation:
//For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
//For nums[1]=1 does not exist any smaller number than it.
//For nums[2]=2 there exist one smaller number than it (1).
//For nums[3]=2 there exist one smaller number than it (1).
//For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

public class NumbersSmallerThanCurrentNUmber {

    public static void main(String[] args){
        int[] a = {8,1,2,2,3};
        int n = a.length;
        int max = Arrays.stream(a).max().getAsInt();
        int[] tmp = new int[max+1];
        for(int i=0; i<n; i++){
            tmp[a[i]]++;
        }

        for(int i=1; i<=max; i++) {
            tmp[i] = tmp[i] + tmp[i-1];
        }

        int[] res = new int[a.length];
        for(int i=0; i<n; i++) {
            if(a[i] == 0)
                res[i] = 0;
            else
                res[i] = tmp[a[i]-1];
        }

        Arrays.stream(res).forEach(System.out::print);
    }
}
