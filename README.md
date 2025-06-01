# workshop-java-fundamental-may

A workshop for learning the fundamentals of Java programming. This repository contains exercises covering basic syntax,
object-oriented programming concepts, and more.

## Prerequisites

* Java Development Kit (JDK) installed (e.g., JDK 21 or later).
* An IDE like Visual Studio Code, IntelliJ IDEA, or Eclipse (optional, but recommended).
* Basic understanding of programming concepts.

## How to Run the Exercises

Each numbered directory (e.g., `01-starting-point`, `06-class`) and the `health` directory contains a separate set of
exercises or a mini-project.

1. **Navigate to the exercise directory:**

   Open your terminal or command prompt and change to the specific directory for the exercise you want to run. For
   example:

    ```bash
    cd 01-starting-point
    ```

   Or for exercises with packages:

    ```bash
    cd health
    ```

   Or

    ```bash
    cd 07-interface/part07
    ```

2. **Compile the Java files:**
   Use the `javac` command.

    * If the files are not in a package (e.g., in `01-starting-point`, `06-class`):

        ```bash
        javac *.java
        ```

    * If the files are in a package (e.g., `health`, `07-interface/part07`):

      From within the package directory (e.g., `health` or `part07`):

        ```bash
        javac *.java
        ```

      Or, from the parent directory of the package (e.g., `07-interface` for package `part07`):

        ```bash
        javac part07/*.java
        ```

3. **Run the main class:**
   Use the `java` command.

    * If the main class is not in a package:

        ```bash
        java Main
        ```

    * If the main class is in a package (e.g., `health.Main` or `interface_07.Main`):
      From the directory *above* the package structure (e.g., from `workshop-java-fundamental-may` if your `health`
      package is directly under it, or from `07-interface` if your `part07` package is under it):

        ```bash
        java health.Main
        ```

        ```bash
        java interface_07.Main
        ```

## Modules / Exercises

This workshop is divided into the following modules:

* **[01-starting-point](starting_point_014):** Introduction to Java syntax, primitive types, wrapper types, and arrays.
    * [`Main.java`](starting_point_01/Main.java)
    * [`Array.java`](starting_point_01/Array.java)
* **[06-class](06-class):** Understanding classes, objects, constructors, getters, setters, encapsulation, and
  inheritance.
    * [`Loan.java`](class_06/Loan.java)
    * [`Mortgage.java`](class_06/Mortgage.java)
    * [`Auto.java`](class_06/Auto.java)
    * [`Main.java`](class_06/Main.java)
* **[07-interface](07-interface/part07):** Working with interfaces and polymorphism. (Code is in `part07` package)
    * [`Loan.java`](07-interface/part07/Loan.java) (Interface)
    * [`Auto.java`](07-interface/part07/Auto.java)
    * [`Mortgage.java`](07-interface/part07/Mortgage.java)
    * [`Main.java`](07-interface/part07/Main.java)
* **[health](health):** A mini-project demonstrating classes, inheritance, and interfaces in a `health` package.
    * [`Worker.java`](health/Worker.java) (Superclass)
    * [`Doctor.java`](health/Doctor.java)
    * [`Nurse.java`](health/Nurse.java)
    * [`health.java`](health/Health.java) (Interface)
    * [`Main.java`](health/Main.java)

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
