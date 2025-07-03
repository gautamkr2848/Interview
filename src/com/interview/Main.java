package com.interview;

import com.interview.greedy.NumberOfPlatforms;
import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int key = 3;
        int low = 0;
        int high = arr.length - 1;

        while (low <=high) {
            int mid = low + (high - low) / 2;
        }


    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}