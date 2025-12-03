package org.pc.exceptions;

/*
 Handling checked exception and unchecked exception
 */
public class ExceptionHandling {

    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.calculateTax(0);

        // Checked Exception handling
        try {
            Class<?> className = Class.forName("org.pc.util.generics.Employee");
            System.out.println(className.getSuperclass().getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // multiple catch blocks ( Java 7 multi-catch)
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    /*
       unchecked exception handling
     */
    void calculateTax(int amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Amount cannot be negative");
        }
    }
}
