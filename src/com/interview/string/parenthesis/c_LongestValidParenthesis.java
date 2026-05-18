package com.interview.string.parenthesis;

import java.util.Stack;

public class c_LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // base for length calc
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // reset base
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        c_LongestValidParenthesis lvp = new c_LongestValidParenthesis();
        String test = "()())(())";
        System.out.println("Longest valid parentheses length: " + lvp.longestValidParentheses(test));
        System.out.println("Longest valid parentheses length: " + lvp.longestValidParentheses2(test));
    }

    public int longestValidParentheses2(String s) {
        int left = 0, right = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLength = Math.max(maxLength, left * 2);
            else if (right > left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLength = Math.max(maxLength, left * 2);
            else if (left > right)
                left = right = 0;
        }
        return maxLength;
    }
}
