package org.pc.problems.filewordfrequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileProcessor implements Runnable {
    private static final Map<String, Integer> wordCounts = new ConcurrentHashMap<>();
    private List<String> listOfProducts;
    private String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void run() {
        try (InputStream resource = getClass().getClassLoader().getResourceAsStream(fileName);) {
            if (resource == null) {
                throw new RuntimeException("File not found: " + fileName);
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource));
            String line = "";
            line = reader.readLine();
            if (line == null || line.isEmpty()) {
                throw new RuntimeException("File is empty: " + fileName);
            }
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            listOfProducts = Arrays.stream(content.toString().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        listOfProducts.forEach(product -> {
            wordCounts.merge(product, 1, Integer::sum);
        });
    }

    public static Map<String, Integer> getWordCounts() {
        return wordCounts;
    }
}
