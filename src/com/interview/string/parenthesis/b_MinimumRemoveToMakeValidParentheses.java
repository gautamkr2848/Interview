package com.interview.string.parenthesis;

/*
Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */

import java.util.Stack;

public class b_MinimumRemoveToMakeValidParentheses {

    public static String minRemoveToMakeValid(String s) {

        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == '(')
                stack.push(i);
            else if(arr[i] == ')' && !stack.isEmpty())
                stack.pop();
            else if(arr[i] == ')')
                arr[i] = ' ';
        }

        // Remove excess '(' where we found them (stored in the stack)
        while(!stack.isEmpty()) {
            int index = stack.pop();
            arr[index] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            if (ch != ' ') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a)b((c)()"));
    }
}
