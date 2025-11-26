package org.pc.collections;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class PartitioningEx {
    static void main() {
        List<Student> students = Arrays.asList(
                new Student("John", 85),
                new Student("Emma", 35),
                new Student("Sophia", 70),
                new Student("Liam", 40),
                new Student("Olivia", 25)
        );

        // Partition students into pass/fail
        Map<Boolean, List<Student>> partitioned =
                students.stream()
                        .collect(Collectors.partitioningBy(s -> s.marks >= 40));

        System.out.println("Passed Students:");
        partitioned.get(true).forEach(s -> System.out.println("  " + s.name));

        System.out.println("\nFailed Students:");
        partitioned.get(false).forEach(s -> System.out.println("  " + s.name));
    }
}
