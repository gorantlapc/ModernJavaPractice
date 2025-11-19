package com.java.problems.empsystem;

public class FullTimeEmployee extends Employee{

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10; // 10% bonus for full-time employees
    }
}
