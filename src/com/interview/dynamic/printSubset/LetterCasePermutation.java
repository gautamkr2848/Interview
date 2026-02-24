package com.interview.dynamic.printSubset;

import java.util.ArrayList;
import java.util.List;

//Input : ab
//Output : AB Ab ab aB

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList();
        dfs(S.toLowerCase().toCharArray(), ans, 0, S.length());
        return ans;
    }

    private static void dfs(char[] arr, List ans, int i, int len) {

        if(i == len) {
            ans.add(new String(arr));
            return;
        }

        dfs(arr, ans, i+1, len);
        if (Character.isLetter(arr[i])) {
            arr[i] = Character.toUpperCase(arr[i]);
            dfs(arr, ans, i+1, len);
            arr[i] = Character.toLowerCase(arr[i]);
        }
    }

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
