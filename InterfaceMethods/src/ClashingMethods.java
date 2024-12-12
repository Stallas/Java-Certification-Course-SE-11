/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Method clashing
*/
// we can't override defa
interface FirstInterface {
    // private method
//    private void methodA() {
//        System.out.println("FirstInterface's private method A");
//    }
    default void methodA() {
        System.out.println("FirstInterface's default method A");
    }
}

interface SecondInterface {
    // static (and public) method
//    static void methodA() {
//        System.out.println("SecondInterface's private method A");
//    }
    default void methodA() {
        System.out.println("SecondInterface's default method A");
    }
}
public class ClashingMethods implements FirstInterface {
    public static void main(String[] args) {
        ClashingMethods first = new ClashingMethods();
        // Calling static method on an interface
//        SecondInterface.methodA;
        first.methodA();// compiler error if methodA is static including using objects or this

    }
}