package com.java.problems.empsystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeUtil {
    Scanner scanner = new Scanner(System.in);
    EmployeeService employeeService;

    static void main() {
        EmployeeUtil util = new EmployeeUtil();
        util.init();

        util.addEmployee();
        util.removeEmployee();
        util.getEmployeeByName();
        util.displayAllEmployeesSortedBySalary();
    }

    public void addEmployee() {
        System.out.println("Enter employee details to add:");
        String text = scanner.nextLine().trim();
        String[] parts = text.split(",");
        if(parts.length != 3) {
            System.out.println("Invalid input format. Expected: id,name,salary");
            addEmployee();
        }
        try {
            int id = Integer.parseInt(parts[0].trim());
            String empName = parts[1].trim();
            double salary = Double.parseDouble(parts[2].trim());
            Employee newEmployee = new FullTimeEmployee(id, empName, salary);
            employeeService.addEmployee(newEmployee);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }

    public void removeEmployee() {
        System.out.print("Enter employee id to remove: ");
        try {
            String line = scanner.nextLine();
            int id = Integer.parseInt(line.trim());
            try {
                employeeService.removeEmployeeById(id);
            } catch (EmployeeNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void getEmployeeByName() {
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine().trim();
        try {
            employeeService.getEmployeeByName(name).ifPresent(System.out::println);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllEmployeesSortedBySalary() {
        employeeService.displayAllEmployeesSortedBySalary();
    }

    private void init() {
        List<Employee> employees = List.of(
                new FullTimeEmployee(10,"Alice", 50000),
                new ContractEmployee(20,"Bob", 30000),
                new FullTimeEmployee(30,"Charlie", 70000),
                new ContractEmployee(40,"David", 40000));
        employeeService = new EmployeeService(new ArrayList(employees));
    }
}
