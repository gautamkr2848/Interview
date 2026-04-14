package com.interview.dynamic.printSubset;

import java.util.ArrayList;
import java.util.List;

//Input : ab
//Output : AB Ab ab aB

public class LetterCasePermutation {

    public static void main(String[] args) {
        permute("abc");
    }

    public static void permute(String input) {
        int n = input.length();

        input = input.toLowerCase();

        for (int i = 0; i < Math.pow(2,n); i++) {
            char combination[] = input.toCharArray();

            for (int j = 0; j < n; j++) {
                if ((i & (int)Math.pow(2, j)) > 0)
                    combination[j] = Character.toUpperCase(combination[j]);
            }

            System.out.print(String.valueOf(combination) + " ");
        }
    }
}
