package com.interview.dynamic.printSubset;

import java.util.*;

public class MenInTheMiddle {

    // 2^(n/2)

    // For every right subset with sum s: required = K - s

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 10;

        printSubsets(arr, k);
    }

    static void printSubsets(int[] arr, int k) {

        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        Map<Integer, List<List<Integer>>> leftMap = generate(left);

        generateRight(right, k, leftMap);
    }

    static Map<Integer, List<List<Integer>>> generate(int[] arr) {

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {

            int sum = 0;
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    list.add(arr[j]);
                }
            }

            map.computeIfAbsent(sum, x -> new ArrayList<>()).add(list);
        }

        return map;
    }

    static void generateRight(int[] arr, int k,
                              Map<Integer, List<List<Integer>>> leftMap) {

        int n = arr.length;

        for (int i = 0; i < (1 << n); i++) {

            int sum = 0;
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    list.add(arr[j]);
                }
            }

            int required = k - sum;

            if (leftMap.containsKey(required)) {

                for (List<Integer> leftSubset : leftMap.get(required)) {

                    List<Integer> result = new ArrayList<>(leftSubset);
                    result.addAll(list);

                    System.out.println(result);
                }
            }
        }
    }
}