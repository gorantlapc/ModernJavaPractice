package org.pc.custom.annotation;

import java.util.ArrayList;
import java.util.List;

public class AnnotationUtil {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10, "Alice", 50000),
                new Employee(20, "Bob", 30000),
                new Employee(30, "Charlie", 70000),
                new Employee(40, "David", 40000)));
        IEmployeeService employeeService = LoggingProxy.createProxy(new EmployeeService(employees));

        employeeService.getEmployeeByName("Alice");
        employeeService.removeEmployeeById(10);
        employeeService.displayAllEmployeesSortedBySalary();
    }
}
