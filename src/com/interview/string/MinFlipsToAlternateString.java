package com.interview.string;

// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/description/

public class MinFlipsToAlternateString {

    public void minFlipsToAlternateString(){
        String s = "110101";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            // If there is 1 at even index positions
            if (i % 2 == 0 && s.charAt(i) == '1')
                count++;

            // If there is 0 at odd index positions
            if (i % 2 == 1 && s.charAt(i) == '0')
                count++;
        }
        System.out.println(Math.min(count, s.length() - count));
    }
}
