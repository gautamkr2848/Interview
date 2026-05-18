package com.interview.math;

import java.util.HashSet;
import java.util.Set;

// A happy number is a number which eventually reaches 1 when replaced by the sum of the square of each digit.
// Example: 19 is a happy number
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

public class HappyNUmber {

    public static void isHappyNumber(){
        int n = 18;
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            int sum = 0;
            while(n != 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if(set.contains(sum)){
                System.out.println(false);
                return;
            }
            set.add(sum);
            n = sum;
        }
        System.out.println(true);
    }

    public static void main(String[] args) {
        isHappyNumber();
    }
}
