package org.pc.util.function;

public class FunctionalInterfaceMain {
    static void main() {

        System.out.println("Functional Interface Example");

        // Simple implementation of the functional interface using lambda expression
        GreetingFunInterface greetingFunInterface = name -> name + "!";
        greetingFunInterface.printGreeting("Alice");

        // Using method reference to implement the functional interface
        GreetingFunInterface formalGreeting = FunctionalInterfaceMain::prepareMessage;
        formalGreeting.printGreeting("Chowdary");
    }

    private static String prepareMessage(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("Good day, ").append(name).append(". It is a pleasure to meet you.");
        return sb.toString();
    }
}
