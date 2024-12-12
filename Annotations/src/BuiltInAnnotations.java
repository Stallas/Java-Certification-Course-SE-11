
@FunctionalInterface
interface Functable{
    void performSomeFunction();
//    void doSomethingElse(); 2 compiler errors one on class itself and on interface as it's not F.I.
}

// Creating an abstract class with an abstract method and annotating with F.I. Compiler error on Annotation.
//@FunctionalInterface
//abstract class FunctionalClass{
//    abstract void performSomeFunction();
//}
public class BuiltInAnnotations implements Functable{

    public static void main(String[] args) {
        new BuiltInAnnotations().performSomeFunction();
    }
    @Override
    public void performSomeFunction() {
        System.out.println("Override Functionable's method");
    }

//  This is method overloading and not overriding
//    @Override
//    public void performSomeFunction() {
//        System.out.println("Override Functionable's method");
//    }
}
