package com.interview.string;

public class StringCombination {

    // print all the subsets of a string
    public void StringCombination(){
        String s = "abc";
        char set[] = s.toCharArray();
        int n = set.length;

        for (int i = 0; i < Math.pow(2,n); i++) {
            for (int j = 0; j < n; j++){
                if ((i & (int)(Math.pow(2,j))) > 0)
                    System.out.print(set[j] + " ");
            }

            System.out.println(" ");
        }
    }
}
