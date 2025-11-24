package com.java.problems.bankaccsimulation;

public record TxResult(String account, int taskId, String operation, double amount, double balance) {
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

