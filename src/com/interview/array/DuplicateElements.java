package com.interview.array;


import java.util.*;
import java.util.stream.Collectors;

public class DuplicateElements {

    public void duplicateElements(int[] a){
        for(int i=0; i<a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.print(Math.abs(a[i])+" ");
            }
        }
    }

    public void duplicateElements_2(int[] a){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i]))
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for(Integer i : map.keySet()){
            if(map.get(i) > 1)
                System.out.println(i);
        }
    }

    public int remove_duplicate_from_sorted_array(int a[],int n){
        if(n == 0)
            return 0;
        int slow = 0, fast = 1;

        while(fast < n){
            if(a[slow] != a[fast])
                a[++slow] = a[fast];
            ++fast;
        }
        return ++slow;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(5, 6, 2, 4, 1, 5, 3, 1, 6);

        //System.out.println(a.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).toString());

        //a.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream().map(x-> x.getKey()).forEach(System.out::print);

        Set<Integer> s = new HashSet<>();
        a.stream().forEach(x -> s.add(x));
        System.out.println(s.toString());
    }
}
