/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 5: Functional Interface and Lambda Expressions
Topic:  Functional Interface Examples
*/

// package-private functional interface with Single-Abstract-Method
interface Doable {
    void doIt();
}

public class FunctionalInterface {

    // private nested functional interface
    private interface Shapeable {
        void shapeIt();
    }

    public static void main(String[] args) {

        // Anonymous class implements Doable interface
        Doable d = new Doable() {
            public void doIt() {
                System.out.println("Anonymous class invoking doIt()");
            }
        };
//        Doable d2 = () ->
//                System.out.println("Lambda Expression invoking doIt()");
        // Lambda Expression assigned to a ExtendedDoable local variable
        ExtendedDoable d2 = () ->
                System.out.println("Lambda Expression invoking doIt()");

        // Anonymous class implements Shapeable interface
        Shapeable s = new Shapeable() {
            public void shapeIt() {
                System.out.println("Anonymous class invoking shapeIt()");
            }
        };

        // Lambda Expression assigned to a Shapeable local variable
        Shapeable s2 = () ->
                System.out.println("Lambda Expression invoking shapeIt()");

        System.out.print("main executes anonymous class d.doIt(): ");
        d.doIt();
        System.out.print("main executes anonymous class s.shapeIt(): ");
        s.shapeIt();
        s2.shapeIt();
        // Execute method passing anonymous class
        doItWithDoable(d);
        // Execute method passing anonymous class
        doItWithShapeable(s);

        // Execute method passing local variable with lambda expression
        doItWithDoable(d2);
        // Execute method passing local variable with lambda expression
        doItWithShapeable(s2);

    }

    // Pass through method to execute Interface method
    private static void doItWithDoable(Doable d) {
        d.doIt();
        if (d instanceof ExtendedDoable) {
            System.out.print("doItWithDoable executes d.extendedDoIt(): ");
            ((ExtendedDoable) d).extendedDoIt();
        } else {
            System.out.print("doItWithDoable executes d.doIt(): ");
            d.doIt(); // Default method implementing doIt()
        }
    }
    // Pass through method to execute Interface method
    private static void doItWithShapeable(Shapeable s) {
        System.out.print("doItWithShapeable executes s.shapeIt(): ");
        s.shapeIt();
    }
}

// Extending interfaces... A functional interface can have no abstract methods
// in the body if it extends another interface. comment the entire body and check it.
interface ExtendedDoable extends Doable {

// Let's try adding an abstract method extendedDoIt() leads to compiler error in lambda exp
// as 2 abstract methods doIt() and extendedDoIt() present so override the doIt() method.
//    void doIt();

    // Now, changing to default leads to compiler error as there is no abstract method hence adding extendedDoIt().
    default void doIt() {// we cannot override inherited abstract method with private/static
        System.out.println("Default method implementing doIt()");
    }
    void extendedDoIt();
}
/*
interface ExtendedDoable extends Doable,Comparable {
 leads to compiler error in lambda expressions as ExtendedDoable is no longer functional interface
 as it is inheriting 2 interfaces.
}

 */
