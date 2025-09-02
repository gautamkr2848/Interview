package com.interview.dynamic.LCS;

// Given two strings s1 and s2 and below operations that can be performed on s1. The task is to find the minimum number
// of edits (operations) to convert 's1' into 's2'.
//
// Insert: Insert any character before or after any index of s1
// Remove: Remove a character of s1
// Replace: Replace a character at any index of s1 with some other character.

public class EditDistance {

    // Driver Code
    public static void main(String args[]) {
        String str1 = "GEEXSFRGEEKKS";
        String str2 = "GEEKSFORGEEKS";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
    }

    static int editDist(String str1, String str2, int m, int n) {
        if (m == 0)     // If first string is empty, the only option is to insert all characters of second string into first
            return n;

        if (n == 0)         // If second string is empty, the only option is to remove all characters of first string
            return m;

        // If last characters of two strings are same, nothing much to do. Get the count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return 1 + editDist(str1, str2, m - 1, n - 1);
        else
        // If last characters are not same, consider all three operations on last character of first
        // string, recursively compute minimum cost for all three operations and take minimum of three values.
            return  min(editDist(str1, str2, m, n - 1), // Insert
                    editDist(str1, str2, m - 1, n), // Remove
                    editDist(str1, str2, m - 1, n - 1) // Replace
        );
    }

    public static int minDis(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return dp[n][m] = minDis(s1, s2, n - 1, m - 1, dp);
        else
            return dp[n][m] = 1 + min(minDis(s1, s2, n, m - 1, dp), minDis(s1, s2, n - 1, m, dp), minDis(s1, s2, n - 1, m - 1, dp));
    }

    public static int editDistDP(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)     // If first string is empty, only option is  to insert all characters of second string
                    dp[i][j] = j; // Min. operations = j
                else if (j == 0)        // If second string is empty, only option is  to remove all characters of second string
                    dp[i][j] = i; // Min. operations = i
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))      // If last characters are same, ignore last char and recur for remaining string
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else            // If the last character is different,  consider all possibilities and find the minimum
                    dp[i][j] = min(
                            dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }

        return dp[m][n];
    }

    static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }
}
