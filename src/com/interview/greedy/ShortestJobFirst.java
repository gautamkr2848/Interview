package com.interview.greedy;

import java.util.Arrays;

//

public class ShortestJobFirst {

    public static int solve(int bt[]) {
        Arrays.sort(bt);
        int wt=0, tt=0;

        for(int i=0; i<bt.length; i++){
            wt = wt + tt;
            tt = tt + bt[i];
        }
        return (wt/bt.length);
    }
}
