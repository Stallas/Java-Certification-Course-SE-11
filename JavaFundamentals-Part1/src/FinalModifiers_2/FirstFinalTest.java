package FinalModifiers_2;
/*
    Section 1: Java Fundamentals
    Topic 1: Final modifier used with classes.
 */
// The following class is a class with no modifiers which means we can
// use it to subclass ,and we can override methods except final methods.
class ExtendMeOptional{
    //Adding a private constructor i.e. no-args constructor is similar to final class
    // as we can't extend the class and prevents from being instantiated.
    //    private ExtendMeOptional(){}

    //This method is valid for overriding
    public void doSomething(){
        System.out.println("Overriding ExtendMeOptional.doSomething is optional");
    }
    // A final method in a non-final class cannot be overridden by a subclass
    public final void doSomethingFinally(){
        System.out.println("Overriding ExtendMeOptional.doSomething is NOT optional");
    }
}

// The following class is a class with the final modifier which means we can NOT
// use it to subclass.
final class ExtendMeNotAllowed{
//    private ExtendMeNotAllowed(){} // Prevents an instance of creating a class was a goal.
    public void doSomething(){
        System.out.println("Overriding ExtendMeNotAllowed.doSomething is NOT optional");
    }
    // A final modifier here is redundant since there will be no subclass to override this method
    public final void doSomethingFinally(){
        System.out.println("Overriding ExtendMeNotAllowed.doSomething is NOT optional");
    }
}
public class FirstFinalTest {
    public static void main(String[] args) {

        // Create an instance of the non-modified class and execute it's methods.
        ExtendMeOptional objA = new ExtendMeOptional();
        objA.doSomething();
        objA.doSomethingFinally();
        // Create an instance of the final modified class and execute it's methods.
        ExtendMeNotAllowed objB = new ExtendMeNotAllowed();
        objB.doSomething();
        objB.doSomethingFinally();
        // Create an instance of our extended class and execute it's methods.
        MyFirstExtendedClass objC = new MyFirstExtendedClass();
        objC.doSomething();
        objC.doSomethingFinally();
    }
}
class MyFirstExtendedClass extends ExtendMeOptional{
    //This method is valid for overriding
    public void doSomething(){
        System.out.println("This method is better for my subclass than the original " +
                "ExtendMeOptional.doSomething");
    }
// Compiler error when overriding final methods...
//    public final void doSomethingFinally(){
//        System.out.println("Overriding ExtendMeOptional.doSomething is NOT optional");
//    }
}
