package com.interview.backtracking;

//Input: S = “ABC”
//Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

import java.util.*;

public class c_StringPermutation {

    public static void permutation_dup(String str){
        List<List<String>> res = new ArrayList<>();

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        backtrack_dup(String.valueOf(arr), res, new ArrayList<>(), new boolean[str.length()]);
        System.out.println(res.toString());
    }

    public static void backtrack_dup(String s, List<List<String>> res, List<String> curr, boolean[] used) {

        if(s.length() == curr.size() && !res.contains(curr)) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<s.length(); i++) {

            if(used[i]) continue;

            used[i] = true;
            curr.add(String.valueOf(s.charAt(i)));
            backtrack_dup(s, res, curr, used);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        permutation_dup("abc");
    }
}
