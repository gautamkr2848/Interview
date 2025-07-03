package com.interview.recursion;

public class Power {

    public int power(int a, int b){
        if(b == 0)
            return 1;
        return a * power(a, b - 1);
    }

    public int power_2(int a, int b) {
        int result = 1;
        int base = a;
        int exponent = b;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }
}
