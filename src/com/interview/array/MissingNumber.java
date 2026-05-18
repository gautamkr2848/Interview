package com.interview.array;

// a xor b
// 0 0 0
// 0 1 1
// 1 0 1
// 1 1 0

public class MissingNumber {

    // It XORs all numbers from 1 to n.
    // It XORs all elements in the array.
    // The result is the missing number, because XOR cancels out numbers that appear twice, leaving only the missing one.
    public static void missingNumber() {
        int[] a = {2, 5, 6, 4, 1, 3, 8};
        int n = 8;
        int xor = 0;

        for(int i=1; i<=n; i++)
            xor = xor ^ i;

        for(int i=0; i<a.length; i++)
            xor = xor ^ a[i];

        System.out.println(xor);
    }

    public static void main(String[] args) {
        missingNumber();
        System.out.println(1 ^ 1);      // 0
        System.out.println(1 ^ 2);      // 3
        System.out.println(1 ^ 1 ^ 2);  // 2
    }
}
