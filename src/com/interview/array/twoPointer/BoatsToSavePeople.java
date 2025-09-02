package com.interview.array.twoPointer;

// You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where
// each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the
// sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.

public class BoatsToSavePeople {

    public void numberOfBoats(){
        int people[] = {3, 2, 2, 1};
        int limit = 3;
        int boats = 0;
        int i = 0, j = people.length - 1;

        java.util.Arrays.sort(people);

        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            boats++;
        }

        System.out.println(boats);
    }
}
