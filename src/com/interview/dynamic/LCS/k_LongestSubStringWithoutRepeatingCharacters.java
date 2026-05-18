package com.interview.dynamic.LCS;

//For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
//For “BBBB” the longest substring is “B”, with length 1.

public class k_LongestSubStringWithoutRepeatingCharacters {

    public int k_LongestSubStringWithoutRepeatingCharacters(){
        String str = "abcbde";
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

    // O(n) time complexity and O(256) i.e O(1) space complexity

    public static void main(String[] args) {
        k_LongestSubStringWithoutRepeatingCharacters obj = new k_LongestSubStringWithoutRepeatingCharacters();
        System.out.println("Longest Substring with Non-Repeated Characters: " + obj.k_LongestSubStringWithoutRepeatingCharacters());
    }
}
