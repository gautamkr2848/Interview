package com.interview.string.parenthesis;

import java.util.Stack;

public class a_ParenthesesCheck {

    public void parenthesesCheck(){
        String s = "[3+{2*(1+7)}][]";
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!(isANumber(s.charAt(i)) || isAOperator(s.charAt(i)))) {
                if (stk.size() > 0 && ((s.charAt(i) == ')' && stk.peek() == '(')
                        || (s.charAt(i) == '}' && stk.peek() == '{')
                        || (s.charAt(i) == ']' && stk.peek() == '[')))
                    stk.pop();
                else
                    stk.push(s.charAt(i));
            }
        }
        if(stk.size() == 0)
            System.out.println("OKK");
        else
            System.out.println("WRONG");
    }

    public static Boolean isANumber(Character c){
        if(0 <= Character.getNumericValue(c) &&
            9 >= Character.getNumericValue(c))
            return true;
        else
            return false;
    }

    public static Boolean isAOperator(Character c){
        if(c =='+' || c == '-' || c == '*' || c == '/')
            return true;
        else
            return false;
    }
}
