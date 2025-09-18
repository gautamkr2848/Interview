package com.interview.trie;

public class LongestCommonSuffix {

    public static String longestCommonSuffix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder suffix = new StringBuilder();
        int minLength = Integer.MAX_VALUE;

        // Find the minimum length string
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // Compare characters from the end
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(strs[0].length() - 1 - i);
            for (String str : strs) {
                if (str.charAt(str.length() - 1 - i) != currentChar) {
                    return suffix.reverse().toString();
                }
            }
            suffix.append(currentChar);
        }
        return suffix.reverse().toString();
    }

    public static void main(String[] args) {
        String[] test1 = {"running", "jogging", "walking"};
        String[] test2 = {"apple", "banana", "grape"};
        String[] test3 = {"interview", "view", "review"};

        System.out.println("Longest Common Suffix of test1: " + longestCommonSuffix(test1)); // Output: "ing"
        System.out.println("Longest Common Suffix of test2: " + longestCommonSuffix(test2)); // Output: ""
        System.out.println("Longest Common Suffix of test3: " + longestCommonSuffix(test3)); // Output: "view"
    }
}
