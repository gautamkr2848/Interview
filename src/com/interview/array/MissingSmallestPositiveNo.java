package com.interview.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MissingSmallestPositiveNo {

    public int solution() {
        Integer A[] = { 0, 10, 2, -10, -20 };

        Set<Integer> distinct = new HashSet<>();
        Collections.addAll(distinct, A);

        int index = 1;
        while (true) {
            if (!distinct.contains(index)) {
                return index;
            }
            index++;
        }
    }

    static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int missing = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == missing) {
                missing++;
            } else if (arr[i] > missing) {
                break;
            }
        }
        return missing;
    }

}
