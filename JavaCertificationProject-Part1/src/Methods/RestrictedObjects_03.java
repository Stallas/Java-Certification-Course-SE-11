package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 3.Why to create a private constructor ?
 */
class OnlyClass{

    // private constructor, the ONLY constructor
    private OnlyClass(){
        System.out.println("Inside private constructor");
    }
    private int classVariable;
    // instances can be created within current class or a nested class
    private static final OnlyClass instance = new OnlyClass();

    // You can expose the only instance via a static method... i.e. singleton pattern
    public static OnlyClass getInstance(){
        return instance;
    }

    // Or you can make static methods which call methods on the protected instance
    public static void doSomething(){
        instance.doSomethingRestricted();
    }

    private void doSomethingRestricted() {
        this.classVariable++;
        System.out.println("Only one instance of this class exists or will ever exists");
    }
}
public class RestrictedObjects_03 {
    public static void main(String[] args) {
        OnlyClass.doSomething();
//        OnlyClass o = new OnlyClass();// has private access
    }
}
/* // you cannot extend OnlyClass except for nested class as didnt have a default constructor
 results in compiler error
class MyOnlyClass extends OnlyClass{

}
 */
