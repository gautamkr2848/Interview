package com.interview.stack.nearest;

//4, 8, 5, 2, 25    =>  2, 5, 2, -1, -1

import java.util.Stack;

public class d_NearestSmallerNumberOnRight {

    public void nearestSmallerNumberOnRight(){
        int[] a = {4, 8, 5, 2, 25};
        int n = a.length;
        System.out.print( "-1, ");

        for(int i=n-2; i>=0; i--){
            int j;
            for(j=i+1; j<n; j++){
                if(a[j] < a[i]) {
                    System.out.print(a[j] + ", ");
                    break;
                }
            }

            if(j == n)
                System.out.print("-1, ");
        }
    }

    //Time complexity of the above solution is O(n2).
    //Space Complexity: O(1)

    public void nearestSmallerNumberOnRight_2(){
        int[] a = {4, 8, 5, 2, 25};
        int n = a.length;
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while (!s.empty() && s.peek() >= a[i])
                s.pop();

            if(s.empty())
                System.out.print("-1, ");
            else
                System.out.print(s.peek()+ ", ");

            s.add(a[i]);
        }
    }

    //Time complexity of the above solution is O(n).
    //Space Complexity: O(n)
}
