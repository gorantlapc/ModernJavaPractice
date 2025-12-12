package org.pc.custom.annotation;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeService implements IEmployeeService{
    List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        Objects.requireNonNull(employees, "Employee list must not be null");
        this.employees = employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        // Implementation for adding an employee
        Objects.requireNonNull(employee, "Employee must not be null");
        employees.add(employee);
    }

    @LogExecution
    public void removeEmployeeById(int id){
        // Implementation for removing an employee by ID
        if(!employees.removeIf(employee -> employee.id() == id))
            throw new EmployeeNotFoundException("Employee with id "+id+" not found");
        else
            System.out.println("Employee with id "+id+" removed successfully");
    }

    @LogExecution(" get employee by name")
    public Optional<Employee> getEmployeeByName(String name) {
        // Implementation for retrieving an employee by ID
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must not be null or empty");
        }
        return employees.stream()
                .filter(employee -> employee.name().equals(name))
                .findFirst();
    }

    @LogExecution("display the employees")
    public void displayAllEmployeesSortedBySalary() {
        // Implementation for displaying all employees sorted by salary
        employees.stream()
                 .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                 .forEach(System.out::println);
    }
}
