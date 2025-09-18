package com.interview;

import com.interview.greedy.NumberOfPlatforms;
import com.interview.tree.Node;

import java.util.*;
import java.util.stream.Collectors;

// -6, -3, -1, 2, 4, 5

// 1 4 9 16 25 36

public class Main {

    public static void main(String[] args) {

        int[] a = {2, 0, 1, 9};
        Arrays.stream(a).map(x -> Arrays.stream(a).filter(y -> x != y).reduce(1, (y, z) -> y * z)).forEach(System.out::println);

        System.out.println("-----");
        long product = Arrays.stream(a)
                .asLongStream()
                .reduce(1, (x, y) -> x * y);
        long zeroCount = Arrays.stream(a).filter(n -> n == 0).count();
        Arrays.stream(a)
                .map(n -> {
                    if (zeroCount > 1) return 0;               // More than 1 zero → all results are 0
                    if (zeroCount == 1) return (n == 0) ?
                            (int) Arrays.stream(a).filter(x -> x != 0).asLongStream().reduce(1, (x, y) -> x * y)
                            : 0;
                    return (int) (product / n);               // Normal case
                }).forEach(System.out::println);
    }
}