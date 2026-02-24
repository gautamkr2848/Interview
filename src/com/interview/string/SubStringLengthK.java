package com.interview.string;

public class SubStringLengthK {

    public static void main(String[] args) {
        String s = "abcdef";
        int k = 3;

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            System.out.println(sub);
        }
    }
}
