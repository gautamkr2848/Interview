package com.interview.string.excel;

public class ColumnNameToNumber {

    public static void titleToNumber() {
        String s = "AB";
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        System.out.println(result);
    }

    public static void binaryToNumber() {
        String s = "101";
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 2 + s.charAt(i) - '0';
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        titleToNumber();
        binaryToNumber();
    }
}
