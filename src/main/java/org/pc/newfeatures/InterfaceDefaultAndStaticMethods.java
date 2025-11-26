package org.pc.newfeatures;

import java.util.Arrays;
import java.util.List;

/* Collections interfaces like List, Set, and Map got default and static methods
    * Default methods allow adding new methods to interfaces without breaking existing implementations.
    * Before Java 8, adding a new method to an interface would break all implementations.
    * With Default methods, Java can add methods without forcing all classes to override them.
    * Static methods in interfaces provide utility functions related to the interface.
    * Example: List interface has default method forEach() and static method of() to create immutable lists.
 */

public class InterfaceDefaultAndStaticMethods {
    static void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.forEach(System.out::println); // default method in Iterable

        List.of("A", "B", "C"); // static factory method (Java 9+)

    }
}
