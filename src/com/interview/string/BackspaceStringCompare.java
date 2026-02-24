package com.interview.string;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(getActual("ab#c").equals(getActual("ad#c"))); // true
        System.out.println(getActual("ab##").equals(getActual("c#d#"))); // true
        System.out.println(getActual("ca#b").equals(getActual("cb"))); // false
        System.out.println(getActual("a##c").equals(getActual("#a#c"))); // true
    }

    private static String getActual(String s) {
        StringBuilder actualString = new StringBuilder();
        Boolean hashFound = false;
        for(int i = s.length() - 1; i>=0 ; i--) {
            if(hashFound) {
                hashFound = false;
                continue;
            }

            if(s.charAt(i) == '#') {
                hashFound = true;
            } else {
                actualString.insert(0, s.charAt(i));
            }
        }
        return actualString.toString();
    }
}
