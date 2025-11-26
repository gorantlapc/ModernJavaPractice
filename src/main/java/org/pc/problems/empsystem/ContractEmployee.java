package org.pc.problems.empsystem;

public class ContractEmployee extends Employee{
    public ContractEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.05; // 5% bonus for contract employees
    }
}
