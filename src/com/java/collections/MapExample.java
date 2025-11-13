package com.java.collections;

import java.util.Map;

public class MapExample {
    static void main() {
        Map<String, Integer> map = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );
//        map.put("David", 28); // This will throw UnsupportedOperationException
    map.forEach((name,age) -> IO.println(name + " is " + age + " years old") );

    Map<String, Integer> modifiableMap = new java.util.HashMap<>(map);
    modifiableMap.put("David", 28); // This works fine
    modifiableMap.forEach((name,age) -> IO.println(name + " is " + age + " years old") );

//    If you want to create a modifiable map directly
    Map<String, Integer> anotherModifiableMap = new java.util.HashMap<>();
    anotherModifiableMap.put("Eve", 22);
    anotherModifiableMap.put("Frank", 33);
    anotherModifiableMap.put("Grace", 29);
    anotherModifiableMap.forEach((name,age) -> IO.println(name + " is " + age + " years old") );

//    If you want to maintain insertion order, use LinkedHashMap
    Map<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>();
    linkedHashMap.put("Henry", 31);
    linkedHashMap.put("Ivy", 27);
    linkedHashMap.put("Jack", 36);
    linkedHashMap.forEach((name,age) -> IO.println(name + " is " + age + " years old") );

//    If you want a sorted map, use TreeMap
    Map<String, Integer> treeMap = new java.util.TreeMap<>();
    treeMap.put("Zara", 29);
    treeMap.put("Zara", 31); // This will update Zara's age to 31
    treeMap.put("Yanni", 34);
    treeMap.put("Xander", 29);
    treeMap.forEach((name,age) -> IO.println(name + " is " + age + " years old") );
    }
}
