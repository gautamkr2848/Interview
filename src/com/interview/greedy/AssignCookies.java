package com.interview.greedy;

import java.util.Arrays;

// Given two arrays, greed[] and cookie[] such that greed[i] denotes the minimum cookie size wanted by ith child and
// cookie[i] denotes the size of ith cookie, the task is to find the maximum number of children that can be satisfied
// by assigning them cookies, with each child getting at most 1 cookie.
//
// Note: A child will be satisfied if he is assigned a cookie of size at least equal to his greed. In other words, the
// ith child will be satified with jth cookie only if greed[i] <= cookie[j].

// greed [ ] = {1, 2, 3}
//sz [ ] = {1, 1}
//Output: 1

// greed [ ] = {1, 2}, j
//sz [ ] = {1, 2, 3}, i
//Output: 2

public class AssignCookies {

    static int maxChildren(int N,int M,int childNeed[], int biscuitSize[]) {
        Arrays.sort(biscuitSize);
        Arrays.sort(childNeed);

        int i=0, j=0;

        while(i<M && j<N) {
            if(biscuitSize[i] >= childNeed[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j;
    }

}
