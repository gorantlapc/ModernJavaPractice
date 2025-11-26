package org.pc.problems.bankaccsimulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BankAccountTrasaction {
    private final static Logger logger = Logger.getLogger(BankAccountTrasaction.class.getName());

    static void main() {
        BankAccount account = new BankAccount("123456", 1000.0);

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executorService.submit(() -> {
                    TxResult afterDeposit = account.deposit(1000.0, taskId);
                    logger.info(afterDeposit.toString());
                });
                executorService.submit(() -> {
                    TxResult afterWithdrawal = account.withdraw(500.0, taskId);
                    logger.info(afterWithdrawal.toString());
                });
            }
            try {
                boolean awaitTermination = executorService.awaitTermination(1, TimeUnit.MINUTES);
                System.out.println("All tasks completed: " + awaitTermination);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Final Balance: " + account.getBalance());
    }
}
