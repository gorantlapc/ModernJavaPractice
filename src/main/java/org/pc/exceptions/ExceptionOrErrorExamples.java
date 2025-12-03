package org.pc.exceptions;

public class ExceptionOrErrorExamples {
    public static void main(String[] args) {
        try {
            throw new Error();
        } catch (Exception e) {
            System.out.println("A");
        } catch (Throwable t) {
            System.out.println("B");
        }

        // throw null; → throws a NullPointerException
        try {
            throw null;
        } catch (NullPointerException e) {
            System.out.println("X");
        }

        // System.exit() stops JVM, finally does not execute.
        try {
            System.exit(0);
        } finally {
            System.out.println("Bye");
        }

        // Finally runs then exception terminates the program
        try {
            int x = 10 / 0;
        } finally {
            System.out.println("F");
        }
        System.out.println("End");
    }
}
