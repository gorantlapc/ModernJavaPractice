package com.java.util;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericsExample {

    static void main() {

        System.out.println("Generics Example");
        GenericsExample genericsExample = new GenericsExample();
        genericsExample.printList(List.of("Apple", "Banana", "Cherry"));
        genericsExample.printList(List.of(1,2,3,4,5));

        java.util.List<Person> personList = java.util.Arrays.asList(
                new Employee("Alice", 30, "HR", 50000),
                new Employee("Bob", 34,"IT", 60000),
                new Employee("David", 40,"IT", 62000),
                new Student("Eve", 22, "Michael", "B", 18),
                new Student("Frank", 24, "Sarah", "A", 20)
        );

        genericsExample.printList(personList);

        Student firstStudent = genericsExample.getFirstElement(personList);
        System.out.println("First Employee: " + firstStudent.getCollege());

        genericsExample.displayPersonInfo(personList);

        try {
//            group persons by profession using generics
            Map<String, List<Person>> personByProfession = genericsExample.groupByField(personList, "profession");

            personByProfession.forEach((profession, ppl) -> {;
                System.out.println("Profession: " + profession);
                System.out.println(ppl.getFirst().getName());
                ppl.forEach(person -> {
                    switch(person) {
                        case Student student -> System.out.println("Student Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getCollege());
                        case Employee employee -> System.out.println("Employee Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Department: " + employee.getDepartment());
                        default -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
                    }
                });
            });
//          group employees by department using generics
            Map<String, List<Person>> employeesByDept = genericsExample.groupByField(personList.stream().filter(Employee.class::isInstance).map(Employee.class::cast).toList(), "department");
            employeesByDept.forEach((dept, empList) -> {
                System.out.println("Department: " + dept);
                empList.forEach(emp -> System.out.println(" - " + emp.getName()));
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*   group persons by a specified field using generics
         fieldName can be "department" or "profession"
    */
    public Map<String, List<Person>> groupByField(List<? extends Person> people, String fieldName) {
        if (fieldName.equals("department")) {
            // group only Employee instances, produce Map<String, List<Employee>>
            Map<String, List<Employee>> empMap = people.stream()
                    .filter(Employee.class::isInstance)
                    .map(Employee.class::cast)
                    .collect(Collectors.groupingBy(Employee::getDepartment));

            // convert to Map<String, List<Person>> to match the method signature
            Map<String, List<Person>> result = new java.util.HashMap<>();
            empMap.forEach((dept, empList) -> result.put(dept, new java.util.ArrayList<>(empList)));
            return result;
        }
        if (fieldName.equals("profession")) {
            return people.stream().collect(Collectors.groupingBy(Person::getProfession));
        }

        throw new IllegalArgumentException("Unsupported field: " + fieldName);
    }

    /*    print list items using generics
     */
    private <T> void printList(List<T> list) {
        // use lambda forEach to process items and avoid duplicate printing
        list.forEach(item -> {
            if (item instanceof Employee employee) {
                System.out.println("Employee Name: " + employee.getName() + ", Department: " + employee.getDepartment());
            } else {
                System.out.println(item);
            }
        });
    }

    /*    get first element from list using generics and stream API
     */
    private <T> Student getFirstElement(List<T> list) {

        Optional<Student> firstStudent = list.stream().filter(Student.class::isInstance).map(Student.class::cast).findFirst();
        if (firstStudent.isPresent()) {
            return firstStudent.get();
        }
        throw new RuntimeException("List is empty");
    }

    /*
         display person info using pattern matching for switch statement and generics
     */
    public void displayPersonInfo(List<? extends Person> people) {
        people.forEach(person -> {
            switch(person) {
                case Student student -> System.out.println("Student Name: " + student.getName() + ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
                case Employee employee -> System.out.println("Employee Name: " + employee.getName() + ", Age: " + employee.getAge() + ", Department: " + employee.getDepartment());
                default -> System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
            }

        });
    }
}
