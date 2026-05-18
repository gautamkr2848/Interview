package com.interview.math.Floor_Ceil;

public class PerfectSquare {

    public boolean isPerfectSquare(int x) {
        if (x >= 0) {
            int tmp = (int)Math.sqrt(x);
            return ((tmp * tmp) == x);
        }
        return false;
    }

    public void checkperfectsquare(int n) {
        if (Math.ceil((double)Math.sqrt(n)) == Math.floor((double)Math.sqrt(n)))
            System.out.print("perfect square");
        else
            System.out.print("not a perfect square");
    }
}
