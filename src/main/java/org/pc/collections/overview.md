    

# Overview of Java Collections Framework

The Java Collections Framework (JCF) is a unified architecture for representing and manipulating collections of objects in Java. It provides a set of interfaces, implementations, and algorithms that facilitate data storage, retrieval, and manipulation. The framework is part of the `java.util` package and is widely used in Java programming for handling groups of objects.

### **Core Interfaces and Their Use Cases**

| Interface | Description                           | Common Implementations                |
| --------- | ------------------------------------- | ------------------------------------- |
| **List**  | Ordered collection, allows duplicates | `ArrayList`, `LinkedList`, `Vector`   |
| **Set**   | Unordered collection, no duplicates   | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Queue** | FIFO (First In First Out) structure   | `PriorityQueue`, `ArrayDeque`         |
| **Map**   | Key–Value pairs (unique keys)         | `HashMap`, `LinkedHashMap`, `TreeMap` |

| Feature              | Before Java 8            | After Java 8              |
| -------------------- | ------------------------ | ------------------------- |
| Filtering            | Manual loops             | `filter()`                |
| Mapping              | Create new list manually | `map()`                   |
| Sorting              | Anonymous `Comparator`   | Lambdas, method refs      |
| Removing items       | Iterator required        | `removeIf()`              |
| Processing map       | Loop through entries     | `map.forEach()`           |
| Grouping             | Complex code             | `Collectors.groupingBy()` |
| Combining operations | Hard                     | Streams allow chaining    |


**When to use what?**

**✔ Use filter() when:**

You want to apply a condition to all elements

Order does not matter

You want complete filtering

**✔ Use takeWhile() when:**

You want early termination for performance.
You are processing a sorted or ordered collection.
You want “read until condition fails”.

**Default Methods in Interfaces:**
* Default methods allow adding new methods to interfaces without breaking existing implementations.
* Before Java 8, adding a new method to an interface would break all implementations.
* With Default methods, Java can add methods without forcing all classes to override them.


 * Java 8 added new methods to interfaces like:

    Iterable.forEach()
   
     Collection.removeIf()

     Map.forEach()

      List.sort()
   
      These were added without breaking millions of existing classes.

**Unnamed variables & Pattern Matching (Java 21):**

    Java 21 introduced unnamed variables and pattern matching enhancements, allowing for more concise and readable code when working with collections.
 
    Ignore variables you don't need:
 
    if(obj instanceof Point(var x, _)) { ... }