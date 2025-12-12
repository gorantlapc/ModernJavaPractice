package org.pc.concurrency;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapEx {
    private final Map<Integer, String> cache = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<String> fruits = List.of();
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
        }

    }
}
