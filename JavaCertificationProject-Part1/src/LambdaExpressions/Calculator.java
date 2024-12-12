package LambdaExpressions;
/*
Section 10: Programming Abstractly TThrough Interfaces
Topic: Lambda Expressions
Sub-Topic: 2.Lambda Expression Parameter
 */
public class Calculator {

    /*
    We declare a functional interface as part of the class,
    A functional interface is an interface with one and only one abstract method.
     */
    interface UnaryIntegerOperation{
        int calculate(int a);
    }

    /*
    We create a 'pass thru' method , accepting an object which implements our interface
    as a parameter. The other parameter is the number we'll be doing the operation on.
     */
    public int calculate(int a, UnaryIntegerOperation op){
        return op.calculate(a);
    }

    public static void main(String[] args) {
        // We create an instance of the class
        Calculator myApp = new Calculator();

        // We create three objects using lambda expressions.

        /*
        This lambda expression demonstrates a single typed parameter in parentheses
        (if you specify type, you MUST use parenthesis)
        -- This operation will result in the value being squared.
         */
        UnaryIntegerOperation square = (int a) -> a * a;
        /*
        This lambda expression demonstrates a single untyped parameter in parentheses
        -- This operation will result in the value being squared.
         */
        UnaryIntegerOperation cube = (a) -> a * a * a;

        /*
        This lambda expression demonstrates a single untyped parameter without
        using parentheses
        -- This operation will result in the value being incremented by 1.
         */
        UnaryIntegerOperation increment = a -> a + 1;

         /*
        This lambda expression demonstrates a single untyped parameter without
        using parentheses. We are using curly braces to wrap the body
        -- This operation will result in the value being decremented by 1.
         */
        UnaryIntegerOperation decrement = a -> {
            return a - 1;
        };

        // Execution
        int value = 2;
        System.out.println("The number (" + value + ") squared = "+ myApp.calculate(value,square));
        // Here , actually compiler creates a method on fly that a * a right handside operator and returns a int i.e.(int a)
        System.out.println("The number (" + value + ") cubed = "+ myApp.calculate(value,cube));
        System.out.println("The number (" + value + ") incremented = "+ myApp.calculate(value,increment));
        System.out.println("The number (" + value + ") incremented = "+ myApp.calculate(value,decrement));
    }
}
