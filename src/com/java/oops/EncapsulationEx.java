package com.java.oops;

// Encapsulation Example
// Wrapping data (variables) and code (methods) together as a single unit.
// Data hiding: private variables can only be accessed through public methods.
public class EncapsulationEx {
    private double balance; // private variable (hidden)

    // public method to set value
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // public method to access the private variable
    public double getBalance() {
        return balance;
    }

}
