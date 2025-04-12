package com.interview;

import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("11111111");
        try {
            System.out.println("2222222");
            int i = 10/0;
            System.out.println("3333333");
        } catch (Exception e) {
            System.out.println("4444444");
            throw e;
        } finally {
            System.out.println("5555555");
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