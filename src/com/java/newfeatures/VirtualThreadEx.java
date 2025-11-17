package com.java.newfeatures;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadEx {
    static void main(){
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executorService.submit(() -> {
                    System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
                });
            }
        }
    }
}
