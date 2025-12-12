package org.pc.problems.filewordfrequency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyWordFrequency {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            executorService.submit(new FileProcessor("products1.csv"));
            executorService.submit(new FileProcessor("products2.csv"));
            executorService.shutdown();
        }
        FileProcessor.getWordCounts().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
