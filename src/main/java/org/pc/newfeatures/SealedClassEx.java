package org.pc.newfeatures;

// Sealed Classes in Java
// A sealed class restricts which other classes or interfaces may extend or implement it.
sealed class Shape permits Circle, Rectangle {}
final class Circle extends Shape {
    double radius;
    Circle(double radius) { this.radius = radius; }
}
final class Rectangle extends Shape {
    double width, height;
    Rectangle(double width, double height) { this.width = width; this.height = height; }
}


public class SealedClassEx {
     static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        System.out.println("Created a Circle with radius: " + ((Circle)shape1).radius);
        System.out.println("Created a Rectangle with width: " + ((Rectangle)shape2).width + " and height: " + ((Rectangle)shape2).height);
    }
}
