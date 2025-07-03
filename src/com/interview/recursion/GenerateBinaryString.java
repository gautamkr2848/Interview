package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryString {

    public static void main(String[] args) {
        int length = 3;
        List<String> result = new ArrayList<>();
        generateStrings("", length, result);
        result.forEach(System.out::println);
    }

    private static void generateStrings(String prefix, int length, List<String> result) {
        if (length == 0) {
            result.add(prefix);
            return;
        }
        generateStrings(prefix + "0", length - 1, result);
        generateStrings(prefix + "1", length - 1, result);
    }
}
