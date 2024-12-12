package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:6. Create and implement interfaces
Sub-Topic: Abstract class implementing interface.
Benefits of abstract class through interface which does implement explicitly.
 */

// Interface with single abstract method and all non-concrete methods are public
// and abstract implicitly  on an interface.
interface Abstractable{
    void makeConcrete();
}

/*
An Abstract class does NOT have to define concrete methods for the
abstract methods the interface it implements.
 */
abstract class AbstractClass implements Abstractable{
    /*
    Create an additional abstract method -
    Note that this method is NOT public, but package-private and
    you must declare it abstract.
     */
    abstract void callConcrete();
//    abstract void makeConcrete(); // attempting to assign a weaker access privilege make it public
}
/*
AbstractableExamples extends AbstractClass (which in turn implements Abstractable).
The AbstractableExamples is required to implement all abstract methods defined by the interface and
not implemented by the abstract class as well as any abstract methods on the abstract class itself.
 */
public class AbstractableExamples extends AbstractClass{
    // Method required through extension of AbstractClass -
    // defined on the interface AbstractClass implements
    @Override
    public void makeConcrete() {
        System.out.println("methods declared on Abstractable interface");
    }

    // Method required through extension of AbstractClass
    @Override
    void callConcrete() {
        System.out.println("methods declared on AbstractClass class");
        makeConcrete();
    }

    public static void main(String[] args) {
        AbstractableExamples e = new AbstractableExamples();
        e.callConcrete();
    }
}
