package Exceptions;

import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Finally throws Exception

 */
public class AFinalTry {
    public static void main(String[] args) {
        someMethodThrowsException();
    }
    /* // Compiler error occurs in parent clause as unhandled exception
    //so let's see what happens when thrown from finally block
    public static void someMethodThrowsException() throws IOException{
        try {
            System.out.println("Doing something");
        }
        catch (Exception e){
            throw new IOException("Testing Catch");
        }
    }
     */
    public static void someMethodThrowsException(){
        try {
            System.out.println("Doing something");
        }
        catch (Exception e){
            throw new IOException("Testing Catch");
        }
        /* Here no compiler error on calling method , why not ?
        the catch clause throws IOException but the actual error is thrown from
        the finally block. which is an unchecked exception and try/catch block in
        the calling method and method declaration is no longer required.
         */
        finally {
            throw new RuntimeException("Testing finally");
        }
    }
}
