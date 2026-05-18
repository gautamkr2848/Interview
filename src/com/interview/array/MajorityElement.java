package com.interview.array;

// Majority element count = n/2 + 1

// sort the array return mid element

// use sorted map for storing counts

// Another Option

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {

    public static int majorityElement_2(int[] a){
        Map<Integer, Long> map = Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            if(entry.getValue() > a.length / 2)
                return entry.getKey();
        }
        return -1;
    }

    public static int majorityElement(int[] a){
        int majorityElement = a[0], count = 1, size = a.length;

        if(size == 2 || size == 0)
            return -1;

        if(size == 1)
            return a[0];

        for(int i=1; i<a.length; i++) {
            if(count == 0) {
                count++;
                majorityElement = a[i];
            } else if(majorityElement == a[i])
                count++;
            else
                count--;
        }
        return majorityElement;
    }
}
