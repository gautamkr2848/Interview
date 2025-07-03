package com.interview.array;

public class ArrayProductExceptSelf {

    public int[] productExceptSelf(int[] a) {
        int prod = 1;
        int zeroCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                zeroCount++;
            else
                prod = prod * a[i];
        }

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            if (zeroCount > 1)
                res[i] = 0;
            else if (zeroCount == 0)
                res[i] = (prod / a[i]);
            else if (zeroCount == 1 && a[i] != 0)
                res[i] = 0;
            else // if(zeroCount == 1 && a[i] == 0)
                res[i] = prod;
        }
        return res;
    }
}
