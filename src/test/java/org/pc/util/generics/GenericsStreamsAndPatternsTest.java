package org.pc.util.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenericsStreamsAndPatternsTest {
    private List<Person> personList;
    private GenericsStreamsAndPatterns genericsStreamsAndPatterns;

    @BeforeEach
    void setUp() {
        genericsStreamsAndPatterns = new GenericsStreamsAndPatterns();
        personList = List.of(
                new Employee("Bob", 34, "IT", 60000),
                new Employee("David", 40, "IT", 62000),
                new Student("Eve", 22, "Michael", "B", 18),
                new Student("Frank", 24, "Sarah", "A", 20),
                new Employee("Alice", 30, "HR", 50000),
                new FullTimeEmployee("Ram", 40, "Finance", 62000)
        );

    }

    @Test
    void getFirstStudent() {
        Optional<Student> firstStudent = genericsStreamsAndPatterns.getFirstStudent(personList);
        assertTrue(firstStudent.isPresent());
        assertEquals("Eve", firstStudent.get().getName());
    }

    @Test
    void groupEmployeesByField() {
        List<Employee> employeesList = personList.stream()
                .filter(Employee.class::isInstance)
                .map(Employee.class::cast).toList();

        Map<String, List<Employee>> groupByDepartment = genericsStreamsAndPatterns.groupByField(employeesList, Employee::getDepartment);
        assertEquals(3, groupByDepartment.size());
        assertEquals(2, groupByDepartment.get("IT").size());
        assertEquals(1, groupByDepartment.get("HR").size());
        assertTrue(groupByDepartment.get("IT").contains(employeesList.getFirst()));

        Map<Double, List<Employee>> groupBySalary = genericsStreamsAndPatterns.groupByField(employeesList, Employee::getSalary);
        assertEquals(2, groupBySalary.get(Double.valueOf(62000)).size());

    }

    @Test
    void sortEmployeesByField() {
        List<Employee> employeesList = personList.stream()
                .filter(Employee.class::isInstance)
                .map(Employee.class::cast).toList();

        List<Employee> sortedEmployeesByName = genericsStreamsAndPatterns.sortEmployeesByField(employeesList, Employee::getName, Employee::getSalary);
        assertNotNull(sortedEmployeesByName);
        assertEquals("Alice", sortedEmployeesByName.getFirst().getName());
        assertEquals("Ram", sortedEmployeesByName.getLast().getName());

        List<Employee> sortedEmployeesBySalary = genericsStreamsAndPatterns.sortEmployeesByField(employeesList, Employee::getSalary, Employee::getName);
        assertNotNull(sortedEmployeesBySalary);
        assertEquals("Alice", sortedEmployeesBySalary.getFirst().getName());
        assertEquals("Ram", sortedEmployeesBySalary.getLast().getName());
    }

    @Test
    void printList() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(buffer));
        genericsStreamsAndPatterns.printList(List.of(new Employee("Bob", 34, "IT", 60000), "Apple", "Banana", "Cherry"));

        System.setOut(originalOut);
        String output = buffer.toString().trim();
        assertTrue(output.contains("Apple"));
        assertTrue(output.contains("Bob"));
    }
    @Test
    void displayPersonInfo() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(buffer));
        genericsStreamsAndPatterns.displayPersonInfo(personList);

        System.setOut(originalOut);
        String output = buffer.toString().trim();
        assertTrue(output.contains("Student Name: Frank, Age: 24, Grade: A"));
        assertTrue(output.contains("Employee Name: Bob, Age: 34, Department: IT"));
    }

}