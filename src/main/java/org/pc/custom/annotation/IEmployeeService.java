package org.pc.custom.annotation;

import java.util.Optional;

public interface IEmployeeService {
    void addEmployee(Employee employee);

    void removeEmployeeById(int id);

    Optional<Employee> getEmployeeByName(String name);

    void displayAllEmployeesSortedBySalary();
}
