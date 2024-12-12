/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Default methods
*/

public interface Defaultable {

    String abstractValue = "ABSTRACT";

    void abstractMethod();

    default void defaultNotAbstractMethod() {
        System.out.println("Testing Default");
    }

//    void anotherAbstractMethod(); This leads to compiler error in ImplementingClass
//    as well as lambda exp (functional interface i.e. only one abstract method in interface concept).

//    limitation of default methods : you cannot declare a default method that would override any
//    of java.lang.Object public methods.
/*    default String toString(){
        return "This is Object class method";
    }
 */
}

// Class implements Defaultable interface
class ImplementingClass implements Defaultable {
    public void abstractMethod() {
        System.out.println("ImplementingClass" +
                " implements interface's abstract method");
    }
}

// Class which uses the interface in a method as a parameter type.
// we can execute the first 2 methods without any extend / implement.
class DefaultClass extends BaseClass implements Defaultable {

    public static void main(String[] args) {
        // Instantiate the current class.
        DefaultClass dc = new DefaultClass();

        // Pass instance of implementing class to method using interface
        dc.callAbstractMethod(new ImplementingClass());

        // Pass lambda expression to methexod using interface
        dc.callAbstractMethod(() -> System.out.println("Lambda Expression" +
                " implements interface's abstract method"));

        // Call method directly..
        dc.abstractMethod();

    }

    // Method has a parameter of type Defaultable
    public void callAbstractMethod(Defaultable d) {
        // Execute implementing object's abstractMethod
        d.abstractMethod();
    }

    public void abstractMethod() {
        // Which method is this from (interface or BaseClass?) SuperClass is used
        defaultNotAbstractMethod();
    }
}

// Create a base class that has method with same signature default
// method in interface
class BaseClass {
    public void defaultNotAbstractMethod() {
        System.out.println("Testing defaultNotAbstractMethod on class");
    }
}