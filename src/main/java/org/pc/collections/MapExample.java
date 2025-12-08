package org.pc.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        var map = Map.of(
                "Alice", 30,
                "Bob", 25,
                "Charlie", 35
        );
//        map.put("David", 28); // This will throw UnsupportedOperationException
        map.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        var modifiableMap = new HashMap<>(map);
        modifiableMap.put("David", 28); // This works fine
        modifiableMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

//    If you want to create a modifiable map directly
        var anotherModifiableMap = new HashMap<String, Integer>();
        anotherModifiableMap.put("Eve", 22);
        anotherModifiableMap.put("Frank", 33);
        anotherModifiableMap.put("Grace", 29);

        anotherModifiableMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

//    If you want to maintain insertion order, use LinkedHashMap
        var linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("Henry", 31);
        linkedHashMap.put("Ivy", 27);
        linkedHashMap.put("Jack", 36);
        linkedHashMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

//    If you want a sorted map, use TreeMap
        var treeMap = new TreeMap<String, Integer>();
        treeMap.put("Zara", 29);
        treeMap.put("Zara", 31); // This will update Zara's age to 31
        treeMap.put("Yanni", 34);
        treeMap.put("Xander", 29);
        treeMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
    }
}
