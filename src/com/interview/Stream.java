package com.interview;

/*
Convert Object into Stream

    list.stream()

    s.chars().stream().mapToObj(x -> x)

    Arrays.stream(arr)

    map.entrySet().stream()

Java Stream Operations

    Terminal Operations

        forEach - it loops over the stream elements => empList.stream().forEach(e -> e.salaryIncrement(10.0));

        Collect

        findFirst

        subList()

        Count()

        min()

        max()

        sum(), average(), range()

        orElse(null)

        orElseThrow(NoSuchElementException::new);

    Intermediate Operations

        Map - map() produces a new stream after applying a function to each element of the original stream.

        Peek - similar to forEach we can use peek, where forEach is terminal operation but peek is intermediate operation

        distinct

        flatMap

        Filter

        sorted

        skip(3)

        limit(5)

        allMatch(i -> i % 2 == 0)

        anyMatch(i -> i % 2 == 0)

        noneMatch(i -> i % 2 == 0)

        mapToInt()

        parallel()

        collect(Collectors.joining(", "))

        Collectors.summarizingDouble(Employee::getSalary)


toArray - empList.stream().toArray(Employee[]::new);

IntStream.of(1, 2, 3);

IntStream.range(10,20);

Student::getGender - Method reference

*/

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    // Data Size         Sequential Stream      Parallel Stream
    // Small (<1000)     Faster                 Slower
    // Medium(1K-1M)     Comparable              Faster
    // Large(>1M)        Slower                 Much Faster

    public Map<String, Integer> sortByKeyAndValue(Map<String, Integer> hm) {

        // sort by key
        Map<String, Integer> sortedMap =
                hm.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));

        // first option
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        // second option
        return hm.entrySet()
                .stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                //.sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        // Will return department with max entry
        // list.stream().collect(Collectors.groupingBy(x->x.dept, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();

        // Gender wise age average
        // Map<String, Double> mapAvgAge = list.stream()
        //    .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

        // Dept wise rank average
        //Map<String, Double> collect = list.stream()
        //    .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));

        //        First duplicate
        //        Set<Integer> items = new HashSet<>();
        //        List<Integer> list = Arrays.asList(4, 3, 5, 7, 3, 4, 1);
        //        Integer a = list.stream().filter(x -> !items.add(x)).findFirst().get();
        //        System.out.println(a);

        // Optional<Integer> firstDuplicate = Arrays.stream(arr)
        //            .filter(e -> Collections.frequency(Arrays.asList(arr), e) > 1)
        //            .findFirst();

        // First Unique Character in a String
        // int a = s.chars().mapToObj(x -> x)
        //      .collect(Collectors.groupingBy(x->x, LinkedHashMap::new, Collectors.counting())).entrySet()
        //      .stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();

        // Array product except self
        // int[] a = {2, 6, 1, 9};
        // Arrays.stream(a).map(x -> Arrays.stream(a).filter(y -> x != y).reduce(1, (y, z) -> y * z)).forEach(System.out::println);

        // Intersection of two lists

//        List<Integer> intList1 = Arrays.asList(2, 4, 5, 6, 8);
//        List<Integer> intList2 = Arrays.asList(2, 4, 5, 6, 8);
//
//        List<Integer> res = intList1.stream()
//                .filter(intList2::contains)
//                .collect(Collectors.toList());

        // Second smallest elements
        // Optional<Integer> res = list.stream().distinct().sorted().skip(1).findFirst();

    }

    public List<String> flatMap(List<List<String>> ll) {
        return ll.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    private void method1() {
        // Character with frequency
        List<String> list = Arrays.asList("a", "b", "a");
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map.toString());
    }

    public static void main(String[] args){

        // Distinct records
        List<String> list = Arrays.asList("a", "b", "a");
        List<String> newList = list.stream().filter(i -> Collections.frequency(list, i) >= 1).distinct().collect(Collectors.toList());
        System.out.println(newList.toString());

        String s = "amjkkbmc";
        s.chars().distinct().forEach(x -> System.out.print((char)x));

        String[] array = {"a", "b", "a"};
        Arrays.stream(array).distinct().forEach(System.out::print);

        System.out.println();

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream).collect(Collectors.toList());

        System.out.println(namesFlatStream);
    }

    public static void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println(isEven.toString());
    }

    public static void whenApplySummarizing_thenGetBasicStats() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        DoubleSummaryStatistics stats = intList.stream()
                .collect(Collectors.summarizingDouble(x -> x));
        System.out.println(stats.toString());
    }

}

// Collectors.summarizingDouble(x -> x)
// Collectors.partitioningBy(i -> i % 2 == 0)
// Collectors.groupingBy(x -> x, Collectors.counting())
// filter(i -> Collections.frequency(list, i) >= 1)
// Collectors.joining(", ")
