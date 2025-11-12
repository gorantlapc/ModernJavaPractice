package com.java.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

    static void main() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime, endTime;

        // Adding 100000 elements at the beginning
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.addFirst(i); // shifts elements each time
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList insert at beginning: " + (endTime - startTime)/1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.addFirst(i); // pointer manipulation only
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList insert at beginning: " + (endTime - startTime)/1_000_000 + " ms");

        // Accessing 100000 elements
        startTime = System.nanoTime();
        arrayList.forEach(IO::println);
        endTime = System.nanoTime();
        System.out.println("ArrayList access time: " + (endTime - startTime)/1_000_000 + " ms");

        startTime = System.nanoTime();
        linkedList.forEach(IO::println);
        endTime = System.nanoTime();
        System.out.println("LinkedList access time: " + (endTime - startTime)/1_000_000 + " ms");
    }
}
