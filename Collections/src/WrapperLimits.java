/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Wrappers and Generics
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapperLimits {
    public static void main(String[] args) {

        // Here a float literal can be assigned to a double variable
        double d = 32.0f;

        // Here a float literal can be part of array initialization for
        // a double array
        double[] doubleArray = new double[]{32.0f};

        System.out.println("Primitive assignment, float to double: "
                + d);
        System.out.println("Primitive array initialization assignment," +
                " float to double: " + Arrays.toString(doubleArray));

        // An autoboxed float -> Float cannot be assigned to a Double
//      Double wrapper= 32.0f;
        Float wrapper= 32.0f;

        // An array of double wrappers cannot be initialized to array
        // of primitive float
//        Double[] wrappedArray = new Double[]{32.0f};
        Float[] wrappedArray = new Float[]{32.0f};

        // A List of float literals cannot be passed to constructor of Double
        List<Double> doubleList = new ArrayList<Double>(List.of(32.2));//32.2f

        // Cannot add a literal float to a List of Double
        List<Double> doubleList2 = new ArrayList<Double>();
        doubleList2.add(32.2);//32.2f

        // Typing only on the assignment side does not place compiler error
        // restrictions on elements added. still runs with no exception
        List numberList = new ArrayList<Integer>();// assigning to raw variable list
        numberList.add("Hello");
        numberList.add(3.2f);
        numberList.add(List.of("a", "b"));

//        List<Number> integerList = new ArrayList<Integer>();// compiler error
//        List integerList = new ArrayList<Integer>();//valid
//        List<?> integerList = new ArrayList<Integer>(); integerList.add(5); // adding an exception to array type
//        List<? extends Number> integerList = new ArrayList<Integer>();integerList.add(5);//could actually reference short for eg
        List<? super Integer> integerList = new ArrayList<Integer>();
        integerList.add(5);
//        integerList.add(10L);
        integerList.add((int) 10L);
//        integerList.add((Integer) 10L);
    }
}