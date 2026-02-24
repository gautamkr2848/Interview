package com.interview.string;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubstring {

    public static void distinctSubString(){
        String s = "abc";
        int n = s.length();
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.toString());
    }

    public static void distinctSubString2(){
        String s = "abc";
        int n = s.length();
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i+1; j<=n; j++) {
                sb = sb.append(s.charAt(j-1));
                set.add(sb.toString());
            }
        }

        System.out.println(set.toString());
    }

    public static void main(String[] args) {
        distinctSubString();
        distinctSubString2();
    }
}
