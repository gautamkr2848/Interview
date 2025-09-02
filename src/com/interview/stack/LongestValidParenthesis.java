package com.interview.stack;

import java.util.Stack;

public class LongestValidParenthesis {

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
        LongestValidParenthesis lvp = new LongestValidParenthesis();
        String test = "()";
        System.out.println("Longest valid parentheses length: " + lvp.longestValidParentheses(test)); // Output: 6
    }
}
