package Inheritance.AbstractClasses;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 8.Abstract classes
 */
abstract class AbstractExample {

    // A constant can be defined on an abstract class.
    public static final String ABSTRACT_CONSTANT = "Abstract";

    // a final static method can be declared on an abstract class
    public static final void doThisAndOnlyThis() {
        System.out.println("A final static method is ok in an abstract class");
        System.out.println("My constant is : " + ABSTRACT_CONSTANT);
    }

    // This is a final method which means any subclass can call it but can't override it.
    public final void doThisAndThat() {
        System.out.println("A method may be final but it can still support polymorphism");
        System.out.println(doThis() + " and " + doThat());
    }

    // Implementing classes need to implement abstract methods
    abstract String doThis();

    abstract String doThat();
}
    // concreteExample implements the two abstract methods it inherits,
 class ConcreteEx extends AbstractExample{
        @Override
        String doThis() {
            return "I do this";
        }
        @Override
        String doThat() {
            return "I do that";
        }

    }
    // Now we test our final methods..
    public class AbstractClassExample{
        public static void main(String[] args) {

            // call to the final static method...
            ConcreteEx.doThisAndOnlyThis();
            // call to the final method defined on abstract parent
            ConcreteEx c = new ConcreteEx();
            c.doThisAndThat();
        }
    }

