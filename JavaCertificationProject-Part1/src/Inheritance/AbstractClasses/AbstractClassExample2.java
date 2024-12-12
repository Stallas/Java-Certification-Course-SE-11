package Inheritance.AbstractClasses;

// Abstract class
abstract class ConceptualClass{

    // protected no-args constructor... change it to private
//    protected ConceptualClass(){
//
//    }

    private ConceptualClass(){

    }
    // changing private to protected to resolve the error
    protected ConceptualClass(String s1){
        printSomething(s1);
    }
    // abstract method
    public abstract void printSomething(String s);
}
// Concrete class
class RealClass extends ConceptualClass{

    // No-args constructor
    public RealClass(String s){
        super(s);
    }
//    // constructor with two parameters
//    public RealClass(String s1, String s2){
//
//    }
    @Override
    public void printSomething(String s) {
        System.out.println(s);
    }
}
public class AbstractClassExample2 {
    public static void main(String[] args) {

        // Create an instance of Concrete class with no-args constructor
//        RealClass c = new RealClass();
        RealClass c = new RealClass("Hello");

        //Execute method on object with the standard text.
        c.printSomething("Hello World");

    }
}
