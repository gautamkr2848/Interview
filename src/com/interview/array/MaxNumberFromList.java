package com.interview.array;

import java.util.*;

public class MaxNumberFromList {

    public void MaxNumberFromList() {
        List<String> arr = new ArrayList<>();
        arr.add("2");
        arr.add("0");
        arr.add("0");
        arr.add("1");
        Collections.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        for(int i=0; i<arr.size(); i++)
            System.out.print(arr.get(i));
    }
}
