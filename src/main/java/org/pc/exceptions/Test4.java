package org.pc.exceptions;

class R implements AutoCloseable {
    public void close() {
        System.out.print("C");
    }
}

public class Test4 {
    public static void main(String[] args) {
        System.out.print(m());
    }

    static String m() {
        try (R r = new R()) {
            return "T";
        } finally {
            System.out.print("F");
        }
    }
}
