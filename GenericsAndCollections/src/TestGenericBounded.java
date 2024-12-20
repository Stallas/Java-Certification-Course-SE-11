/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generic Classes, Upper Bound Examples
*/

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

// Generic class, unbounded
class GenericNotBounded<T> {
    // field declared to be parameter type
    T instanceT;

    // no args constructor
    GenericNotBounded() {

    }

    // single argument, declared as parameter type
    GenericNotBounded(T t) {
        this.instanceT = t;
        System.out.println("GenericNotBounded: instanceVariable (" +
                t.getClass().getName() + ") = " + t);
    }
}

// Generic class with an upper bound of the abstract class Number
class GenericClassBound<T extends Number> {

    public int getIntValue(T t) {
        // Number's methods are available to any object of type T
        return t.intValue();
    }

    public int getByteValue(T t) {
        return t.byteValue();

    }
}

// Generic class: upper bound of Comparable Interface
class GenericInterfaceBound<T extends Comparable> {

    public void doSomething(T t1, T t2) {

        // Comparable's methods are available to any object of type T
        int comparison = t1.compareTo(t2);
        if (comparison > 0) {
            System.out.println(t2 + " is behind " + t1);
        } else {
            System.out.println(t2 + " is ahead of " + t1);
        }
    }
}

public class TestGenericBounded {
    public static void main(String[] args) {

        // Instances of unbounded generic class. Types can be
        // totally disparate
        GenericNotBounded<Integer> g1 = new GenericNotBounded<>(10);
        GenericNotBounded<Exception> g2 = new GenericNotBounded<>(new Exception());

        // Instances of generic class bounded by Number
        GenericClassBound<Byte> c1 = new GenericClassBound<>();
        System.out.println("GenericClassBound<Byte>.getIntValue() = "
                + c1.getIntValue(Byte.parseByte("10")));

        GenericClassBound<Integer> c2 = new GenericClassBound<>();
        System.out.println("GenericClassBound<Integer>.getIntValue() = "
                + c2.getIntValue(128));
        System.out.println("GenericClassBound<Integer>.getByteValue() = "
                + c2.getByteValue(128));

        // Instances of generic class bounded by Comparable
        GenericInterfaceBound<LocalDate> i1 =
                new GenericInterfaceBound<>();
        i1.doSomething(LocalDate.now(),
                LocalDate.of(2019, Month.SEPTEMBER, 29));

        GenericInterfaceBound<Float> i2 = new GenericInterfaceBound<>();
        i2.doSomething(12.34f, 12.345f);

        // You can use a typed generic class as a parameter to another
        // generic class.
        GenericNotBounded<GenericClassBound<Integer>> e =
                new GenericNotBounded<>(c2);

//        GenericClassBound<Boolean> c3 = new GenericClassBound<>();
//        GenericInterfaceBound<Exception> i3 = new GenericInterfaceBound<>();

    }
}

// Generic class, uses class and multiple interfaces for upper bound.
// Type arguments limited to subclasses of Number, implementing both
// Comparable and Serializable interfaces
class GenericMixedBounded<T extends Number & Comparable & Serializable> {

}

//class GenericMixedBounded<T extends  Comparable & Serializable & Number> {
//
//}

// Generic Class demonstrating that a generic class or interface can be used to specify an
// Upper Bound
class GenericNumberBounded<T extends Number & Comparable<Integer>>{

}
// Introduces compile time error as duplicate same generic interface.
//class GenericNumberBounded1<T extends Number & Comparable<Integer> & Comparable<Short>>{
//
//}
// Note we havent used & , instead comma. Here Comparable is defined as type parameter and has nothing
// to do with the Comparable interface.
/*
class GenericNumberBoundeds<T extends Number , Comparable>{
    T myNumber;
    Comparable myComparable;

    public int getValue(Comparable c){
        return this.compareTo(c);// compiler error
    }
}
 */