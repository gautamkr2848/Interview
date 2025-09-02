package com.interview.string;

// Given a string that contains only three characters: {, }, and *. A * can represent either a {, a }, or an empty string.
// Write a function to check if the expression is valid.

public class ValidateString {

    public boolean isValidExpression(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '{') {
                minOpen++;
                maxOpen++;
            } else if (c == '}') {
                if (minOpen > 0) minOpen--;
                maxOpen--;
            } else if (c == '*') {
                // '*' can be '{', '}', or empty
                if (minOpen > 0) minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {
                // Too many closing braces
                return false;
            }
        }
        // Valid if all opens are matched
        return minOpen == 0;
    }
}
