# Modern Java — Examples and Exercises

A curated collection of small examples and exercises that demonstrate modern Java language features and core API concepts, with runnable code under src/main/java.
# Table of Contents
- [What you'll find here](#what-youll-find-here)
- [Project structure (high level)](#project-structure-high-level)
- [Key examples → what to read/run](#key-examples--what-to-readrun)
- [How to build and run](#how-to-build-and-run)
- [Tests](#tests)
- [Contribution guidelines](#contribution-guidelines)

## What you'll find here
- Compact, focused examples grouped by topic (collections, concurrency, new language features, OOP, exceptions, utilities).
- The examples cover new modern java features
  - Optional, Lambda expressions, Streams API, Functional interfaces and Method references, interface default/static methods.
  - Local variable type reference, Records, Text blocks, Sealed classes, virtual threads
  - Switch expressions and enhanced pattern matching examples (Java 17+).
  - Concurrency utilities (CompletableFuture, ConcurrentHashMap).
  - Modern exception handling patterns like multi-catch, try-with-resources.
  - OOP principles, collections, generics with modern Java syntax.
  - Modern date and time API (java.time).
- Small practice projects simulating real-world scenarios (bank account simulation, employee management system, file word frequency counter).
- Unit tests under `test/` demonstrating common test patterns.

## Project structure (high level)
- `src/main/java/org/pc/collections` — Collections and Streams examples (ArrayList vs LinkedList, Stream APIs, flatMap, partitioning, map/set/list/queue examples).
- `src/main/java/org/pc/concurrency` — Concurrency examples (race conditions, parallel processing, ConcurrentHashMap usage).
- `src/main/java/org/pc/newfeatures` — Newer Java language features (records, virtual threads, pattern matching, interface default/static methods).
- `src/main/java/org/pc/exceptions` — Exception handling patterns and custom exceptions.
- `src/main/java/org/pc/problems` — Small practice projects (bank account simulation, employee management, file word frequency).
- `src/main/resources` — Example data files used by demos (orders.json, products.csv, students.json, users.json).

## Key examples → what to read/run
Below are important files and what they demonstrate. Open the file in your IDE to inspect code and comments.

- Collections & Streams
  - `org.pc.collections.StreamsEx` — basic stream operations: filter, map, reduce, collect.
  - `org.pc.collections.StreamFlatMapEx` — flatMap use-cases and nested collections flattening.
  - `org.pc.collections.PartitioningEx` — collectors partitioning/groupingBy examples.
  - `org.pc.collections.ArrayListVsLinkedList` — performance/behavior differences.

- Concurrency
  - `org.pc.concurrency.RaceConditionExample` — demonstrates shared-state race conditions and how to reason about them.
  - `org.pc.concurrency.ParallelProcessing` — using parallel streams and executors for CPU-bound tasks.
  - `org.pc.concurrency.ConcurrentHashMapEx` — concurrent map patterns and atomic updates.

- Newer Java language features (Java 8 → 21 snippets)
  - `org.pc.newfeatures.NewMethodsInCollections` — default/static interface methods and collection convenience methods (forEach, removeIf, sort).
  - `org.pc.newfeatures.InterfaceDefaultAndStaticMethods` — how default and static methods work in interfaces.
  - `org.pc.newfeatures.RecordPatternExJava21` — example of record patterns (Java 21 preview/standard) and pattern matching in switch.
  - `org.pc.newfeatures.VirtualThreadEx` — virtual threads example (Project Loom integration).

- Exceptions & Utilities
  - `org.pc.exceptions.ExceptionHandling` and `AuditLogger` — structured exception handling and logging helper.
  - `org.pc.util.parser` — JSON/CSV parsing utilities used by demos (see tests in `test/` for usage patterns).

- Small projects and exercises
  - `src/main/java/org/pc/problems/bankaccsimulation` — bank account and transactions simulation (state handling, domain modeling).
  - `src/main/java/org/pc/problems/empsystem` — employee management system (OOP design, custom exceptions, services).

## How to build and run
This is a Maven project. Ensure you have Maven and JDK 21 installed.

From your IDE (recommended for stepping through code)
- Import the project as a Maven project (Open or Import in IntelliJ/Eclipse).
- Build the project and run any class that has a `main` method (for example `org.pc.Main`).

## Tests
- Unit tests live under `test/`. Run them with:
  mvn test

## Contribution guidelines
- Fork, create a branch named `feature/<short-desc>`, add tests for new behaviour, open a pull request with a clear description.
- Keep changes small and focused; prefer adding new example classes under the topic folder.


---
Happy coding and learning modern Java! 🚀