package com.interview;

import com.interview.greedy.NumberOfPlatforms;
import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

// -6, -3, -1, 2, 4, 5

// 1 4 9 16 25 36

public class Main {

    public static void main(String[] args) {

        String s = "geeksforgeeks";

        int left = 0;
        int right = s.length()-1;

        int volLeft = -1;
        int volRight = -1;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        while(left <= right) {
            if(volLeft == -1 && vowels.contains(s.charAt(left)))
                volLeft = left;

            if(volRight == -1 && vowels.contains(s.charAt(right)))
                volRight = right;

            if(volLeft != -1 && volRight != -1) {
                char c = s.charAt(volLeft);
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(volLeft, s.charAt(volRight));
                sb.setCharAt(volRight, c);
                s = sb.toString();
                volLeft = -1;
                volRight = -1;
            }

            left++;
            right--;
        }

        System.out.println(s);
    }
}