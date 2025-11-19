package com.java.problems.empsystem;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeService {
    List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        Objects.requireNonNull(employees, "Employee list must not be null");
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        // Implementation for adding an employee
        Objects.requireNonNull(employee, "Employee must not be null");
        employees.add(employee);
    }

    public void removeEmployeeById(int id) {
        // Implementation for removing an employee by ID
        if(!employees.removeIf(employee -> employee.getId() == id))
            throw new EmployeeNotFoundException("Employee with id "+id+" not found");
        else
            System.out.println("Employee with id "+id+" removed successfully");
    }

    public Optional<Employee> getEmployeeByName(String name) {
        // Implementation for retrieving an employee by ID
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        return employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst();
    }

    public void displayAllEmployeesSortedBySalary() {
        // Implementation for displaying all employees sorted by salary
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                 .forEach(System.out::println);
    }
}
