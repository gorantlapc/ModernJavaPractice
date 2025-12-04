package org.pc.util.generics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericsStreamsAndPatterns {

    /*   group employees by a specified field using generics
    */
    public <T, R extends Comparable<R>> Map<R, List<Employee>> groupByField(List<Employee> people, Function<Employee, R> methodReference) {
            // group only Employee instances, produce Map<String, List<Employee>>
            return people.stream()
                    .collect(Collectors.groupingBy(methodReference));
    }

    /*
        Sort the employees based on method reference passed as method argument
     */
    public <T, R extends Comparable<R>, S extends Comparable<S>> List<Employee> sortEmployeesByField(
            List<Employee> employees, Function<Employee, R> methodReference, Function<Employee, S> thenComparing1) {
        return employees.stream()
                .sorted(Comparator.comparing(methodReference).thenComparing(thenComparing1))
                .toList();

    }

    /*    print list items using generics
     */
    public <T> void printList(List<T> list) {
        // use lambda forEach to process items and avoid duplicate printing
        list.forEach(item -> {
            switch (item) {
                case Employee employee -> System.out.println(employee.getName() + ", " + employee.getDepartment());
                case Student student -> System.out.println(student.getName() + student.getGrade());
                default -> System.out.println(item);
            }
        });
    }

    /*    get first student from list using generics and stream API
     */
    public <T> Optional<Student> getFirstStudent(List<T> list) {
        return list.stream().filter(Student.class::isInstance).map(Student.class::cast).findFirst();
    }

    /*
         display person info using pattern matching for switch statement and generics
     */
    public void displayPersonInfo(List<? extends Person> people) {
        people.forEach(person -> {
            switch (person) {
                case Student student ->
                        System.out.println("Student Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
                case Employee employee ->
                        System.out.println("Employee Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Department: " + employee.getDepartment());
                case Person person1 -> System.out.println("Name: " + person1.getName() + ", Age: " + person1.getAge());
//                If we use sealed class type or enum type passed tpo switch and cover all possible cases, do not need to add default case
            }

        });
    }
}
