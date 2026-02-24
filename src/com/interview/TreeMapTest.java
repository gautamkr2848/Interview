package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {

        Map<String, Integer> map2 = new TreeMap<>();
        map2.put("A", 1);
        map2.put("A", 2);

        System.out.println(map2.toString());

        Map<Test1, Integer> map = new TreeMap<>();
        map.put(new Test1(1, "Gautam"), 1);
        map.put(new Test1(1, "Gautam"), 2);

        for(Map.Entry<Test1, Integer> e : map.entrySet()) {
            System.out.println(e.getKey().name +" "+ e.getKey().id + " " + e.getValue());
        }
    }
}

class Test1 {
    int id;
    String name;

    Test1(){}

    Test1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test1 test = (Test1) o;
        return id == test.id && Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

//    @Override
//    public int compareTo(Test1 o) {
//        return Integer.compare(this.id, o.id);
//    }

//    @Override
//    public int compareTo(Value o) {
//        int x1 = x * x;
//        int y1 = y * y;
//        int x2 = o.x * o.x;
//        int y2 = o.y * o.y;
//        return (x1 + y1) - (x2 + y2);
//    }
}