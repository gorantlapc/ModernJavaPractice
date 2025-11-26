package org.pc.oops;

// Single Inheritance Example. Dog inherits Animal. Dog is a Animal. Is-a Relationship.
//It promotes code reusability.
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

public class InheritanceEx {
    void main() {
        try {
            Dog d = new Dog();
            d.eat();  // inherited from Animal
            d.bark(); // from Dog
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
