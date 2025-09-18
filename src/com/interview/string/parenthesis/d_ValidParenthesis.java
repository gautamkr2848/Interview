package com.interview.string.parenthesis;

import java.util.Stack;

public class d_ValidParenthesis {

    public boolean checkValidString_2(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                open.push(i);
            } else if (arr[i] == '*') {
                star.push(i);
            } else {
                if(!open.isEmpty()) {
                    open.pop();
                } else if(!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while(!open.isEmpty() && !star.isEmpty()) {
            if(open.peek() > star.peek()) {
                return false;
            }
            open.pop();
            star.pop();
        }

        return open.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(*";
        System.out.println(checkValidString (s));
    }

    private static boolean test(String s, int index, int count) {
        if(count < 0)
            return false;
        if(index == s.length())
            return count == 0;

        if(s.charAt(index) == '(')
            return test(s, index+1, count+1);
        else if(s.charAt(index) == ')')
            return test(s, index+1, count-1);
        else if(s.charAt(index) == '*')
            return test(s, index+1, count+1) || test(s, index+1, count-1) || test(s, index+1, count);

        return false;
    }

/*
1. Initialize leftMin and leftMax to 0.
2. Iterate through each character in the string s.
3. If the character is '(', increment both leftMin and leftMax by 1.
4. If the character is ')', decrement both leftMin and leftMax by 1.
5. If the character is '*', decrement leftMin by 1 and increment leftMax by 1.
6. If leftMax becomes negative at any point, return False since it means there are more closing parentheses than opening ones.
7. If leftMin becomes negative, reset it to 0 since we can't have negative open parentheses count.
8. After iterating through the string, check if leftMin is 0. If it is, return True; otherwise, return False.
*/

    public static boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0)
                return false;

            if (leftMin < 0)
                leftMin = 0;
        }

        return leftMin == 0;
    }
}
