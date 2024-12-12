package Exceptions;

import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Exceptions in Initializers...
S1: Exception in static invocation. Then surround by try/Catch
S2: Exception from static initializer,JVM cannot recover from it. So, the static initializer
need to handle the situation by itself.
S3: So, Surround with try/catch in static initializer.
S4: We get a compiler error when we throw an Checked exception in catch clause not in case of unchecked.
 */
class StaticTest{
    public static String currentMessage;

    // Initialized to 0
    public static int currentVal;

    // Static Initializer
    /*
    static {
        System.out.println("Initializing class StaticTest");
        // We force an error for demonstration purposes
        if((10/currentVal) > 0){
            System.out.println("Whoops");
        }
        currentMessage = "Inside Static Initializer";
    }
    */
    // S3: surround with try/catch in static initializer , still exceptionInitializerError is thrown.
    /*
    static {
        System.out.println("Initializing class StaticTest");
        try {
            // We force an error for demonstration purposes
            if ((10 / currentVal) > 0) {
                System.out.println("Whoops");
            }
        }finally {
            currentVal = 1;
        }
        currentMessage = "Inside Static Initializer";
    }*/
    /*
        A finally clause is always executed, but if a new exception is not created in the finally clause, the JVM still looks for the calling method,to handler
    the exception, which does not happen here.

    This is true of any finally clause, not just one in a static initializer method.
    The JVM wont initialise the class, with the exception thrown, even though we have a finally clause.
    Can we catch and fix the exception ?

	yes, we can use try followed by catch in static initialiser block.
     */
    /* S4: We can handle the above situation by catch block in Static Initializer.
    S5: Adding throw clause i.e. CheckedExceptiom leads to compiler error.
    So change it to UncheckedException i.e. RuntimeException but now compiler error on runtime.
    S6: So comment it and Now, look at regular initializers
     */
    static {
        System.out.println("Initializing class StaticTest");
        try {
            // We force an error for demonstration purposes
            if ((10 / currentVal) > 0) {
                System.out.println("Whoops");
            }
        }catch (Exception e){
            System.out.println("Caught the error");
//            throw new RuntimeException("Got some error in the class initialization");
//            throw new Exception("Got some error in the class initialization");
        } finally{
            currentVal = 1;
        }
        currentMessage = "Inside Static Initializer";
    }

}
public class InitializerExceptions {

    /* S9: Create a subclass which extends InitializerExceptions...
     Results in compiler error(IOException), because we didnt create constructor for subclass therefore
     JVM implictly creates no-args constructor which will call super which does have throws declaration.
     Create a constructor...still error so add super() followed by try/catch still there occurs error
     stating call to super() should be first statement.
     So, the solution is to create no-args constructor that declares the throws exception with same level or broader one.
     */

    class SubClass extends InitializerExceptions{

//        SubClass(){// unhandled exception IOException so call super()
//            try {
//                super();
//            }
//            catch (Exception e){
//                System.out.println("Doing something...");
//            }
//        }
       SubClass() throws Exception{ // same or broader exception should be defined.
           super();// Note that call to super() is redundant statement.
       }
    }

    // Create an instance initializer block that throws an unchecked exception.
    /*
    S7:Since, checked exception results in compile error, we can handle it using try/catch as in Static initializer.
    But, there is another option for instance initializer, i.e. instance init block gets executed
    when the constructor is created. So , we can handle this in Constructor.
     */
    {
        int i = 0;
        if(i == 0) throw new IOException("Whoops");
    }

    // Constructor declares IOException in a throws clause.Comment it and check.
    InitializerExceptions() throws IOException {

    }

    /*
    Second constructor without a throws clause...
    S8: Add another constructor with single parameter, leads to compiler error.
    If there is a checked Exception in instance init, then all constructors should declare it or surround by try/catch
     */
//    InitializerExceptions(String parameterOne){
//        try {
//
//        }catch (IOException e){
//            System.out.println("I'm ignoring the error");
//        }
//    }
    public static void main(String[] args) {
        System.out.println("Executing main()");
        //S1: leads to ExceptionInitializationError
       // System.out.println(StaticTest.currentMessage );
        /* S2
        try{
            System.out.println(StaticTest.currentMessage );
        }catch (Exception e){
            StaticTest.currentVal = 1;
            System.out.println(StaticTest.currentMessage );
        }
         */
        System.out.println(StaticTest.currentMessage );

        // Test the constructor
        try{
            InitializerExceptions ie = new InitializerExceptions();
        }
        catch (Exception e){
            System.out.println("Ignoring the error, "+e.getMessage());
        }
    }



}
