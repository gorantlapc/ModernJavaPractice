When we can add defaults in interfaces, we can evolve APIs more easily. 
This is especially useful for widely used interfaces in the Java Collections Framework.

When we can add default methods in interfaces, Why do we still need abstract classes?
* Abstract classes are useful when we want to provide a common base implementation for related classes.
* They allow us to define both abstract methods (to be implemented by subclasses) and concrete methods (with default behavior).
* Abstract classes can have instance variables to maintain state, which interfaces cannot.
* Abstract classes support constructors, allowing us to initialize common state for subclasses.
* Interfaces can have abstract methods and default methods, but abstract classes allow private methods, protected methods, package-private methods,final methods, synchronized methods, static methods, template methods, and constructors.

**When to Use What?**

✔ Use Interface when:

    You define a capability (e.g., Comparable, Runnable)

    No shared state

    Multiple inheritance is useful

✔ Use Abstract Class when:

    You need shared fields

    You need constructors

    You want to enforce a strong inheritance hierarchy

    You have shared logic that belongs to a base class