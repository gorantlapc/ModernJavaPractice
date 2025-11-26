package org.pc.util.function;

/**
 * A functional interface for greeting messages.
 * Defines a single abstract method `greet` that takes a name as input
 * and returns a greeting message.
 *  @FunctionalInterface indicates that this interface is intended to be a functional interface.
 *  @author Punnaiah Chowdary Gorantla
 *  @version 1.0
 *  @since 2025-11-24
 */
@FunctionalInterface
public interface GreetingFunInterface {
    String greet(String name);

    default void printGreeting(String name) {
        System.out.println(getDefaultGreeting() + greet(name));
    }

    private String getDefaultGreeting() {
        return "Hello, ";
    }
}
