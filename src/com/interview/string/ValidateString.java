package com.interview.string;

// Given a string that contains only three characters: {, }, and *. A * can represent either a {, a }, or an empty string.
// Write a function to check if the expression is valid.

// If {, both minOpen and maxOpen increase.
// If }, minOpen decreases (if positive), and maxOpen decreases.
// If *, minOpen decreases (if positive, treating * as }), and maxOpen increases (treating * as {).
// If maxOpen drops below 0, there are too many } and the string is invalid. At the end, if minOpen is 0, all { can be matched, so the string is valid.

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
