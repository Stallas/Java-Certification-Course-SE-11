package LambdaExpressions;
/*
Section 10: Programming Abstractly TThrough Interfaces
Topic: Lambda Expressions
Sub-Topic: 3.Lambda Expression in Assignments.
 */
public class BinaryCalculator {
    /*
   We declare a functional interface as part of the class,
   A functional interface is an interface with one and only one abstract method.
    */
    interface BinaryIntegerOperation{
        int calculate(int a,int b);
    }
    /*
        We create a 'pass thru' method , accepting an object which implements our interface
        as a parameter. The other parameter is the number we'll be doing the operation on.
         */
    public int calculate(int a, int b, BinaryIntegerOperation op){
        return op.calculate(a,b);
    }
    public static void main(String[] args) {
        // We create an instance of the class
        BinaryCalculator myApp = new BinaryCalculator();

        /*
        This lambda expression demonstrates a typed parameter list
        Parenthesis are always required for multiple parameters.
        -- This operation will result in the values being added together.
         */
        BinaryIntegerOperation addition = (int a, int b) -> a + b;
        BinaryIntegerOperation sutraction = (a,b) -> a - b;
        BinaryIntegerOperation multiplication = (var a, var b) -> a * b;
        BinaryIntegerOperation division = (a,b) -> a / b;

//        BinaryIntegerOperation multiplication = (int a, b) -> a * b;
//        BinaryIntegerOperation division = a,b -> a / b;

        // Execution
        int value_a = 4;
        int value_b = 2;

        System.out.println("The numbers ("+value_a+", "+value_b+") added = "+myApp.calculate(value_a,value_b,addition));
        System.out.println("The numbers ("+value_a+", "+value_b+") subtracted = "+myApp.calculate(value_a,value_b,sutraction));
        System.out.println("The numbers ("+value_a+", "+value_b+") multiplied = "+myApp.calculate(value_a,value_b,multiplication));
        System.out.println("The numbers ("+value_a+", "+value_b+") divided = "+myApp.calculate(value_a,value_b,division));

    }
}
