package org.pc.oops;

//Compile Time Polymorphism Example - Method Overloading: Same method name with different parameters.
class MathUtil {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

//Run Time Polymorphism Example - Method Overriding: Subclass provides specific implementation of a method defined in superclass.
class Vehical {
    void start() {
        System.out.println("Vehical Started");
    }
}

class Car extends Vehical {
    @Override
    void start() {
        System.out.println("with key");
    }
}

class Bike extends Vehical {
    @Override
    void start() {
        System.out.println("kick start");
    }
}


public class PolymorphismEx {
    void main() {
        try {
            MathUtil mu = new MathUtil();
            System.out.println("Sum of integers: " + mu.add(5, 10)); // Calls int add(int, int)
            System.out.println("Sum of doubles: " + mu.add(5.5, 10.5)); // Calls double add(double, double)
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            Vehical myCar = new Car();
            Vehical myBike = new Bike();

            myCar.start();  // Outputs: with key
            myBike.start(); // Outputs: kick start
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
