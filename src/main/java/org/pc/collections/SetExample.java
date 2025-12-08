package org.pc.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    static void main() {
        Set<String> set = new java.util.HashSet<>(Set.of("Apple", "Banana", "Orange"));
        set.add("Banana"); // Duplicate, won't be added
        set.add("Grapes"); // New element. Order is not guaranteed
        System.out.println("Set contents: " + set);

        System.out.println("Contains 'Apple': " + set.contains("Apple"));

        set.remove("Orange");
        System.out.println("Set after removing 'Orange': " + set);

//      If you want to maintain insertion order, use LinkedHashSet
        var linkedSet = new LinkedHashSet<String>();
        linkedSet.add("Grapes");
        linkedSet.add("Banana");
        linkedSet.add("Apple");
        linkedSet.add("Banana"); // Duplicate, won't be added
        System.out.println("LinkedHashSet contents (insertion order): " + linkedSet);

//       If you want a sorted set, use TreeSet
        var treeSet = new TreeSet<String>();
        treeSet.add("Grapes");
        treeSet.add("Banana");
        treeSet.add("Apple");
        System.out.println("TreeSet contents (sorted order): " + treeSet);

//        Sort using Comparator
    }
}
