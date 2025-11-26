package org.pc.collections;

import java.util.*;

public class ListVisualization {
    static void main() {
        System.out.println("=== ArrayList Internal Behavior ===");
        simulateArrayList();

        System.out.println("\n=== LinkedList Internal Behavior ===");
        simulateLinkedList();
    }

    static void simulateArrayList() {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Initial ArrayList: " + list);

        System.out.println("\nInserting 'X' at index 2...");
        // Visual simulation of shifting
        System.out.println("Before: [A] [B] [C] [D]");
        System.out.println("Shift elements from index 2 onwards one position to the right");
        System.out.println("After : [A] [B] [X] [C] [D]");

        list.add(2, "X");
        System.out.println("ArrayList after insertion: " + list);
        list.forEach(System.out::println);

        System.out.println("\nRemoving element at index 3 ('C')...");
        System.out.println("Before: [A] [B] [X] [C] [D]");
        System.out.println("Shift elements from index 4 leftwards to fill the gap");
        System.out.println("After : [A] [B] [X] [D]");
        list.remove(3);

        System.out.println("ArrayList after removal: " + list);
    }

    static void simulateLinkedList() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Initial LinkedList: " + list);

        System.out.println("\nInserting 'X' at index 2...");
        System.out.println("Before: A <-> B <-> C <-> D");
        System.out.println("Find node 2 → relink pointers:");
        System.out.println("    B.next = X, X.prev = B");
        System.out.println("    X.next = C, C.prev = X");
        System.out.println("After : A <-> B <-> X <-> C <-> D");

        list.add(2, "X");
        System.out.println("LinkedList after insertion: " + list);

        System.out.println("\nRemoving element at index 3 ('C')...");
        System.out.println("Before: A <-> B <-> X <-> C <-> D");
        System.out.println("Find node 3 → bypass it:");
        System.out.println("    X.next = D, D.prev = X");
        System.out.println("After : A <-> B <-> X <-> D");

        list.remove(3);
        System.out.println("LinkedList after removal: " + list);
    }
}
