/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 4: Generics and Collections
Topic:  Using  wrapper classes, operators
*/

public class WrapperOperators {
    public static void main(String[] args) {

        Integer i = 10;
        short j = 10;

        // A wrapper used in most operations is unboxed prior to the 
        // operation

        // result of a wrapper and primitive can be assigned to a primitive
        // variable
        int intResult = i + j;

        // result of a wrapper and primitive can be assigned to a wrapper
        // variable
        Integer integerResult = i + j;

        // result of a wrapper and primitive can be assigned to a 
        // LVTI variable using var
        var result = i + j;

        System.out.println("intResult (type int) = " + intResult);
        System.out.println("integerResult (type Integer) = " + integerResult);
        System.out.println("result (LVTI) = " + result);
/*
        // what is the result ? LVTI is not an object and hence we cant call the Object methods
        System.out.println(result.getClass().getName());

        // Can we assign the value to a short ?
        short shortResult = i + j; // Compiler error if both i and j are short

        // Can we assign the value to a Short ?
        Short ShortResult = i + j;// Compiler error if both i and j are Short or either one of it.
*/
        Integer k = 10;
//        Short s = 10; // results in Compiler error s instanceOf Integer
        Number s = Short.valueOf("10"); // allows the code to compile.
        int m = 10;
        if (s instanceof Number) {
            System.out.println(" s is instance of Number ");
            if (s instanceof Integer) { // m instanceOf Integer results in compiler error
                System.out.println(" m is instance of Integer ");
            }
        }
    }
}