package org.pc.ocpjavase21;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class OCPExample {
    static void main() {
        String tb = """
    a \
  b\t
  c\s
  """;
        System.out.println(tb.length());


        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        var i1 = deque.peek(); // retrives but do not remove. head of the queue 1
        var i2 = deque.poll(); // retrives and removes from head of the queue 1
        var i3 = deque.peek(); // 2
        System.out.println(i1 + " " + i2 + " " + i3);

        StringBuilder result = Stream.of("a", "b")
                .collect(
                        () -> new StringBuilder("c"),
                        StringBuilder::append,
                        (sb1, sb2) -> sb2.append(sb1)
                );
        System.out.println(result);

        var executor = Executors.newVirtualThreadPerTaskExecutor();
        Future<Integer> f1 = executor.submit(() -> 5);
        Future<Integer> f2 = executor.submit(() -> 10);
        try {
            System.out.println(f1.get() + f2.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.close();

        record Point(int x, int y) { }
        Object obj = new Point(3, 4);
        if (obj instanceof Point(int a, int b)) {
            System.out.println(a + ", " + b);
        }

        Parent member = new Child();
        System.out.println(member.role);        // Parent (field access - compile-time)
        System.out.println(member.familyName()); // Smith (static method - compile-time)
        System.out.println(member.introduce());  // I am a Child (instance method - runtime)

    }




}
class Parent {
    public Parent(){
        System.out.println("no-arg constructor");
    }
    public Parent(String role) {
        this.role = role;
    }

    String role = "Parent";
    static String familyName() { return "Smith"; }
    String introduce() { return "I am a Parent"; }
}

class Child extends Parent {
    private String role = "Child";                      // Field hiding

    public Child() {
        System.out.println("Child no-arg constructor");
    }

    static String familyName() { return "Johnson"; }  // Method hiding
    String introduce() { return "I am a Child"; }     // Method overriding
}
