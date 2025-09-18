package com.interview.dynamic;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
//Output: 4
//Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
//
//Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
//Output: 5
//Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.

public class LongestConsecutiveSubsequence {

    public int findLongestConseqSubseq(int arr[], int n) {
        Set<Integer> s = new HashSet<>();
        int maxLength = 0, currLength = 0;

        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        for (int i = 0; i < n; ++i) {
            if(s.contains(arr[i]-1))
                currLength++;
            else
                currLength = 1;

            if(maxLength < currLength)
                maxLength = currLength;
        }
        return maxLength;
    }

    //Time complexity: O(N)
    //Auxiliary space: O(N)
}
