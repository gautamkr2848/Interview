package com.interview.string.roman;

public class IntToRoman {

    public static void main(String[] args){

        int num = 1994;

        String[] THOUSANDS = {"", "M", "MM", "MMM"};
        String[] HUNDREDS  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] TENS      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ONES      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String s = THOUSANDS[(num % 10000) / 1000] +
                HUNDREDS[(num % 1000) / 100] +
                TENS[(num % 100) / 10] +
                ONES[num % 10 / 1];

        System.out.println(s);
    }
}
