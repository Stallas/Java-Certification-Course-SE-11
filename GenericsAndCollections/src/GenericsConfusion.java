/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Generics, Confusing type parameters
*/

import java.util.ArrayList;
import java.util.List;

// class Container, a generic class with one type parameter
//Its no longer java.lang.Number but Number. less confusing if we had used E or T.
class Container<Number> {

    // instance variable
    Number myNumber;

    // Constructor
    Container(Number myNumber) {
        this.myNumber = myNumber;
        System.out.println(this);
    }

    // overridden toString() method
    public String toString() {
        return myNumber.toString();
    }

}

public class GenericsConfusion {
    public static void main(String[] args) {
        // Declare Container with String type argument
        Container<String> c1 = new Container<>("Hello");

        // Declare Container with String type argument
        Container<Integer[]> c2 = new Container<>(new Integer[]{1, 2, 3, 4});

        // Declare Container with UnknownError type argument
        Container<UnknownError> c3 =
                new Container<>(new UnknownError("Testing"));

        // Overloaded constructors
        CardboardContainer<String> n1 =
                new CardboardContainer<String>("Hello");

        CardboardContainer<String> n2 =
                new CardboardContainer<>(3);// compiler error if T instead of V hence <String>

        CardboardContainer<String> n3 =
                new <Integer>CardboardContainer<String>(3);

//        If both sides Numbers, output [10,10.0,10]. Both sides Integers, compiler error on line 1,2
//        List<Number> list = new ArrayList<Integer>();// compiler error
//        list.add(10L);    // line 1
//        list.add(10.0);   // line 2
//        list.add(10);
//        System.out.println(list);
    }
}

class CardboardContainer<T> {
    T myField;

    CardboardContainer(T myField) {
        System.out.println("In T constructor");
        this.myField = myField;
    }

    /*
    The constructor has Type parameter T which hides the type parameter T og generic class
    The Type of the parameter passed to this constructor may not be same type as of instance type
    That why constructiondeclaration was allowed, the overloaded constructors do not have the same
    signature.
     */
    /*
    <T extends Number> CardboardContainer(T myField) {
        System.out.println("In T2 constructor");
//        this.myField = myField;
    }
     */
    <V extends Number> CardboardContainer(V myField) {
        System.out.println("In T2 constructor");
//        this.myField = myField;
    }
    // Clashing constructor. compiler error on first one
    /*
    <T> CardboardContainer(T myField) {
        System.out.println("In T2 constructor");
    }
      */
}