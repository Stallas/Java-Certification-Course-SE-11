package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:5. Create and implement interfaces
 */

// Create an interface with a default method and one abstract method
interface Extendable{
    default void defaultMethod(){
        System.out.println("Extendable: Default method called.");
    }
    void extend();
}

// an interface can extend another interface
interface SubExtendable extends Extendable{
    void append();// uncomment it and run
}
public class ExtendInterface implements SubExtendable {
    @Override
    public void extend() {
        // You can call the interface's default method from the concrete method you create.
        defaultMethod();
        append();
    }
    @Override
    public void append(){
        System.out.println("Appending functionality");
    }

    public static void main(String[] args) {
        ExtendInterface ei = new ExtendInterface();
        ei.extend();
//        ei.defaultMethod();
    }
}
