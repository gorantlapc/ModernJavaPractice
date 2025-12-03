package org.pc.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExaceptionHandlingInOverriding {
    public static void main(String[] args) {
        B b = new B();
        try {
            b.m();
        } catch (FileNotFoundException e) {

        }
    }
}

// FileNotFoundException ⟶ subclass of IOException → narrower → allowed.
class A {
    void m() throws IOException { }
}

class B extends A {
    void m() throws FileNotFoundException { }
}

