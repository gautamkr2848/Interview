package com.interview.string;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(getActual_2("ab#c").equals(getActual_2("ad#c"))); // true
        System.out.println(getActual_2("ab##").equals(getActual_2("c#d#"))); // true
        System.out.println(getActual_2("ca#b").equals(getActual_2("cb"))); // true
        System.out.println(getActual_2("a##c").equals(getActual_2("#a#c"))); // true
    }

    private static String getActual_2(String str) {

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                sb.append(ch);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.toString();
    }
}
