package com.interview.stack.nearest;

import java.util.Stack;

//Input: N = 7, price[] = [100 80 60 70 60 75 85]
//Output: 1 1 1 2 1 4 6

//nearest greater to left
public class a_1_StockSpan {

    public void calculateSpan(int price[], int n) {

        int[] S = new int[price.length];
        S[0] = 1;

        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            for (int j = i - 1; (j >= 0); j--) {
                if (price[i] >= price[j])
                    S[i]++;
            }
        }
    }

    // nearest greater to left
    public void stockSpan(){

        int price[] = { 10, 4, 5, 90, 120, 80 };
        Stack<Integer> st = new Stack<>();  //used to store only array indexes

        for (int i = 0; i < price.length; i++) {
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();

            if(st.empty())
                System.out.print(i + 1);
            else
                System.out.print(i - st.peek());

            st.push(i);
        }
    }

    // o/p - 1 1 2 4 5 1
}
