package com.interview.dynamic.LCS;

//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//For “BBBB” the longest substring is “B”, with length 1.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class k_LongestSubStringWithNonRepeatedChar {

    public int k_LongestSubStringWithNonRepeatedChar(){
        String str = "geeksforgeeks";
        String test = "";
        int maxLength = -1;

        if (str.isEmpty())
            return 0;
        else if (str.length() == 1)
            return 1;

        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            if (test.contains(current))
                test = test.substring(test.indexOf(current) + 1);

            test = test + current;
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }

    public int k_LongestSubStringWithNonRepeatedChar_2(){
        String str = "geeksforgeeks";
        int maxLength = -1;
        Set<Character> charSet = new HashSet<>();

        for(Character c : str.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.clear();
            }
            charSet.add(c);
            maxLength = Math.max(charSet.size(), maxLength);
        }

        return maxLength;
    }

    // O(n) time complexity and O(256) i.e O(1) space complexity

    public static void main(String[] args) {
        k_LongestSubStringWithNonRepeatedChar obj = new k_LongestSubStringWithNonRepeatedChar();
        System.out.println("Longest Substring with Non-Repeated Characters: " + obj.k_LongestSubStringWithNonRepeatedChar());
        System.out.println("Longest Substring with Non-Repeated Characters (Method 2): " + obj.k_LongestSubStringWithNonRepeatedChar_2());
    }
}
