package com.interview;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // [-2,1,-3,4,-1,2,1,-5,4]

    // largest sum in sub-array

    public static void main(String[] args) {

        String str = "a";

        Set<String> set = new HashSet<>(Arrays.asList(str.split(",")));

        System.out.println(set);
    }
}

class TestB {
    private Integer id;
    private String name;

    public TestB(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestB testA = (TestB) o;
        return Objects.equals(id, testA.id) && Objects.equals(name, testA.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TestA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}













































//public static void main(String[] args) {
//
//    int[] a = {2, 0, 1, 9};
//    Arrays.stream(a).map(x -> Arrays.stream(a).filter(y -> x != y).reduce(1, (y, z) -> y * z)).forEach(System.out::println);
//
//    System.out.println("-----");
//    long product = Arrays.stream(a)
//            .asLongStream()
//            .reduce(1, (x, y) -> x * y);
//    long zeroCount = Arrays.stream(a).filter(n -> n == 0).count();
//    Arrays.stream(a)
//            .map(n -> {
//                if (zeroCount > 1) return 0;               // More than 1 zero → all results are 0
//                if (zeroCount == 1) return (n == 0) ?
//                        (int) Arrays.stream(a).filter(x -> x != 0).asLongStream().reduce(1, (x, y) -> x * y)
//                        : 0;
//                return (int) (product / n);               // Normal case
//            }).forEach(System.out::println);
//}