package org.pc.newfeatures;

public class NewFeaturesSinceJava8 {

    static void main() {
        System.out.println("New Features Since Java 8:");
        System.out.println("1. Local-Variable Type Inference (var keyword)");
        System.out.println("2. Text Blocks for Multi-line Strings");
        System.out.println("3. Switch Expressions");
        System.out.println("4. Records for Immutable Data Classes");
        System.out.println("5. Pattern Matching for instanceof");
        System.out.println("7. Enhanced Null Handling with Optional");
        System.out.println("8. New Methods in Collections API");
        System.out.println("9. Improved Concurrency with Virtual Threads (Project Loom)");
        System.out.println("10. Foreign Function & Memory API (Project Panama)");
        exampleVar();
        exampleTextBlock();
        exampleSwitchExpression();
        exampleRecord();
        examplePatternMatching();
        exampleOptional();
        exampleNewCollectionMethods();
        exampleVirtualThreads();
        exampleForeignFunctionMemoryAPI();
    }

    static void exampleVar() {
        // Local-Variable Type Inference
        var list = java.util.List.of("A", "B", "C");
        list.forEach(System.out::println);
    }

    static void exampleTextBlock() {
        // Text Blocks
        String json = """
                      {
                          "name": "John",
                          "age": 30
                      }
                      """;
        System.out.println(json);
    }

    static void exampleSwitchExpression() {
        // Switch Expressions
        int day = 3;
        String dayName = switch (day) {
            case 1,2 -> "Monday";
            case 3 -> {
                System.out.println("It's mid-week!");
                yield "Wednesday";
            }
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
        System.out.println(dayName);
    }

    static void exampleRecord() {
        // Records
        record Point(int x, int y) {}
        Point p = new Point(10, 20);
        System.out.println("Point: " + p.x() + ", " + p.y());
    }

    static void examplePatternMatching() {
        // Pattern Matching for instanceof
        Object obj = "Hello, World!";
        if (obj instanceof String s) {
            System.out.println("String length: " + s.length());
        }
    }

    static void exampleOptional() {
        // Enhanced Null Handling with Optional
        java.util.Optional<String> optional = java.util.Optional.ofNullable(null);
        String value = optional.orElse("Default Value");
        System.out.println(value);
    }

   static void exampleNewCollectionMethods() {
        // New Methods in Collections API
        java.util.List<String> list = java.util.List.of("apple", "banana", "cherry","berry");
        list.stream()
            .filter(s -> s.startsWith("b"))
            .forEach(System.out::println);
    }

    static void exampleVirtualThreads() {
        // Improved Concurrency with Virtual Threads (Project Loom)
        try {
            java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();
            for (int i = 0; i < 10; i++) {
                final int taskId = i;
                executor.submit(() -> System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName()));
            }
            executor.shutdown();
            executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void exampleForeignFunctionMemoryAPI() {
        // Foreign Function & Memory API (Project Panama)
        // This is a placeholder as the actual implementation requires native code and setup.
        System.out.println("Foreign Function & Memory API example is not implemented here.");
    }

}
