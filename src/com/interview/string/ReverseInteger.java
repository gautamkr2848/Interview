package com.interview.string;

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
// signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

public class ReverseInteger {

    public void reverseInteger(int n) {
        boolean isNegative = false;
        String s = String.valueOf(n);
        if(n < 0) {
            isNegative = true;
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }

        String reversedStr = isNegative ? "-" + sb.toString() : sb.toString();
        long reversed = Long.parseLong(reversedStr, 10);

        if(reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(reversed);
        }
    }
}
