package com.interview.backtracking;

//Input: S = “ABC”
//Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

import java.util.*;

public class c_StringPermutation {

    public static void permutation(String str){
        List<List<String>> res = new ArrayList<>();
        backtrack(str, res, new ArrayList<>());
        System.out.println(res.toString());
    }

    public static void backtrack(String s, List<List<String>> res, List<String> curr) {
        if(s.length() == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<s.length(); i++) {

            if(curr.contains(String.valueOf(s.charAt(i))))
                continue;

            curr.add(String.valueOf(s.charAt(i)));
            backtrack(s, res, curr);
            curr.remove(curr.size()-1);
        }
    }

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
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        permutation("abc");
        permutation_dup("abb");
        permutation("abc", 0, 2);
    }

    static Set<String> set = new HashSet<>();
    public static void permutation(String str, int l, int r){
        if (l == r && !set.contains(str)) {
            System.out.print(str + " ");
            set.add(str);
            return;
        }

        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            permutation(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
