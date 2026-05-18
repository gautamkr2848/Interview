package com.interview.stack.nearest;

//  1   3   2   4   =>      3   4   4   -1

import java.util.Stack;

public class c_NearestGreaterElementOnRight {

    public void nextLargestElementRight(){
        int[] a = {1, 3, 2, 4};
        System.out.print( "-1, ");
        int n = a.length;

        for(int i=n-2; i>=0; i--){
            int j;
            for(j=i+1; j<n; j++){
                if(a[j] > a[i]) {
                    System.out.print(a[j] + ", ");
                    break;
                }
            }

            if(j == n)
                System.out.print("-1, ");
        }
    }

    public void nextLargestElementRight_2(){
        int[] a = {1, 3, 2, 4};
        Stack<Integer> s = new Stack<>();
        int n = a.length;

        for(int i=n-1; i>=0; i--){
            while (!s.empty() && s.peek() <= a[i])
                s.pop();

            if(s.empty())
                System.out.print("-1, ");
            else
                System.out.print(s.peek()+ ", ");

            s.push(a[i]);
        }
    }
}
