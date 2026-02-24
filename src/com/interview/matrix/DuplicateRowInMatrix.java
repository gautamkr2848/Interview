package com.interview.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateRowInMatrix {

    public void findDuplicates() {
        int mat[][] = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0}};
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < mat.length; i++) {
            int decimal = 0;

            for (int j = 0; j < mat[i].length; j++) {
                decimal += mat[i][j] * Math.pow(2, j);
            }

            if (set.contains(decimal))
                System.out.println("Duplicate row found: Row #" + (i + 1));
            else
                set.add(decimal);

        }
    }
}
