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

    public static void generateAllSubStrings() {
        String s = "abcdef";

        // Outer loop: starting index
        for (int i = 0; i < s.length(); i++) {
            // Inner loop: ending index
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                System.out.println(sub);
            }
        }
    }
}
