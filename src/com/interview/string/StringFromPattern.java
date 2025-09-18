package com.interview.string;

import java.util.ArrayList;
import java.util.List;

//String input = "1??0?101";

//Output:
//10000101
//10001101
//10100101
//10101101
//11000101
//11001101
//11100101
//11101101

public class StringFromPattern {

    public void generateString(String input, int index, String result, List<String> output){
        if(index == input.length()){
            output.add(result);
            return;
        }

        char ch = input.charAt(index);
        if(ch == '?'){
            generateString(input, index + 1, result + '0', output);
            generateString(input, index + 1, result + '1', output);
        } else {
            generateString(input, index + 1, result + ch, output);
        }
    }

    // (O(2^k)), where (k) is the number of ? characters

    // n = Count all ? character
    // Generate all binary numbers whose length is n
    // For each binary number, replace ? with the digits of the binary number
    public void generateStringIterative(String input){
        int count = 0;
        for(char ch : input.toCharArray()){
            if(ch == '?')
                count++;
        }

        int totalCombinations = (1 << count); // 2^count
        for(int i=0; i<totalCombinations; i++){
            StringBuilder sb = new StringBuilder(input);
            int bitIndex = 0;
            for(int j=0; j<sb.length(); j++){
                if(sb.charAt(j) == '?'){
                    char bit = ((i & (1 << bitIndex)) != 0) ? '1' : '0';
                    sb.setCharAt(j, bit);
                    bitIndex++;
                }
            }
            System.out.println(sb.toString());
        }
    }

    // Time Complexity: O(2^k * n), where k is the number of '?' characters and n is the length of the input string.
}
