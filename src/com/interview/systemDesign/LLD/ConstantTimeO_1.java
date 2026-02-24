package com.interview.systemDesign.LLD;

import java.util.*;

// Design a data structure that supports insert, delete, search and getRandom in constant time

public class ConstantTimeO_1 {

    List<Integer> list;
    Map<Integer, Integer> map;  //key as data and value as list index

    public ConstantTimeO_1() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    void add(int x) {
        if (map.get(x) != null)
            return;

        int s = list.size();
        list.add(x);
        map.put(x, s);
    }

    void remove(int x) {
        Integer index = map.get(x);
        if (index == null)
            return;
        map.remove(x);

        // Swap element with last element so that remove from
        // list[] can be done in O(1) time
        int size = list.size();
        Integer last = list.get(size-1);
        Collections.swap(list, index,  size-1);
        list.remove(size-1);     // Remove last element
        map.put(last, index);     // Update hash table for new index of last element
    }

    int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);  // Return element at randomly picked index
    }

    Integer search(int x) {
        return list.get(map.get(x));
    }
}
