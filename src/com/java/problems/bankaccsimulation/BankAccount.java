package com.java.problems.bankaccsimulation;

record TxResult(String account, int taskId, String operation, double amount, double balance) {
    @Override
    public String toString() {
        return "TxResult{" +
                "account='" + account + '\'' +
                ", taskId='" + taskId + '\'' +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}

public class BankAccount {
    private volatile String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized TxResult deposit(double amount,int taskId) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        return new TxResult( accountNumber,taskId, "DEPOSIT", amount, balance);
    }

    public synchronized TxResult withdraw(double amount, int taskId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        return new TxResult( accountNumber,taskId, "WITHDRAW", amount, balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
