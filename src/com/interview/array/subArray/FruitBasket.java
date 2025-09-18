package com.interview.array.subArray;

import java.util.HashMap;
import java.util.Map;

// You're visiting a farm with fruit trees arranged in a single row from left to right. Each tree produces a specific
// type of fruit, represented by an integer array fruits where fruits[i] indicates the fruit type of the i-th tree.
//
// You want to collect the maximum amount of fruit possible, but you must follow these rules:
//
// Two baskets only: You have exactly two baskets, and each basket can hold only one type of fruit (but unlimited quantity of that type).
//
// Sequential picking: Starting from any tree of your choice, you must pick exactly one fruit from every consecutive tree
// while moving to the right. You cannot skip trees.
//
// Stopping condition: You must stop picking when you encounter a tree with a fruit type that cannot fit in either of your
// baskets (i.e., it would be a third type of fruit).
//
// The goal is to find the maximum number of fruits you can collect by choosing the optimal starting position and picking
// fruits consecutively until you're forced to stop.

// Input: N = 3, K = 2, arr[] = { 2, 1, 2 }
//Output: 3
//Explanation: We can pick all of them
//
//Input: N = 6, K = 1, arr[]  = { 0, 1, 2, 2, 2, 2 }
//Output: 4
//Explanation: It’s optimal to pick from index 2(0-indexed) [2, 3, 4, 5].

public class FruitBasket {

    int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int i = 0;
        int maxFruits = 0;

        for (i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            // If basket has more than 2 type of fruits,  start emptying the basket
            while (map.size() > 2) {
                int fruitCount = map.get(fruits[j]);
                if (fruitCount == 1)
                    map.remove(fruits[j]);
                else
                    map.put(fruits[j], fruitCount - 1);
                j++;
            }

            maxFruits = Math.max(maxFruits, i - j + 1);
        }
        return maxFruits;
    }

}
