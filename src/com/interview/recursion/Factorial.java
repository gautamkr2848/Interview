package com.interview.recursion;

public class Factorial {

    public int factorial(int n){
        if(n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    //Time Complexity: O(n)
}
