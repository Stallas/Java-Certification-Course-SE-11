package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:6. Create and implement interfaces
Sub-Topic: Ambiguous variables and conflicting methods.
When extending an abstract class and implementing an interface, ambiguous occurs in 2 cases:
1. Same constant name
2. Same return type of methodSignature ... change Object to Integer
 */

// interface Confusable has a constant name and abstract method
interface Confusable{
    String name = "Confusable";

    String confuse();
}
// Abstract class Confused has a constant name and abstract method
abstract class Confused{
    public static String name = "Confused";

    abstract Object confuse();// Same method signature as Interface but different return type
    // Change Object to Integer
}

// AmbiguousExample will demonstrate some problem with multiple inheritance of type
public class AmbiguousExample extends Confused implements Confusable{
    @Override
    public String confuse() {
//        return name;// results in Ambiguous name
        return Confused.name; // return Confusable.name;
    }

    public static void main(String[] args) {
        AmbiguousExample e = new AmbiguousExample();
        System.out.println("The method confuse returns: "+ e.confuse());
    }
}
