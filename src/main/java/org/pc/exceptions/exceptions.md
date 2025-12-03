                Throwable
                /        \
        Exception        Error
           /    \
Checked    Unchecked(RuntimeException)

**Checked Exceptions**
* known at compile time
* must be handled by **try/catch** or declared by using **throws**
* Examples: IOException, SQLException, ClassNotFoundException

**Unchecked Exceptions**
* Knows at run time
* not required to handle explicitely
* Examples: NullPointerException, ArrayIndexOutOfBoundException, ArithematicException

**Errors**
* Serious Problems, Not recommended to handle
* Examples: OutOfMemoryError, StackOverflowError

**Throws**
* Used when method does not handle the exception

**Throw**
* Used to manually throw an exception

**Difference between throw and throws?**

| throw                | throws                       |
| -------------------- | ---------------------------- |
| Used inside method   | Used in method signature     |
| Throws one exception | Declares multiple exceptions |
| Runtime decision     | Compile-time rule            |

**ClassNotFoundException** → JVM looks for a class 
but cannot find it.

**NoClassDefFoundError** → JVM expected the class 
because it existed at compile time, but cannot load its definition at runtime.