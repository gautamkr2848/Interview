package com.interview.stack.expressionEvaluation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class
Calculator {

    public static void main(String[] args){
        String s = "2*3+5";

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int i = 0;

        while (i < s.length()) {
            if(isOperator(s.charAt(i))) {
                operator.push(s.charAt(i));
            } else {
                int curr = Character.getNumericValue(s.charAt(i));

                if(!operator.isEmpty()) {

                    char c = operator.peek();
                    if (c == '*' || c == '/') {
                        operator.pop();
                        int tmp = c == '*' ? curr * operand.pop() : curr / operand.pop();
                        operand.push(tmp);
                    } else {
                        operand.push(curr);
                    }
                } else {
                    operand.push(curr);
                }
            }
            i++;
        }

        int value = 0;
        while (!operator.isEmpty()) {
            char c = operator.pop();
            int a = operand.pop();
            int b = operand.pop();

            value = evaluate(a, b, c);
        }
        System.out.println(value);
    }

    public static int evaluate(int a, int b, Character c) {
        switch (c) {
            case '+': return a + b;
            case '-' :return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static boolean isOperator(Character c) {
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        if(set.contains(c))
            return true;
        else
            return false;
    }
}
