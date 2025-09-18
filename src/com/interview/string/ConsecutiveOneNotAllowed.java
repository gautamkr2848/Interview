package com.interview.string;

/*Input: N = 3, Output: 5
The 5 strings are 000, 001, 010, 100, 101*/

public class ConsecutiveOneNotAllowed {

    private static void countStrings(int n) {
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        countStrings(5);
    }
}
