package com.interview.dynamic.one_dim_dp;

/*123 => ABC, LC, AW*/

public class DecodeNoOfWays {

    // s =    1 2 2 0 1 6

    // dp = 1 1 2 3 2 2 4

    // formula dp[i] = dp[i-1]  // if single digit is valid
                        // + dp[i-2]    // if last 2 digits are valid

    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1)
                dp[i] += dp[i - 1];

            if (twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
