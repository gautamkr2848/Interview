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
}
