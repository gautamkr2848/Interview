package com.interview.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from
‘start’ to ‘target’ if it exists, such that adjacent words in the chain only differ by one character and each word in
the chain is a valid word i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in
dictionary and length of all dictionary words is same.

Example:

    Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}, start = TOON, target = PLEA
    Output: 7
    Explanation: TOON – POON – POIN – POIE – PLIE – PLEE – PLEA

    Input: Dictionary = {ABCD, EBAD, EBCD, XYZA}, start = ABCV, target = EBAD
    Output: 4
    Explanation: ABCV – ABCD – EBCD – EBAD



Approach:

Start from the given start word.
Push the word in the queue
Run a loop until the queue is empty
Traverse all words that adjacent (differ by one character) to it and push the word in a queue (for BFS)
Keep doing so until we find the target word or we have traversed all words.

Time Complexity: O(N² * M), where N is the number of words in the dictionary and M is the size of the string
Auxiliary Space: O(M * N)
*/

public class WordLadder {

    public int shortestChainLen(String start, String target, Set<String> dictionary) {
        if(start == target)
            return 0;

        if (!dictionary.contains(target))
            return 0;

        int level = 0, n = start.length();     // To store the current chain length and the length of the words

        Queue<String> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {

                char[] word = q.poll().toCharArray();

                for (int pos = 0; pos < n; pos++) {
                    char orig_char = word[pos];     // To retain the original character at the current position

                    for (char c = 'a'; c <= 'z'; c++) {     // Replace the current character with  every possible lowercase alphabet
                        word[pos] = c;

                        if (String.valueOf(word).equals(target))        // If the new word is equal to the target word
                            return level + 1;

                        if (!dictionary.contains(String.valueOf(word)))
                            continue;

                        dictionary.remove(String.valueOf(word));    // Remove the word from the set if it is found in it
                        q.add(String.valueOf(word));        // And push the newly generated word  which will be a part of the chain
                    }

                    word[pos] = orig_char;      // Restore the original character  at the current position
                }
            }
        }

        return 0;
    }
}

// Add start word in a queue
// Iterate while queue is not empty
// Take queue size, run a for loop on this size
// Poll queue element and put in a char array
// Run a loop over start word length
// Take original character from char array
// Run a loop from char a to z
// change character one by one within char array based on position
// After changing, if word equals to target then return length
// Else check the word exist in dictionary
    // if it's not in dictionary, continue
// Remove newly generated word from dictionary & Push it into the queue
// Restore the original character  at the current position
