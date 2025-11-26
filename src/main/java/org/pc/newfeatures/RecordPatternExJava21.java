package org.pc.newfeatures;

record Employee(String name, String department, int age, double salary) {}

public class RecordPatternExJava21 {
    static void main() {
        Employee employee = new Employee("Alice", "Engineering", 35, 40000);
        testRecordPattern(employee);
    }

    static void testRecordPattern(Employee emp) {
        if (emp instanceof Employee(String name, String department, int age, double salary) && salary > 50000) {
            System.out.println("High earning employee: " + name + " from " + department);
        } else {
            System.out.println("Employee does not meet the criteria.");
        }
    }

}
