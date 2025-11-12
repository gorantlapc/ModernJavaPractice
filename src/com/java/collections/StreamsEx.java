package com.java.collections;

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
            employees.stream().filter(emp -> emp.getDepartment().equals("IT") && emp.getSalary() > 60000)
                    .forEach(emp -> System.out.println(emp.getName()));

            employees.stream().filter(emp -> emp.getAge() > 34)
                    .map(emp -> emp.getName().toUpperCase())
                    .sorted()
                    .forEach(name -> IO.println("Person older than 34 "+name));

//            sort the employees based on their salary in descending order and print their names
            employees.stream()
                    .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                    .forEach(emp -> IO.println("Employee: " + emp.getName() + ", Salary: " + emp.getSalary()));

            Map<String,List<Employee>> employeesGroupByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
            employeesGroupByDept.forEach((dept, empList) -> {
                IO.println("Department: " + dept);
                empList.forEach(emp -> IO.println(" - " + emp.getName()));
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
