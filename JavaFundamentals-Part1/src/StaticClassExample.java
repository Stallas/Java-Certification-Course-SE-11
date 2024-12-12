/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 1: Java Fundamentals
Topic 2: Nested Classes
Subtopic: Static Nested Classes
This class tests the method outside the package and executes successfully as everything declared are public...
We get a compiler error when our import statement is nest.EnclosingClass.NSC and invoking is
EnclosingClass.staticName.... and static import is not mandatory.
*/


import static nest.EnclosingClass.NestedStaticClass;
// import nest.EnclosingClass; all fields/methods invoked as in line 1 i.e. using class reference.
//import nest.EnclosingClass.NestedStaticClass;// we get compiler error on line 1

public class StaticClassExample {
    public static void main(String[] args) {
        // Reference static field on static nested class directly:
//        System.out.println(EnclosingClass.NestedStaticClass.staticName);//line 1
        System.out.println(NestedStaticClass.staticName);

        // Reference static method on static nested class directly:
        System.out.println(NestedStaticClass.getStaticName());

        // Reference enum on static nested class directly:
        System.out.println(NestedStaticClass.Colors.BLUE);

        // Local variable declaration using a nested class's interface
        NestedStaticClass.NestedInterface n;

        // Create an instance of the static class.
        NestedStaticClass nInstance = new NestedStaticClass();
        System.out.println(nInstance.getInstanceName());

    }
}