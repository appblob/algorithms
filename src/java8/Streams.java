package java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        /*
        * Stream : typed interface, light weight, does not hold data, does not change the data it processes, lazily evaluated
        * Data is automatically processed in parallel
        * All the process is conducted in a pipeline, avoids unnecessary intermediary computation
        * **/



        List<String> numsString = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        List<String> result = new ArrayList<>();

        // Consumer
        Consumer<String> c1 = System.out::println; // method reference
        Consumer<String> c2 = result::add;
        Consumer<String> c3 = c1.andThen(c2);

        numsString.forEach(c3); // terminal operation - forEach
        System.out.println(result);


        Stream<String> numbers = Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        //numbers.forEach(System.out::println);

        // Predicate
        Predicate<String> p1 = (s) -> s.length() > 4;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        /********************** FILTER *********************/
        // intermediary operations - filter and peek
        Stream<String> filtered
                = numbers
                .peek(System.out::println) // method reference
                .filter(p1.and(p2.or(p3))); // FILTER

        List<String> nums = new ArrayList<>();
        //System.out.println(filtered.findFirst().orElse(null));
        filtered
                .peek(System.out::println)
                .forEach(nums::add);


        System.out.println(nums);


        /********************** MAP *************************/

        List<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> l2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> l3 = Arrays.asList(10, 11, 13);
        List<List<Integer>> l = Arrays.asList(l1, l2, l3);
        System.out.println(l);
        List<Integer> flatL = new LinkedList<>();

        l.stream()
                .map(list -> list.size())
                .forEach(System.out::println);

        Function<List<?>, Integer> size = (lst) -> lst.size();
        l.stream()
                .map(size)
                .forEach(System.out::println);

        Function<List<Integer>, Stream<Integer>> flatmapper = lst -> lst.stream();
        l.stream()
                .flatMap(flatmapper)
                .forEach(flatL::add);

        System.out.println(flatL);

        /************************ REDUCE ****************************/
        /*
         *  Reduction : Terminal operations
         * min(), max() - returns Optional
         *
         *  count()
         *
         *  boolean reductions : allMatch(), anyMatch(), noneMatch()
         *
         *  findFirst(), findAny() - returns Optional
         * */

        List<Integer> scores = Arrays.asList(78, 20, 34, 98, 45, 77, 81, 69, 52);
        Integer total = scores.stream().reduce(0, (s1, s2) -> s1 + s2);

        BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
        Integer sumTotal = 0, id = 0;
        sumTotal = scores.stream().reduce(id, sum);
        System.out.println(sumTotal);

        Optional<Integer> max = scores.stream()
                .max(Comparator.naturalOrder());

        if (max.isPresent())
            System.out.println(max.get());

        max.ifPresent(System.out::println);
        System.out.println(max.orElse(Integer.MIN_VALUE));
        max.orElseGet(() -> Integer.MIN_VALUE);
        max.orElseThrow(RuntimeException::new);

        List<Integer> nums1 = Arrays.asList(-10);//Arrays.asList(-10, -10);
        nums1.stream()
                .reduce(0, Integer::sum);


        //Does not work
        Integer maxInNum1 = nums1
                .stream()
                .reduce(0, Integer::max);

        System.out.println("Should be -10, not : " + maxInNum1);

        Optional<Integer> maxNum1 = nums1
                .stream()
                .reduce(Integer::max);

        maxNum1.ifPresent(System.out::println);

        /**
         * Collectors : mutable reduction
         * */
        String threeCharsLong = numsString.stream()
                .filter(num -> num.length() == 3)
                .collect(Collectors.joining(", "));
        System.out.println(threeCharsLong);

        List<String> threeCharsList = numsString.stream()
                .filter(num -> num.length() == 3)
                .collect(Collectors.toList());
        System.out.println(threeCharsList);

        Map<Integer, List<String>> lenNumsMap = numsString.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(lenNumsMap);

        Map<Integer, Long> lenCountMap = numsString.stream()
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.counting())); // downstream collector
        System.out.println(lenCountMap);

        Map<Integer, List<String>> lenUpperCaseNamesMap = numsString.stream()
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.mapping(String::toUpperCase,
                                        Collectors.toList()))); // downstream collector

        System.out.println(lenUpperCaseNamesMap);


        Map<Integer, Set<String>> lenUpperCaseNamesSet = numsString.stream()
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.mapping(String::toUpperCase,
                                        Collectors.toCollection(TreeSet::new)))); // downstream collector
        System.out.println(lenUpperCaseNamesSet);

        Map<Integer, String> lenUpperCaseNames = numsString.stream()
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.mapping(String::toUpperCase,
                                        Collectors.joining(", ")))); // downstream collector
        System.out.println(lenUpperCaseNames);


    }
}
