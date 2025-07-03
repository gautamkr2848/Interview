package com.interview.dynamic.LCS;

// All possible ways => recurssion

// s = abdefcd
// p = ab*cd

// For '*', i stands for p, and j stands for s
// a. * matches 0 characters, don't increase i, only increase j
// b. * matches 1+ character, increase i, don't increase j


public class WildcardPatternMatching {

    // start i = 0, j = 0
    public static boolean wildPattren(String s, String p, int i, int j) {

        if(i == s.length() && j == p.length())
            return true;

        if(i == s.length()) {
            for(int k=j; k<p.length(); k++){
                if(p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if(j == p.length())
            return false;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return wildPattren(s, p, i+1, j+1);
        else if(p.charAt(j) == '*')
            return wildPattren(s, p, i+1, j) ||  wildPattren(s, p, i, j+1);
        else
            return false;
    }

    // Time Complexity - O(2 pow n)

    public static boolean wildcardPatternMatching(String str, String pattern, int m, int n){

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++)
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else
                    dp[i][j] = false;
            }
        }

        return dp[m][n];
    }

    // Time Complexity - O(m*n)

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "ba*a?";

        int m = str.length();
        int n = pattern.length();

        System.out.println(wildcardPatternMatching(str, pattern, m, n));
        System.out.println(wildPattren(str, pattern, 0, 0));

    }

    static boolean isMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0, j = 0, startIndex = -1, match = 0;

        while (i < n) {
            if (j < m && (pattern.charAt(j) == '?' || pattern.charAt(j) == text.charAt(i))) {
                i++;
                j++;
            }
            // If the pattern has a '*' character, mark the
            // current position in the pattern and the text
            // as a proper match.
            else if (j < m && pattern.charAt(j) == '*') {
                startIndex = j;
                match = i;
                j++;
            }
            // If we have not found any match and no '*'
            // character, backtrack to the last '*'
            // character position and try for a different
            // match.
            else if (startIndex != -1) {
                j = startIndex + 1;
                match++;
                i = match;
            }
            // If none of the above cases comply, the
            // pattern does not match.
            else {
                return false;
            }
        }

        // Consume any remaining '*' characters in the given
        // pattern.
        while (j < m && pattern.charAt(j) == '*') {
            j++;
        }

        // If we have reached the end of both the pattern
        // and the text, the pattern matches the text.
        return j == m;
    }
}
