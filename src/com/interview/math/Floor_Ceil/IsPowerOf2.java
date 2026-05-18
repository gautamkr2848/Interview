package com.interview.math.Floor_Ceil;

// (n & (n - 1)) == 0

// a  b  a&b
// 0  0   0
// 0  1   0
// 1  0   0
// 1  1   1

public class IsPowerOf2 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor((Math.log(n) / Math.log(2))));
    }
}
