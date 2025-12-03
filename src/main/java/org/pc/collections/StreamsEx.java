package org.pc.collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsEx {
    //    initialize the arraylist with fruit names
    static void main() {
        try {
            java.util.List<String> fruits = java.util.Arrays.asList("Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes");

            // Use Streams to filter fruits starting with 'A' and convert to uppercase
            fruits.stream()
                    .filter(fruit -> fruit.startsWith("A"))
                    .map(String::toUpperCase)
                    .forEach(System.out::println);

//            if you want to sorted list of fruits

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        filterEmployees();
    }

    public static void filterEmployees() {
        try {
            // Sample list of employees
            java.util.List<Employee> employees = java.util.Arrays.asList(
                    new Employee("Alice", "HR", 30, 50000),
                    new Employee("Bob", "IT", 34, 60000),
                    new Employee("Charlie", "Finance", 35, 55000),
                    new Employee("David", "IT", 40, 62000)
            );

            // Use Streams to filter employees in IT department with salary > 60000
            employees.stream().filter(emp -> emp.department().equals("IT") && emp.salary() > 60000)
                    .forEach(emp -> System.out.println(emp.name()));

            employees.stream().filter(emp -> emp.age() > 34)
                    .map(emp -> emp.name().toUpperCase())
                    .sorted()
                    .forEach(name -> System.out.println("Person older than 34 "+name));


//            sort the employees based on their salary in descending order and print their names
            employees.stream()
                    .sorted((Comparator.comparing(Employee::salary).reversed()))
                    .forEach(emp -> System.out.println("Employee: " + emp.name() + ", Salary: " + emp.salary()));

            employees.stream()
                    .mapToDouble(Employee::salary)
                    .average() //max()/average()/sum()
                    .ifPresent(avg -> System.out.println("Average Salary: " + avg));

            Map<String,List<Employee>> employeesGroupByDept = employees.stream().collect(Collectors.groupingBy(Employee::department));
            employeesGroupByDept.forEach((dept, empList) -> {
                System.out.println("Department: " + dept);
                empList.forEach(emp -> System.out.println(" - " + emp.name()));
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
