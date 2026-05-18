package com.interview.greedy;

//sort all activities according to finish time

import java.util.Arrays;

public class ActivitySelection {

    public static void activitySelection(){
        int s[] =  {10, 12, 20};
        int f[] =  {20, 25, 30};

        Arrays.sort(f);

        int j=0;
        System.out.print(j+" ");

        for (int i = 1; i < s.length; i++){
            if (f[j] <= s[i]){
                System.out.print(i+" ");
                j = i;
            }
        }
    }

    public static void main(String[] args) {
        activitySelection();
    }
}
