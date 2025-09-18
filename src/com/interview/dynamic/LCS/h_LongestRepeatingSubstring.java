package com.interview.dynamic.LCS;

/*
Longest repeating and non-overlapping substring

Input : str = "geeksforgeeks"
Output : geeks

Input : str = "aab"
Output : a

Input : str = "aabaabaaba"
Output : aaba

Input : str = "aaaaaaaaaaa"
Output : aaaaa

Input : str = "banana"
Output : an
         or na
 */

public class h_LongestRepeatingSubstring {

    public static void longestRepeatingSubstring(){
        String str = "aabaabaaba";
        int n = str.length();
        int T[][] = new int[n + 1][n + 1];
        int length = 0, end = n;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && T[i - 1][j - 1] < (j - i)) {
                    T[i][j] = 1 + T[i - 1][j - 1];
                    if(T[i][j] > length){
                        length = T[i][j];
                        end = i;
                    }
                } else {
                    T[i][j] = 0;
                }
            }
        }
        System.out.println(str.substring(end-length, end));
    }

    public static void main(String[] args) {
        longestRepeatingSubstring();
    }
}
