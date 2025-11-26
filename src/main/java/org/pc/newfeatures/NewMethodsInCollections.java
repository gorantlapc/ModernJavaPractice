package org.pc.newfeatures;

import java.util.*;
import java.util.stream.Collectors;

public class NewMethodsInCollections {
    static void main() {
        newMethodsInMap();
        newMethodsInList();
        immutableCollections();
        findEvenNumbers();
        takehileExample();
    }
//  Demonstrating new methods in Map interface
    static void newMethodsInMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        map.forEach((k, v) -> System.out.println(k + "=" + v));
        map.computeIfAbsent(3, k -> "C"); // adds if missing
        map.forEach((key, value) -> System.out.println(key + "=" + value));

        map.replaceAll((k, v) -> v.toLowerCase());
        map.forEach((key, value) -> System.out.println(key + "=" + value));

    }

//   Demonstrating new methods in List interface
    static void newMethodsInList() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        nums.removeIf(n -> n % 2 == 0); // removes even numbers
        nums.replaceAll(n -> n * 10);   // modifies in place
        nums.sort(Integer::compareTo);  // sorts list

        nums.forEach(System.out::println);

        List<String> strings = new ArrayList<>(Arrays.asList("banana", "apple", "cherry"));
        strings.replaceAll(String::toUpperCase);
        strings.forEach(System.out::println);
        strings.sort(String::compareTo);
        strings.forEach(fruit -> {
            System.out.println("Fruit: " + fruit);
            if (strings.size()-1 != strings.indexOf(fruit)) {
                System.out.println("---");
            }
        });

    }

    static void newMethodsInSet() {
        Set<String> set = new HashSet<>(Arrays.asList("A", "B", "C", "D"));

        set.removeIf(s -> s.equals("B")); // removes "B"
        set.forEach(System.out::println);

        set.add("E");
        set.forEach(System.out::println);
    }

//    Demonstrating immutable collections
    static void immutableCollections() {
        List<String> immutableList = List.of("A", "B", "C");
        Set<String> immutableSet = Set.of("X", "Y", "Z");
        Map<Integer, String> immutableMap = Map.of(1, "One", 2, "Two");

        immutableList.forEach(System.out::println);
        immutableSet.forEach(System.out::println);
        immutableMap.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    static void findEvenNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(3,5,7,10, 15, 20, 25, 30, 35));

//        one way to find even numbers using streams
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even Numbers (using streams):");
        evenNumbers.forEach(System.out::println);

//        other way using removeIf
        numbers.removeIf(n -> n % 2 != 0); // removes odd numbers
        System.out.println("Even Numbers (using removeIf:");
        numbers.forEach(System.out::println);

        //       another way using partitioningBy
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers (using partitioningBy):");
        partitioned.get(true).forEach(System.out::println);

        //       another way using forEach
        System.out.println("Even Numbers (using forEach):");
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });

        //      find prime numbers using streams
        List<Integer> primeNumbers = new ArrayList<>(List.of(2,3,5,7,10,15,20,25,30,35));
        primeNumbers.stream()
                .filter(NewMethodsInCollections::isPrime).toList().forEach(System.out::println);

    }

//    takehile - Stops processing as soon as predicate becomes false. works only with ordered streams.
    static void takehileExample() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 6,4);
        List<Integer> result = numbers.stream()
                .takeWhile(n -> n < 8)
                .toList();
        List<Integer> list = numbers.stream().filter(n -> n < 8).toList();
        System.out.println("TakeWhile Result:");
        result.forEach(System.out::println);
//       Filter - Applies predicate to every element and returns only those that match
        System.out.println("Filter Result:");
        list.forEach(System.out::println);
//      DropWhile - Drops elements as long as the predicate is true, once false is encountered, all subsequent elements are included.
        List<Integer> integerStream = numbers.stream().dropWhile(n -> n < 8).toList();
        System.out.println("DropWhile Result:");
        integerStream.forEach(System.out::println);
    }

    private static boolean isPrime(Integer n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


}
