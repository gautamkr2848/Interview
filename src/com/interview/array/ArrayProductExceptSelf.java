package com.interview.array;

import java.util.Arrays;

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

    public static void main(String[] args) {

        int[] a = {2, 0, 1, 9};
        Arrays.stream(a).map(x -> Arrays.stream(a).filter(y -> x != y).reduce(1, (y, z) -> y * z)).forEach(System.out::println);

        // (n2)

        System.out.println("In case 0 is present -----");
        long product = Arrays.stream(a)
                .asLongStream()
                .reduce(1, (x, y) -> x * y);
        long zeroCount = Arrays.stream(a).filter(n -> n == 0).count();
        Arrays.stream(a)
                .map(n -> {
                    if (zeroCount > 1) return 0;               // More than 1 zero → all results are 0
                    if (zeroCount == 1) return (n == 0) ? (int) Arrays.stream(a).filter(x -> x != 0).asLongStream().reduce(1, (x, y) -> x * y) : 0;
                    return (int) (product / n);               // Normal case
                }).forEach(System.out::println);

        // O(n)
    }
}
