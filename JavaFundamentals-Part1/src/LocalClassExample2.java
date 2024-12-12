/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals 
Topic:  Local Class
*/

abstract class AbstractClass {
    public abstract void doSomething();
}

interface Executable {
    void doSomething();
}

public class LocalClassExample2 {
    String name = "Doe";

    public static void main(String[] args) {
        String name = "Smith";

        // Local class can extend any class, including abstract one
        class A extends AbstractClass {
            public void doSomething() {
                System.out.println("name = " + name);
            }
            // Since this local class is defined in a static method, we can't use this.
            // LocalClassExample2.this.name leads to compiler error similarly if we remove local variable name.
        }

        // Local class can implement interfaces
        class B implements Executable {

            public void doSomething() {
                System.out.println("name = " + name);
            }
        }

        // Declaring a local abstract class
        abstract class C extends AbstractClass {

        }

        // Create a local class extending another local class
        class D extends C {
            public void doSomething() {
                System.out.println("name = " + name);
            }
        }

        // Execute code on instances of local classes
        new A().doSomething();
        new B().doSomething();
        new D().doSomething();
    }
}