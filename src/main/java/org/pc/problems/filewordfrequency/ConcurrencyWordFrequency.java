package org.pc.problems.filewordfrequency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyWordFrequency {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            Future<?> f1 = executorService.submit(new FileProcessor("products1.csv"));
            var f2 = executorService.submit(new FileProcessor("products2.csv"));
//            var f3 = executorService.submit(new FileProcessor("products3.csv")); // verify with empty file
//            var f4 = executorService.submit(new FileProcessor("products4.csv")); // verify with missing file

            executorService.shutdown();
            try {
                f1.get();
                f2.get();
//                f3.get();
//                f4.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        FileProcessor.getWordCounts().forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
