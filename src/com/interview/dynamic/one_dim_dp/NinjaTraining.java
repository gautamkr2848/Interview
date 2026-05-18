package com.interview.dynamic.one_dim_dp;

// Geek is going for n day training program. He can perform any one of these three activities Running, Fighting, and
// Learning Practice. Each activity has some point on each day. As Geek wants to improve all his skills, he can't do
// the same activity on two consecutive days. Help Geek to maximize his merit points as you are given a 2D array of
// points points, corresponding to each day and activity.

//Input: n = 3
//points = [[1,2,5],[3,1,1],[3,3,3]]
//Output: 11
public class NinjaTraining {

    public int getMaxPoints(int[][] a, int lastIndex, int n) {
        int max = Integer.MIN_VALUE;
        if(n == 0) {
            for(int i=0; i<3; i++) {
                if(i != lastIndex)
                    max = Math.max(max, a[0][i]);
            }
            return max;
        }

        max = Integer.MIN_VALUE;
        for(int i=0; i<3; i++) {
            if(i != lastIndex) {
                max = Math.max(max, getMaxPoints(a, i, n-1) + a[n][i]);
            }
        }
        return max;
    }
}
