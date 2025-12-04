**What is JUnit and why is it used?**

JUnit is a Java testing framework used to write repeatable unit tests. 
It helps ensure code correctness and supports TDD.

Junit5 is Modular(JUnit Platform + Jupiter + Vintage). 
Parameterized tests are very powerful.

**How do you run only specific tests?**

mvn test -Dtest=MyTestClass

**How do you test exceptions?**

assertThrows(IllegalArgumentException.class, () -> method());

**What is the difference between @BeforeEach and @BeforeAll?**

@BeforeEach: runs before each test

@BeforeAll: runs once per class (must be static)

**What is mocking?**

Creating fake objects to isolate unit testing without calling real dependencies

**What does @SpringBootTest do?**

Starts the full Spring context (slow but complete).

**Difference between @WebMvcTest and @SpringBootTest?**

@WebMvcTest	Only web layer (controllers)

@SpringBootTest	Entire application context

**What are test fixtures?**

Common setup shared by multiple tests

**What are parameterized tests?**

Tests that run multiple times with different values

**What is the difference between unit tests and integration tests?**

| Type         | Unit Test   | Integration Test    |
| ------------ | ----------- | ------------------- |
| Scope        | Small piece | Multiple components |
| Speed        | Fast        | Slower              |
| Dependencies | Mocked      | Real                |

**What is a test suite?**

A group of test classes executed together

**How to disable a test temporarily?**

@Disabled("Temporarily disabled until bug is fixed")
