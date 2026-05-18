package com.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static void groupAnagram(){
        String arr[] = { "cat", "dog", "tac", "god", "act" };
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1)
                System.out.print(values.toString());
        }
    }

    public static void main(String[] args) {
        groupAnagram();
    }
}
