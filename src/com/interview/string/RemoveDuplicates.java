package com.interview.string;

import java.util.stream.Collectors;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {

        return str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String removeDuplicates_2(String str) {

        boolean[] seen = new boolean[256];

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {

            if (!seen[ch]) {

                seen[ch] = true;
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
