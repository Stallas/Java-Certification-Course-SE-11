package Exceptions;

import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Catch Examples
You can wrap any code or no code as long as try/catch block are not enclosed with checked exceptions.
S2: compiler error occurs when given checked exceptions.
(Checked exceptions are 2 way street ,i.e. you cannot use them unless they are in catch clause and throws declaration.
)
S3: Add 2 more methods SuperClass and Subclass. This fixes the C.T error on checkedException
S4: Handle multiple exceptions.
S5: Multiple exception declaration comes with limitation that they are implictly final means they
cannot be assigned with new exceptions. So to fix error add RTE temp.
S6: Adding ArithmeticException. The above limitation works incase of single exception.
 */
class CustomThrowable extends Throwable{
    CustomThrowable(String message){
        super(message);
    }
}
class CustomException extends Exception{
    CustomException(String message){
        super(message);
    }
}
class SuperClass{
    public void methodSuperClass() throws CustomException{

    }
}
class SubClass extends SuperClass{
    public void methodSubClass(){
        try{
            methodSuperClass();
        } catch (Exception CustomException) {
            // ignore it..
        }

    }
}

public class CatchExamples {
    public static void main(String[] args) {
        CatchExamples ce = new CatchExamples();

        // Reminder, Throwable or custom subclasses of Throwable and any
        // RuntimeException descendants are checked.
     /*  S1
        try {

        } catch (Throwable e){

        }
        //--------------------------------
        try {

        }catch (Exception e){

        }
        //-----------------------------------
        try {

        } catch (Error e){

        }
        //--------------------------------
        try {

        }catch (RuntimeException e){

        }*/
        /*S3
        try { // fixed the CustomException compiler error by calling superclass method which has throws declaration.
            SubClass c = new SubClass();
            c.methodSuperClass();
//            c.methodSubClass(); // Still compiler error as error isnt propagated
        }catch (CustomException e){

        }

      */
        /* S2: compiler error occurs when given checked exceptions.
        try {

        } catch (CustomThrowable e){

        }
        //--------------------------------
        try {

        }catch (CustomException e){

        }
         */
     /*   //S4
        try {
            SubClass c = new SubClass();
            c.methodSuperClass();
            ce.testError();
        }
        // Compiler error when CustomException | RTE | Throwable because both derivate of Throwable class
        // They should be disjoint.CustomException | RTE | IOException (C.T error as IOException is
        // never thrown) so add c.testError() fixes it as it has IOException in throws declaration.
        catch (CustomException | RuntimeException | IOException e){
//            e = new CustomException("So many exceptions, so little time");
            throw  new RuntimeException("So many exceptions, so little time");
        }

      */
        // S6
        try {
            SubClass c = new SubClass();
            c.methodSuperClass();
            ce.testError();
        }// defining catch blocks from most-specific to least-specific else compiler error
        catch (ArithmeticException e){
            e = new ArithmeticException("This works");
            throw e;
        }
        catch (CustomException | RuntimeException | IOException e){
//            e = new ArithmeticException("This works"); // implicitly final for multiple exceptions...
            throw  new RuntimeException("So many exceptions, so little time");
        }
    }

    private void testError() throws IOException{
        // We'll complete this later
    }
}
