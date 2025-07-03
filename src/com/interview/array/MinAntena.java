package com.interview.array;

import java.util.Arrays;

/*
Algorithm:-

Given a map of the city and the network range, the task is to determine the minimum number of the tower so that every
house is within range of at least one tower. Each tower must be installed on top of an existing house.

1. First, sort all the elements.
2. Count only once and then traverse till its middle house.
3. After this again traverse till tower range.
4. Again repeat 1, 2, 3 steps till all the houses are covered.
*/

public class MinAntena {

    public static void minAntena(){
        int house[] = { 7, 2, 4, 6, 5, 9, 12, 11 };
        int range = 2;
        int n = house.length;

        Arrays.sort(house);

        int count = 0;
        int i=0;

        while(i < n){
            count++;

            int tmp = house[i] + range;
            while (i<n && house[i] <= tmp)
                i++;
            i--;
            tmp = house[i] + range;
            while (i<n && house[i] <= tmp)
                i++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        minAntena();
    }
}
