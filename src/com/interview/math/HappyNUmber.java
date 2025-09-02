package com.interview.math;

import java.util.HashSet;
import java.util.Set;

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
