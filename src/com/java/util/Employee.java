package com.java.util;

public final class Employee extends Person{
    private final String department;
    private final double salary;

    public Employee(String name, int age, String department, double salary) {
        super(name, age,"Employee");
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
